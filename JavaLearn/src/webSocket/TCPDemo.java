package webSocket;


/**
 * 演示TCP传输
 * @第一部分
 * 1.tcp分客户端和服务端
 * 2. 客户端对应的对象是Socket
 *      服务端对应的对象是ServerSocket
 *
 */

import java.io.*;
import java.net.*;

/**
 * 客户端：
 * 通过查阅socket对象，发现在该对象建立时，就可以去连接指定主机
 * 因为tcp是面向连接的。所以在建立socket服务时，就要有服务端存在，并连接成功。形成通路后，在该通道进行数据的传输
 */

/**
 * 客户端
 */
 class TCPClient {
    public static void main(String[] args) throws Exception {

        // 创建客户端的socket服务，制定目的主机和端口
        Socket s = new Socket("169.254.81.15",10007);

        // 为了发送数据，应该获取socket流中的输出流
        OutputStream out = s.getOutputStream();

        out.write("TCP data".getBytes());

        s.close();

    }
}

/**
 * 需求：定义端点接受数据并打印在控制台上
 *
 * 服务端：
 * 1.建立服务端的socket服务。ServerSocket();
 * 并监听一个端口
 * 2. 获取连接过来的客户端对象。
 * 通过ServerSocket的accept方法。没有连接就会等，所以这个方法阻塞式的
 * 3. 客户端如果发过来数据，那么服务端使用对应的客户端对象，并获取到该客户端对象的读取流来读取发过来的数据，打印在控制台
 * 4.关闭服务器（可选）
 */
class TCPServer{
    public static void main(String[] args) throws Exception {
        // 建立服务端socket服务，并监听一个端口。
        ServerSocket ss = new ServerSocket(10007);

        // 通过accept方法获取连接过来的客户端对象
        Socket s = ss.accept();

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"....connected");

        // 获取客户端发送过来的数据，那么要使用客户端对象的读取流来读取数据
        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];
        int len = in.read(buf);

        System.out.println(new String(buf, 0, len));

        s.close();// 关闭客户端
        ss.close(); // 关闭服务端

        System.out.println("Hello word!");
    }
}

/**
 * @第二部分
 * 演示TCP传输的客户端和服务端互访
 * 需求：客户端给服务端发送数据，服务端收到后，给客户端反馈信息
 */
/**
 * 客户端：
 * 1. 建立socket服务。指定要连接主机和端口
 * 2. 获取socket流中的输出流。将数据写到该流中。通过网络发送给服务端。
 * 3. 获取socket流中的输入流，将服务端反馈的数据获取到，并打印
 * 4. 关闭客户端资源
 */

class TcpClient2 {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("169.254.81.15",10004);

        OutputStream out = s.getOutputStream();

        out.write("服务端，你好".getBytes());

        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);

        System.out.println(new String(buf, 0, len));

        s.close();
    }
}

class TcpServer2 {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(10004);

        Socket s = ss.accept();

        String ip = s.getInetAddress().getHostAddress();

        System.out.println(ip + "...connected");

        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);

        System.out.println(new String(buf, 0, len));

        OutputStream out =  s.getOutputStream();

        out.write("收到，哥们你好".getBytes());

        s.close();
        ss.close();
    }
}


