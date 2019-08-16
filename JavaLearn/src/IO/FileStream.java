package IO;

/**
 * @Author Linton
 * @Date 2019/8/13 22:12
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  * 字符流（有编码表,操作文本）：
 *  *        FileReader
 *  *        FileWriter
 *  *
 *  *        BufferedReader
 *  *        BufferedWriter
 *
 *  * 字节流(默认编码，操作图片等多媒体文件)：(凡是输出的都是写)
 *  *  抽象基类：      InputStream(读)   OutputStream(写)              PS：字节流使用的是字节数组，字符流使用的是字符数组
 *
 *  需求：想要操作图片数据。需要用字节流
 */
public class FileStream {
    public static void main(String[] args) throws IOException{
//        writeFile();
        readFile_3();
    }
    /**
     * 第三种读取方式（字节流特有）  【文件过大，会发生内存溢出，不建议使用，推荐第二种读取方式】
     * 一次性得到文件字节数量
     */
    public static void readFile_3() throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");

        /**
         * 得到文件里所有的字节数量
         */
        int n = fis.available();
        byte[] buf = new byte[n];  // 定义一个刚刚好的缓冲区。不用再循环了

        fis.read(buf); // 把文件中的内容读取到buf

        System.out.println(new String(buf));

        fis.close();
    }

    /**
     * 第二种读取方式【推荐】
     * 读一块打印一块 (类似字符流)
     */

    public static void readFile_2() throws IOException{
        FileInputStream fis = new FileInputStream("fos.txt");

        byte[] buf = new byte[1024];

        int len = 0;


        while ((len = fis.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        fis.close();
    }
    /**
     * 第一种读取方式
     * 读一个打印一个 (类似字符流)
     * @throws IOException
     */
    public static void readFile_1() throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");

        int ch = 0;

        while ((ch = fis.read()) != -1 ){
            System.out.println((char)ch);
        }
        fis.close();
    }


    /**
     * @写字节流
     * @throws IOException
     */
    public static void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt");


        /**
         * // 字符串转化为字节数组
         */
        fos.write("abs".getBytes());

        /**
         * 如果没有指定缓冲区，字节流不需要像字符流那样 刷新缓冲。 字符流的底层用的字节流，多了一个编码方式，缓存字节去查表转化为字符，所以需要flush方法
         */

        fos.close();
    }
}

