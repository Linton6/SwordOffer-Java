package IO;

/**
 * @Author Linton
 * @Date 2019/8/12 18:46
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.io.*;

/**
 * 通过缓冲区复制 文本文件
 */

public class CopyTextByBuf {
    public static void main(String[] args)  {
        BufferedWriter bufw = null;
        BufferedReader bufr = null;

        try{
            bufw = new BufferedWriter(new FileWriter("bufr.txt"));
            bufr = new BufferedReader(new FileReader("FileWriterException.java"));

            String  line = null; /** @两个流之间是没有关系的，他们之前得有这个中转站 */

            while ((line = bufr.readLine()) != null) {
                bufw.write(line);
                bufw.newLine();
                bufw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("读写失败");
        }finally {
            if (bufr != null) {
                try {
                    bufr.close();
                }catch (IOException e){
                    throw new RuntimeException("读取关闭失败");
                }
            }if (bufw != null) {
                try {
                    bufw.close();
                }catch (IOException e){
                    throw new RuntimeException("写入关闭失败");
                }
            }
        }

    }
}

