package IO;

/**
 * @Author Linton
 * @Date 2019/8/13 22:12
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

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
 *  * 字节流(默认编码，操作图片)：(凡是输出的都是写)
 *  *  抽象基类：      InputStream(读)   OutputStream(写)              PS：字节流使用的是字节数组，字符流使用的是字符数组
 *
 *  需求：想要操作图片数据。需要用字节流
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException{
        writeFile();
    }

    public static void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt");

        fos.write("abs".getBytes()); // 字符串转化为字节数组
    }
}

