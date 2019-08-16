package IO;

/**
 * @Author Linton
 * @Date 2019/8/12 18:36
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符读取流缓冲区
 * 该缓冲区提供了一个一次读一行的方法 readLine()， 方便于对文本数据的获取
 * 当返回 null 时，表明到达文件末尾
 *
 * readLine() 方法返回的时候，只返回回车符之前的数据内容，并不返回回车符
 *
 *
 * 装饰设计模式：当想要对已有的对象进行功能增强时，可以自定义类，将已有对象传入，基于已有的功能，并提供加强功能，那么自定义的该类称为装饰类
 * 装饰类通常会通过构造方法接收被装饰的对象。并给予被装饰的对象的功能，提供更强的功能。
 *
 * 装饰（组合结构）和继承：设计模式是为了优化而存在的。
 * 装饰模式比继承要灵活，避免了继承体系臃肿，而且降低了类与类之间的关系。
 * 装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强功能。
 *
 * 字符流（有编码表,操作文本）：
 *        FileReader
 *        FileWriter
 *
 *        BufferedReader
 *        BufferedWriter
 * 字节流(默认编码，操作图片)：
 *
 *
 *
 */

public class BufferReaderDemo {
    public static void main(String[] args) throws IOException {
        // 创建一个读取流对象和文件相关联
        FileReader fr = new FileReader("buf.txt");

        // 为了提高效率，加入缓冲技术。将字符读取流对象作为参数传递给缓冲对象的构造函数
        BufferedReader bufr = new BufferedReader(fr);

        String line =null;

        while ((line = bufr.readLine()) != null) {
            System.out.println(line);
        }

        bufr.close();
    }
}

