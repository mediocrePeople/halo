package run.halo.app;

/**
 * @Desc:
 * @Author: Witt Zhang
 * @Date: 2020-06-13 14:04
 */
public class Test {

    public static void main(String[] args) {

        /*StringBuilder sb = new StringBuilder("abcdefgh1234567890");
        System.out.println(sb);
        String str = "abcdefgh1234567890";
        sb.delete(0,sb.length());
//        sb.append(null)
        System.out.println("-- CREATE TABLE".startsWith("--"));

        *//* sb.append(str.substring(2,2+6));*//*
//        System.out.println(sb);
//        System.out.println(sb.append("abc"));

        System.out.println("INSERT INTO SYSTEM_LOB_STREAM VALUES(".length());
        System.out.println("INSERT INTO SYSTEM_LOB_STREAM VALUES(0, 0, 'sadfasdfsa', NULL);".substring(37));

        String[] strs = "INSERT INTO SYSTEM_LOB_STREAM VALUES(0, 0, 'sadfasdfsa', NULL);".substring(37).split(", ?");
        for(String s: strs) System.out.println(s);

        System.out.println("-----------------------------------");

        StringBuilder sb2 = new StringBuilder("concat(");
        System.out.println(sb2.hashCode()); //683287027
        System.out.println(sb2.append("strs[2]").hashCode()); //683287027

        String line = "01'23456'789";
        int begin = line.indexOf("'");
        int end = line.lastIndexOf("'");
        System.out.println(begin + ", " + end);
        System.out.println(line.substring(begin,end+1));

        String test  = "<StreamingNo>abc</StreamingNo>";
//        test = test.replaceAll("abc", "1111111111$$");
        //会报异常java.lang.IllegalArgumentException: Illegal group reference，解决方法为改写以下形式：
        test = test.replaceAll("abc", java.util.regex.Matcher.quoteReplacement("dXNlcjM1NDk2NQ$$"));
        System.out.println(test);

        String str = "Hello Java. Java is a language.";
        System.out.println(str.replace("Java.", "c++"));//打印 Hello c++ Java is a language.
        System.out.println(str.replaceAll("Java.", "c++"));//打印 Hello c++ c++is a language.

        String[] split = "aaa".split("SYSTEM_COMBINE_CLOB\\(");
        System.out.println(split.length); // 1
        System.out.println(split[0]); // aaa
        System.out.println(split[1]); //报错：java.lang.ArrayIndexOutOfBoundsException: 1


        System.out.println("test{sdfs{  d }dk"
                .replace("{","\\\\{")
                .replace("}","\\\\}"));
        System.out.println("1,测试啊啊。\n "+ "2,对对对");
        */

        System.out.println(String.format("%s/archives/%s?preview=true&token=%s", "http://192.168.6.6:6666", "Ubuntu1804各类使用技巧", "6f69c061734a4069b6ca9d626d6ee35a"));

    }
}
