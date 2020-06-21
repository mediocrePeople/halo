package run.halo.app.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Desc:
 * @Author: Witt Zhang
 * @Date: 2020-06-13 13:37
 */
public class UnicodeDecoder {


    public static void main(String[] args) throws IOException {
        //源文件路径
        String path = "/home/witt/bak/.halo/halo.sql";
        //输出文件路径
        File write = new File("/home/witt/bak/.halo/haloNew.sql");

        File file = null;
        BufferedReader br = null;
        BufferedWriter bw = new BufferedWriter(new FileWriter(write));
        file = new File(path);
        br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
            bw.write(ascii2Native(sb.toString()) + "\n");
            bw.flush();
            sb = new StringBuilder();
        }

        bw.close();
        br.close();

    }

    public static String ascii2Native(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
//        String tmp = "";
        int begin = 0;
        int index = str.indexOf("\\u");
        while (index != -1) {

            sb.append(str.substring(begin, index));
            tmp.delete(0,tmp.length());
            tmp.append(str.substring(index,index+6));
//            tmp = str.substring(index,index+6);
            if("\\users".equals(tmp.toString()) || "\\u(\\\\\\".equals(tmp.toString()))
                sb.append(tmp.toString());
            else
                sb.append(ascii2Char(tmp.toString()));
            begin = index + 6;
            index = str.indexOf("\\u", begin);
        }
        sb.append(str.substring(begin));
        return sb.toString();
    }

    private static char ascii2Char(String str) {

        if (str.length() != 6) {
            System.out.println(str);
            throw new IllegalArgumentException("长度不足6位");
        }
        if (!"\\u".equals(str.substring(0, 2))) {
            System.out.println(str);
            throw new IllegalArgumentException("字符必须以 \"\\u\"开头.");
        }
        if ("\\users".equals(str) || "\\u(\\\\\\".equals(str)) {
            System.out.println(str);
            throw new IllegalArgumentException("\\users 和 \\u(\\\\\\ 不用转换.");
        }

        String tmp = str.substring(2, 4);
        int code = Integer.parseInt(tmp, 16) << 8;
        tmp = str.substring(4, 6);
        code += Integer.parseInt(tmp, 16);
        return (char) code;
    }
}