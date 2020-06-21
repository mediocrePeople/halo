package run.halo.app.imp;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import run.halo.app.Application;
import run.halo.app.model.entity.Post;
import run.halo.app.model.enums.PostStatus;
import run.halo.app.service.impl.PostServiceImpl;
import run.halo.app.utils.MarkdownUtils;
import run.halo.app.utils.XmlTransferMapUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Desc: 1. 导入博客园的备份(springboot整合junit)
 *        2. H2导出的sql文件数据导入到MySQL
 * @Author: Witt Zhang
 * @Date: 2019-11-15 11:43
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
public class ImpXmlTest {

    @Autowired
    private PostServiceImpl postService;
    @Autowired
    private EntityManager em;

    private Query query;
    private static Connection conn;
    private static Statement stat;

    /*
     * @Before：在每个测试方法之前都执行一次, 方法需要声明为public
     * @BeforeClass：只在类中执行一次, 必须声明为public static
     *          否则报错：java.lang.Exception: Method beforeClass() should be static
     * @After和@AfterClass也是一样。
     */
    @BeforeClass
    public static void beforeClass(){
        try {
            String url = "jdbc:mysql://192.168.6.16:3306/halo?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
//            String url = "jdbc:mysql://127.0.0.1:3306/halo?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void afterClass(){
        if(null != stat){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null != conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * EntityManager 创建并执行复杂原生SQL
     * @param sql
     * @param paramList
     * @return int
     */
    public int postInsert(String sql, List<String> paramList){
        //插入数据到数据表POSTS
        /*
        sql举例：
        sql = "INSERT INTO `halo`.`posts` VALUES " +
                "(0, 279, TIMESTAMP '2019-06-15 09:54:00', 0, " +
                "TIMESTAMP '2019-11-16 21:48:56.089', 0, 0, TIMESTAMP '2019-06-15 09:54:00', " +
                "'FORMAT_CONTENT_1', 0, 'ORIGINAL_CONTENT_1', '', 0, '', '', '', " +
                "'第2节 mapreduce深入学习：14、mapreduce数据压缩-使用snappy进行压缩', 0, 'uri1', 1)";*/
        int count = 0;

        // EntityManager创建复杂原生SQL，占位式
        query = em.createNativeQuery(sql);

        for (int i=0; i < paramList.size(); i++){
            query.setParameter(i+1,paramList.get(i));
        }

        // 返回值：由于是一个insert操作，成功则返回操作的条数，没有数据改变则返回0
        count = query.executeUpdate();
        if(count >= 1)
            System.out.println("插入成功，本次插入记录条数 === " + count + "！");
        else
            System.out.println("插入失败，本次插入记录条数 === " + count + "！");

        return count;
    }

    /**
     * 利用原始java方法执行insert语句
     * @param sql
     * @return int
     */
    public int postInsert2(String sql) {
        int count = 0;
        try {
            stat = conn.prepareStatement(sql);
            count = stat.executeUpdate(sql);
            if(count >= 1)
                System.out.println("插入成功，本次插入记录条数 === " + count + "！");
            else
                System.out.println("插入失败，本次插入记录条数 === " + count + "！");

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    /**
     * H2导出的sql文件数据导入到MySQL
     * @throws IOException
     */
    //必须要在方法上添加@Transactional和@Modifying注解！
    // 否则报错：javax.persistence.TransactionRequiredException: Executing an update/delete query
    @Transactional //支持事物，@SpringBootTest 事物默认自动回滚
    // @Rollback 事务自动回滚；@Rollback(false)不自动回滚
    // 事务自动回滚后提示：o.s.t.c.transaction.TransactionContext   : Rolled back
    // 事务提交后提示：o.s.t.c.transaction.TransactionContext   : Committed
    @Rollback(false)
    @Modifying
    @Test
    public void impHaloDataToMySQL() throws IOException {
        //源文件路径
        String path = "data/haloNew_postdata_5.sql";

        File file = null;
        BufferedReader br = null;
        file = new File(path);
        br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        StringBuilder sql = new StringBuilder();
        String line = "";

        int lineNum = 0; //读取的行的计数器
        int insertNum = 0; //posts表的插入操作的次数的计数器
        int insertCount = 0; //总共插入posts表的记录数的计数器

        //SYSTEM_LOB_STREAM表，该表中的每一条记录分别存储文章的一部分内容
        int begin = 0;
        int end = 0;
        // 存放SYSTEM_LOB_STREAM中的文章内容，对应posts表中的FORMAT_CONTENT和ORIGINAL_CONTENT
        Map<Integer,StringBuilder> map = new HashMap<>();
        // 存放insert语句的参数列表
        List<String> paramList = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            lineNum++;

            if(line.startsWith("INSERT INTO `halo`.`posts` VALUES")){
                // eg. INSERT INTO `halo`.`posts` VALUES
                sql.append(line);
            }else if(line.startsWith("(0, ")){
                /*
                eg.
                (0, 38, TIMESTAMP '2019-11-05 08:44:00', 0, TIMESTAMP '2020-01-14 15:45:22.956', 0, 0, TIMESTAMP '2020-01-14 15:45:22.949', SYSTEM_COMBINE_CLOB(2), 0, SYSTEM_COMBINE_CLOB(3), '', 0, '', '', '', '安装ubuntu18.04.3全过程', 0, '11799496', 47),
                 */
//                if(line.contains("SYSTEM_COMBINE_CLOB(")){ // 不需要这个判断了，可以统一起来处理

                    //分割当前行的文本，为一个字符串数组
                    String[] splits = line.split("SYSTEM_COMBINE_CLOB\\(");
//                    Integer.parseInt(split[1].split("\\),")[0]); //streamid

                    for(int i = 1; i < splits.length; i++){
                        //获取SYSTEM_COMBINE_CLOB(2)中的数字2，然后调用map.get(2)方法，获取key “2” 对应的值，作为insert的参数
                        //  栗子中的数字2，就是for循环中的i
                        StringBuilder lobStr = map.get(Integer.parseInt(splits[i].split("\\),")[0])).append("'");
                        line = line.replaceFirst("SYSTEM_COMBINE_CLOB\\([0-9]+?\\)",
                                                    Matcher.quoteReplacement(lobStr.toString()));

    //                    paramList.add(Matcher.quoteReplacement(lobStr1.toString()));
//                        paramList.add(lobStr.toString());
    //                    line = line.replaceFirst("SYSTEM_COMBINE_CLOB\\([0-9]+?\\)","?");
    //                    paramList.add(Matcher.quoteReplacement(lobStr1.toString()));
                    }
//                }

                sql.append(line);

                if(line.trim().endsWith(");")){
                    insertCount += postInsert2(sql.toString());
//                    paramList.clear();
                    insertNum++;
                    sql.delete(0, sql.length());
                    map.clear();
                    System.out.println("到本次操作为止：本次读取数据的行号：" + lineNum + "，插入操作数 === " + insertNum + "，插入记录数 === " + insertCount);
                }

            }else if(line.startsWith("INSERT INTO SYSTEM_LOB_STREAM")){

                String[] strs = line.substring(37).split(", ?");

                // content不能使用strs[2])，因为line中有很多的逗号，很可能切割时漏掉一部分内容
                begin = line.indexOf("'");
                end = line.lastIndexOf("'");

                //concat('aa','bb')
                StringBuilder content = map.get(Integer.parseInt(strs[0]));
                if(null == content || content.length() == 0)
                    map.put(Integer.parseInt(strs[0]),new StringBuilder(line.substring(begin,end)));
                else
                    map.put(Integer.parseInt(strs[0]),content.append(line.substring(begin+1,end)));
            }else if(StringUtils.isBlank(line) || line.startsWith("CREATE ") || line.startsWith("--")){
                continue;
            }
        }

        System.out.println("本次任务：共计读取行数 === " + lineNum + "，共计插入操作数 === " + insertNum + "，共计插入记录数 === " + insertCount);
        if(null != br)
            br.close();
    }

    /**
     * 导入博客园的备份文章到halo系统
     * @throws ParseException
     */
//    @Test
    public void impArticles() throws ParseException {
//        String userHome = System.getProperty("user.home");
        System.out.println("文章开始导入！");
        XmlTransferMapUtils utils = new XmlTransferMapUtils();

//        File sfile = new File("src/main/resources/data/sample.xml");
        File sfile = new File("src/main/resources/data/CNBlogs_BlogBackup_131_201811_201911.xml");
//        File sfile = new File("src/test/resources/sampleTest.xml");
//        System.out.println(sfile.getPath());
//        System.out.println(sfile.exists());

        Element root = utils.getRootElement(sfile);

        List<Element> items = root.elements("item");

//        System.out.println(items.size());
//        System.out.println("test hot deploy");
        StringBuilder title = new StringBuilder();
        StringBuilder link = new StringBuilder();
        StringBuilder url = new StringBuilder();
        StringBuilder pubDate = new StringBuilder();
        StringBuilder content = new StringBuilder();
        int index = 0;
        DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

        for (Element item : items) {
            title.append(item.elementText("title"));
            link.append(item.elementText("link"));
//            String author = item.elementText("author");
            pubDate.append(item.elementText("pubDate"));
            content.append(item.elementText("description"));

            //提取url
            index = link.lastIndexOf("/");
            url.append(link.toString().substring(index + 1).split("\\.")[0]);

            //转换发布时间： Thu, 14 Nov 2019 09:51:00 GMT转换为timestamp
            System.out.println("|" + pubDate.substring(0, 25) + " +0800|");
            Date date = df.parse(pubDate.substring(0, 25) + " +0800");
//            System.out.println("{ \n" + title + "\n" + url + "\n" + date + "\n" + content + "\n}\n");

            //插入数据到数据表POSTS
            Post post = new Post();
            post.setCreateTime(date);
            post.setUpdateTime(date);
            post.setEditTime(date);
            post.setFormatContent(content.toString());
            post.setOriginalContent(content.toString());
            post.setStatus(PostStatus.PUBLISHED);
            post.setTitle(title.toString());
            post.setUrl(url.toString());

            Post updatedPost = postService.createOrUpdateBy(post);
            if (updatedPost == null) throw new RuntimeException("导入文章失败！");

            //清空stringbuilder中的内容，用于下一次的循环
            title.delete(0, title.length());
            link.delete(0, link.length());
            url.delete(0, url.length());
            pubDate.delete(0, pubDate.length());
            content.delete(0, content.length());
        }
        System.out.println("所有文章都导入成功！");
    }


    /**
     * 下载博客园的图片到~/.halo/upload/yyyy/MM/，然后替换文章中的图片的url，链接到本地系统的图片
     * 博客园的图片url格式：
     * https://img2018.cnblogs.com/blog/1325651/201908/1325651-20190822204237979-830948634.jpg
     * https://img2018.cnblogs.com/blog/1325651/201906/1325651-20190629100238025-1847721101.png
     * https://img2018.cnblogs.com/common/1325651/201911/1325651-20191113162133865-1483608727.png
     * https://img2018.cnblogs.com/i-beta/1325651/201911/1325651-20191113162133865-1483608727.png
     * halo的图片url格式：
     * http://mediocrepeople.tpddns.cn:9999/upload/2019/11/1f44d-5fd5044c1e164476a09accf364039553.png
     *
     */
//    @Test
    public void impImages() throws IOException {
        System.out.println("图片开始导入！");

        List<Post> posts = postService.listAllBy(PostStatus.PUBLISHED);

        int i = 1;
        int j = 0;
        int k = 0;
        int n = 0;
        StringBuilder initialURL = new StringBuilder();
        StringBuilder updatedURL = new StringBuilder();
        String originalContent = "";
        String formatContent = "";

        for (Post post : posts) {
            originalContent = post.getOriginalContent();
            formatContent = post.getFormatContent();

            //利用正则表达式截取出所有图片url，注意：一篇文章中可能有多个图片url！
            String regex = "https://img2018\\.cnblogs\\.com/.*?/1325651/201.*?\\.(png|jpg|bmp)";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(formatContent);
            System.out.println("文章" + i + " 包含的图片url： ");
            n = j;
            while (m.find()) {
                initialURL.append(m.group());
                j++;
                System.out.println(j + ": " + initialURL);

                String[] split = initialURL.toString().split("/");

                /* //从URL中下载博客园的图片到本地系统
                //文件保存位置
                String savePath = "/home/witt/halo-dev333/upload/" + split[5].substring(0, 4) + "/" + split[5].substring(4);
                String token="v32Eo2Tw+qWI/eiKW3D8ye7l19mf1NngRLushO6CumLMHIO1aryun0/Y3N3YQCv/TqzaO/TFHw4=";
                downLoadFromUrl(initialURL.toString(),split[6],savePath,token);*/

                //替换文章中的图片的url，使url链接到halo系统的图片
                //  https://img2018.cnblogs.com/blog/1325651/201905/1325651-20190526230739405-345299240.png
                //  http://mediocrepeople.tpddns.cn:9999/upload/2019/11/1f44d-5fd5044c1e164476a09accf364039553.png
                updatedURL.append("http://mediocrepeople.tpddns.cn:9999/upload/")
                        .append(split[5].substring(0,4))
                        .append("/")
                        .append(split[5].substring(4))
                        .append("/")
                        .append(split[6]);
                System.out.println(j + ": " + updatedURL);
                originalContent = originalContent.replace(initialURL,updatedURL);
                formatContent = formatContent.replace(initialURL,updatedURL);

                post.setOriginalContent(originalContent);
                post.setFormatContent(formatContent);

                //清空StringBuilder，用于下一次循环
                initialURL.delete(0,initialURL.length());
                updatedURL.delete(0,updatedURL.length());
            }
            if(j > n) k++;
            i++;

            //清空StringBuilder，用于下一次循环
            originalContent = "";
            formatContent = "";
        }

        //批量更新所有的文章的图片url
        postService.updateInBatch(posts);

        System.out.println("所有图片url都导入成功！共计处理了 " + k + " 篇文章、 "+ j +" 个图片url！");
    }


    /**
     * 将POSTS表中的ORIGINAL_CONTENT从html格式转换为markdown格式
     */
//    @Test
    public void renderHtmlToMd(){
        System.out.println("文章初始内容转换开始！");
        List<Post> posts = postService.listAllBy(PostStatus.PUBLISHED);
        int i = 0;

        for (Post post : posts) {
            //如果original_content字段中包含如下格式<p></p>，则进行转换，否则不用转换：
            //      <p class="md-end-block md-p"><span class="md-plain">密码 (x, 表示加密的密码)</span></p>
            String regex = "(<p.*?>.*?</p>)|(<div.*?>.*?</div>)|(<pre.*?>.*?</pre>)";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(post.getOriginalContent());

            if(m.find()){
//                System.out.println("文章" + (++i) + ": ");
//                System.out.println(post.getOriginalContent());
//                System.out.println();
                post.setOriginalContent(MarkdownUtils.renderMarkdown(post.getOriginalContent()));
                Post updatedPost = postService.createOrUpdateBy(post);
                if (updatedPost == null) throw new RuntimeException("文章初始内容失败！");
                i++;
            }
        }
        System.out.println("所有文章的初始内容都转换完成！共计转换篇"+i+"文章！");
    }

    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public void downLoadFromUrl(String urlStr,String fileName,String savePath,String token) throws IOException{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        conn.setRequestProperty("lfwywxqyh_token",token);

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()) saveDir.mkdirs();

        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }


//        System.out.println("info:"+url+" 下载成功！ ");
        System.out.println("info：该图片下载成功！ ");

    }


    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

}
