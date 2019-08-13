package IO;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author Linton
 * @Date 2019/8/12 16:34
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  读文件
 */

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        /**
         * 创建一个文件读取流对象，和指定名称的文件相关联
         * 要保证改文件是已经存在的，如果不存在，会发生异常FileNotFoundException
         */
        FileReader fr = new FileReader("FileWriterException.java");

        /**
         * @第一种读取方式：read（）
         * 调用读取流对象的read方法,一次读取单个字符
         * read()方法一次读一个字符，会自动往下读。返回：作为整数读取字符，范围在0-65535之间（0X0-0Xffff）,到达流的末尾，则返回 -1  所以循环读到 -1 就停
         */
        /*
        int ch = 0;
        while ((ch = fr.read() )!= -1){
            System.out.print((char)ch);
        }*/

        /**
         * 推荐
         * @第二种方式：通过字符数组进行读取：read(char[] cbuf)
         */
        // 定义一个字符数组，用于存储读到字符，该read(char[]) 返回的是读到字符个数 ,读不到字符的时候返回 -1
        char[] buf = new char[1024]; // 通常定义1024整数倍 1K
//        int num = fr.read(buf);
//        System.out.println("num="+ num + "..." + new String(buf));
        int num = 0;
        while ((num = fr.read(buf)) != -1){
            System.out.print(new String(buf, 0, num));
        }
        fr.close();

        /*
        while (true) {
            int ch = fr.read();
            if (ch == -1) {
                break;
            }
            System.out.println("ch=" +(char)ch);
        }
        fr.close();*/


    }

}

