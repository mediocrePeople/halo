package run.halo.app.imp;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Desc: RegexTest
 * @Author: Witt Zhang
 * @Date: 2019-11-16 17:21
 */
public class RegexTest {

    @Test
    public void test() {
        String str = "<p>&nbsp;</p>\n" +
                "<p class=\"test\">&lt;#if (str1?? &amp;&amp; str1!='') || (str2?? &amp;&amp; str2!='')&gt;</p>\n" +
                "<p>　　xxx</p>https://img2018.cnblogs.com/blog/1325651/201908/1325651-20190822204237979-830948634.jpg<p>&nbsp;</p>\n" +
                "<p>&lt;#if (str1?? &amp;&amp; str1!='') || (str2?? &amp;&amp; str2!='')&gt;</p>\n" +
                "<p>　　https://img2018.cnblogs.com/blog/1325651/201906/1325651-20190629100238025-1847721101.pngxxx</p>\n" +
                "<p>str1??： 变量str1不为null，则为真，执行&lt;#if&gt;中的内容；</p>\n" +
                "<p>xcopy D:\\dir1\\* Z:\\test /d/e/j/f/v/k/h/y/z</p>\n" +
                "<p>net ushttps://img2018.cnblogs.com/common/1325651/201911/1325651-20191113162133865-1483608727.pnge Z: /del</p>\n" +
                "<p>@echo 数据库每日备份到远程服务器任务结束......</p>"+
                "<p>afsahttps://img2018.cnblogs.com/i-beta/1325651/201911/1325651-20191113162133865-1483608727.pngdfsad</p>"+
                "<p>str1!=''： 变量str1不是空字符串，则为真，执行&lt;#if&gt;中的内容；</p>";

//        str = "<p><img src=\"https://img2018.cnblogs.com/blog/1325651/201905/1325651-20190527222121953-1870246020.png\" alt=\"\" width=\"532\" height=\"710\" />-----<img src=\"https://img2018.cnblogs.com/blog/1325651/201905/1325651-20190527222715205-1033729331.jpg\" alt=\"\" width=\"530\" height=\"708\" /></p>\n<p>&nbsp;</p>";

        //正则表达式
//        String regex = "https://img2018\\.cnblogs\\.com/.*?/1325651/201.*?\\.(png|jpg)";
        String regex = "<p.*?>.*?</p>";
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(str);
        while(m.find()) {
//                String group = m.group();
                System.out.println(m.group());
//                System.out.println(m.group(1));
//                System.out.println(m.group(2));
        }
    }
}
