package IO;

/**
 * @Author Linton
 * @Date 2019/8/12 18:14
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 缓冲区的出现是为了提高流的操作效率而出现的。缓冲区的本质：封装了一个数组作为对象，存储数据
 *
 * 所以在创建缓冲区之前，必须要先有流对象
 *
 * 该缓冲区提供了一个跨平台的换行符  newLine();
 */

public class BufferWriterDemo {
    public static void main(String[] args) throws IOException {
        // 创建一个字符写入流对象
        FileWriter fw = new FileWriter("buf.txt");
        /**
         * 为了提高字符写入流效率，加入缓冲技术
         * 只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可
         */
        BufferedWriter bufw = new BufferedWriter(fw);

        bufw.write("abc");
        bufw.newLine(); // 跨平台性的换行操作

        /** 其实关闭缓冲区，就是关闭缓冲区中的流对象*/
        bufw.close();

    }

}

