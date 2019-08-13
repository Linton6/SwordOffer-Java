package swordOffer;

import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

import java.net.URL;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @Author Linton
 * @Date 2019/6/21 15:26
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class CodeTest {
    public static void main(String[] args) throws  Exception {
        CodeTest codeTest = new CodeTest();
//        InputStream in = new FileInputStream("D:/hello.txt");// 读取文件的数据,注意文件编码为UTF-8,防止读取乱码
//        // 将输入的字节流  ------转换成---->  字符流
//        InputStreamReader isr = new InputStreamReader(in);// 读取
//        System.out.println(isr.toString());
//        char[] data = new char[1024];
//        int len = isr.read(data);//读取字符流中的数据，用char[]数组一次性接收
//        System.err.println(new String(data, 0, len));
//        isr.close();
//        OutputStream out = System.err;// 打印到控制台，也可以输出到文件
//        OutputStreamWriter osr = new OutputStreamWriter(out);//输出 往out里面准备写内容，内容在下面
//        String str = "Hello World!";
//        osr.write(str);//写
//        //osr.flush();//如果用于网络传输，记得强制刷新缓冲区，否则输出的数据只停留在缓冲区中，而无法进行网络传输
//        osr.close();//关闭资源
//
//        System.out.println((int)'A');
//        System.out.println(((int)'z'));
//        System.out.println((char) ((int)'A' + 33));
        char[] ch = {'a','d'};
        System.out.println(ch.toString());





}

