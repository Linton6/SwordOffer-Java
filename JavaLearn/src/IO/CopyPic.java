package IO;

/**
 * @Author Linton
 * @Date 2019/8/13 22:42
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 复制一个图片
 * 思路：
 *  1. 用字节读取流对象和图片关联
 *  2. 用字节写入流对象创建一个图片文件。用于存储获取到的图片数据
 *  3. 通过循环读写，完成数据的存储
 *  4. 关闭资源
 *
 *  PS:使用字符流也可以复制，但是图片数据可能打不开。因为字符流在复制过程中，拿到字节回去查询编码表，如果能找到对应的字符，复制过去没问题，如果找不到对应的字符，
 *  会之随机指定一个未知字符，而这个未知字符复制过去，使得和原图片不一致，导致可能打不开。
 *
 *  所以不要用字符流复制多媒体
 */

public class CopyPic {
    public static void main(String[] args)  throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\2.jpg");  // 目标文件
            fis = new FileInputStream("D:\\1.jpg");  // 源文件

            byte[] buf = new byte[1024];
            int len = 0;

            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }

        } catch (IOException e) {
            throw  new RuntimeException("复制文件失败！");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            }catch (IOException e) {
                throw  new RuntimeException("读取关闭失败！");
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            }catch (IOException e) {
                throw  new RuntimeException("写入关闭失败！");
            }
        }
    }
}

