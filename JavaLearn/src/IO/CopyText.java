package IO;

/**
 * @Author Linton
 * @Date 2019/8/12 17:14
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  将C盘的一个文本文件复制到D盘
 *
 *  复制原理：其实就是讲C盘下的数据存储到D盘的一个文件中
 *  步骤：
 *  1，在D盘创建一个文件。用于存储C盘文件中的数据
 *  2，定义读取流和C盘文件关联
 *  3，通过不断的读写完成数据存储
 *  4，关闭资源
 */
public class CopyText {

    public static void main(String[] args) throws IOException{
        copy_2();

    }
    /**
     * 从C盘读取字符块，再往D盘写，效率提高
     */
    private static void copy_2() throws IOException{
        FileWriter fw = null;
        FileReader fr = null;
        try {
            // 创建目的地
            fw = new FileWriter("FileWriterException_copy.java");
            // 创建流fr，和已有文件关联
            fr = new FileReader("FileWriterException.java");
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fr.read(buf)) != -1) {
                fw.write(buf, 0 ,len);
            }
        } catch (IOException e) {
            throw new RuntimeException("读写失败");
        } finally {
            if (fr != null)
                fr.close();  // 需要try catch
            if (fw != null) // 需要try catch
                fw.close();

        }


    }


    /**
     *  从C盘读一个字符，就往D盘写一个字符，效率不高
     */
    private static void copy_1() throws IOException {
        // 创建目的地
        FileWriter fw = new FileWriter("FileWriterException_copy.java");
        // 创建流fr，和已有文件关联
        FileReader fr = new FileReader("FileWriterException.java");
        int ch = 0;
        while ((ch = fr.read()) != -1) {
            fw.write((char)ch);
        }
        fr.close();
        fw.close();

    }

}

