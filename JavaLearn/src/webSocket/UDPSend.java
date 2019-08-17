package webSocket;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 需求：通过upd传输方式，将一段文字数据发送出去
 * 思路：
 * 1. 简历updsocket服务
 * 2. 提供数据，并将数据封装到数据包DatagramPacket中
 * 3. 通过socket服务发送功能，将数据包发出去
 * 4. 关闭资源
 */
public class UDPSend {
    public static void main(String[] args) throws Exception {
        /**
         * 1. 创建udp服务。通过DatagramSocket对象
         */
        DatagramSocket ds = new DatagramSocket();
        /**
         * 2. 确定数据，并封装成数据包。DatagramPacket(byte[] buf, int length, InetAddress address, int port)
         */
        byte[] buf = "upd send!".getBytes();
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("169.254.81.15"),10000);
        /**
         * 3. 通过socket服务，将已有的数据包发送出去。通过send方法
         */
        ds.send(dp);
        /**
         * 4. 关闭资源
         */
        ds.close();
    }
}

