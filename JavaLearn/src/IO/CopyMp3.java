package IO;

/**
 * @Author Linton
 * @Date 2019/8/13 22:56
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.io.*;

/**
 * 演示Mp3的复制。通过缓冲区
 * BufferedOutputStream
 * BufferedInputStream
 *
 */

public class CopyMp3 {
    public static void main(String[] args) {

    }

    /**
     * 通过字节流的缓冲区完成复制
     */

    public static void copy_1() throws IOException {
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("D:\\1.mp3")); // 目标文件
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("D:\\1.jpg"));  // 源文件

        int by = 0; // 监控文件是否已经读到末尾的状态,同时是读取到多少字节的个数

        while ((by = bufis.read()) != -1) {
            bufos.write(by); // 这块对by参数的理解不到位？？
        }

        bufis.close();
        bufos.close();
    }
}

