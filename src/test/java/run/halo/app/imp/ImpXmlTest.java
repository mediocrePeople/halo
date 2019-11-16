package run.halo.app.imp;

import org.dom4j.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import run.halo.app.Application;
import run.halo.app.model.entity.Post;
import run.halo.app.model.enums.PostStatus;
import run.halo.app.service.impl.PostServiceImpl;
import run.halo.app.utils.XmlTransferMapUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Desc: 导入博客园的备份(springboot整合junit)
 * @Author: Witt Zhang
 * @Date: 2019-11-15 11:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ImpXmlTest {

    @Autowired
    private PostServiceImpl postService;

    /**
     * 导入博客园的备份文章到halo系统
     * @throws ParseException
     */
    @Test
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
    @Test
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
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath,String token) throws IOException{
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
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
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
