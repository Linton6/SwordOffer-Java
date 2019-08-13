package IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author Linton
 * @Date 2019/8/12 16:10
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 *
 * 毕向东 ： 18-08 IO 异常的处理方式
 */

public class FileWriterException  {
    public static void main(String[] args) {
        /**
         * fw在外部建立引用，try语句块初始化   window下目录分隔符 \\
         */
        FileWriter fw = null;
        try {
             fw = new FileWriter("test.txt");

            fw.write("asda67f");


        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("catch" + e.toString());
        } finally {
            try {
                if (fw != null)  // 需要对fw不等于空做判断
                    fw.close();

            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

