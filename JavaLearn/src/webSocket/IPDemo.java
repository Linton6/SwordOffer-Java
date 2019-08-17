package webSocket;

/**
 * @Author Linton
 * @Date 2019/8/16 9:49
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.net.*;
public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress i = InetAddress.getLocalHost();
//        System.out.println(i.toString());
//        System.out.println(i.getHostAddress());
//        System.out.println(i.getHostName());
        InetAddress ia = InetAddress.getByName("169.254.81.15");
        System.out.println(ia.getHostAddress());
        System.out.println(ia.getHostName());
    }
}

