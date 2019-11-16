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

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    @Test
    public void xmlTransMapTest() throws ParseException {
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

        for (Element item:items){
            title.append(item.elementText("title"));
            link.append(item.elementText("link"));
//            String author = item.elementText("author");
            pubDate.append(item.elementText("pubDate"));
            content.append(item.elementText("description"));

            //提取url
            index = link.lastIndexOf("/");
            url.append(link.toString().substring(index+1).split("\\.")[0]);

            //转换发布时间： Thu, 14 Nov 2019 09:51:00 GMT转换为timestamp
            System.out.println("|"+pubDate.substring(0,25)+" +0800|");
            Date date = df.parse(pubDate.substring(0,25) + " +0800");
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
            if(updatedPost == null) throw new RuntimeException("导入文章失败！");

            //清空stringbuilder中的内容，用于下一次的循环
            title.delete(0,title.length());
            link.delete(0,link.length());
            url.delete(0,url.length());
            pubDate.delete(0,pubDate.length());
            content.delete(0,content.length());
        }
        System.out.println("所有文章都导入成功！");
    }
}
