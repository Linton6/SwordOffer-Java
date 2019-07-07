package others.coreJava;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/7/6 16:04
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class SockeTest {
    public static void main(String[] args) throws IOException {
        try(Socket s = new Socket("localhost",8189)){
            InputStream inStream = s.getInputStream();
            Scanner in = new Scanner(inStream);

            while (in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        }
        }
    }

