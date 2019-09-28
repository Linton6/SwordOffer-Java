package nioChatRoom.com.imooc;

import java.io.IOException;

/**
 * @Date 2019/9/28 16:41
 * @
 */

public class BClient {
    public static void main(String[] args) throws IOException {
        NIOClient nioClient = new NIOClient();
        nioClient.start("B-Client");
    }
}

