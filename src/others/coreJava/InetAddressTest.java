package others.coreJava;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @Author Linton
 * @Date 2019/7/6 16:19
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class InetAddressTest {
    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress[] addresses = InetAddress.getAllByName("www.taobao.com");
        for (InetAddress a : addresses){
            System.out.println(a);
        }

    }
}

