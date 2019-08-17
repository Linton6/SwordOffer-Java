package webSocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 需求：定义一个应用程序，用于接收udp协议传输的数据并处理
 *
 *
 * 定义UDP接收端。
 * 思路：
 * 1. 定义udpsocket服务。
 * @通常会监听一个端口，其实就是给这个接受网络应用程序定义数字标识（否则系统随机）。方便与明确哪些数据过来，应用程序可以处理
 * 2. 定义一个数据包，因为要存储接受到的字节数据。因为数据包对象中有更多的功能可以提取字节数据中的不同信息
 * 3. 通过socket服务的receive方法收到的数据存入已定义好的数据包。
 * 4. 通过数据包对象的特有功能。将这些不同的数据取出，打印在控制台上。
 * 5. 关闭资源
 */
public class UDPRecive {

    public static void main(String[] args)  throws Exception{
        /**
         * 1. 创建UDP socket， 简历端点
         */
        DatagramSocket ds = new DatagramSocket(10000);
        /**
         * 2. 定义数据包。用于存储数据
         */
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        /**
         * 3. 通过服务的receive方法将收到的数据存入数据包中
         */
        ds.receive(dp);
        /**
         * 4. 通过数据包的方法获取其中的数据
         */
        String ip = dp.getAddress().getHostAddress();
        String data = new String(dp.getData(),0, dp.getLength());
        int port = dp.getPort();

        System.out.println("ip:" + ip + " data:" + data +" port:" +port);
        /**
         * 5. 关闭资源
         */
        ds.close();
    }

}

