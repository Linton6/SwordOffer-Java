package nioChatRoom.com.imooc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @Date 2019/9/28 11:20
 * @客户端线程类，专门接受服务端响应信息
 */

public class NioClientHandler implements Runnable {

    private Selector selector;

    public NioClientHandler(Selector selector) {
        this.selector = selector;
    }


    @Override
    public void run() {
        try {
            for (;;) {

                int readyChannels = selector.select();// 阻塞方法，只有监听到注册的方法就绪了才会返回

                if (readyChannels == 0) {
                    continue;
                }

                /**
                 * 获取可用channel的集合
                 */
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    /**
                     * selectionKey实例
                     */
                    SelectionKey selectionKey = (SelectionKey) iterator.next();

                    /**
                     * 移除Set中的当前selectionKey
                     */
                    iterator.remove();

                    /**
                     * 根据就绪状态，调用对应方法处理语无逻辑
                     */

                    /**
                     * 如果是 可读事件
                     */
                    if (selectionKey.isReadable()){
                        readHandler(selectionKey, selector);
                    }


                    /**
                     *9.根据业务需要决定是否再次注册监听事件，重复执行第三步操作
                     */
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 可读事件处理器
     */
    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        /**
         *要从 selectionKey中获取到已经就绪的channel
         */
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        /**
         *创建buffer
         */
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        /**
         *循环读取服务器端响应信息
         */
        String response = "";
        while (socketChannel.read(byteBuffer) > 0) {
            /**
             *切换buffer为读模式
             */
            byteBuffer.flip();

            /**
             *读取buffer中的内容, 获得了客户端请求服务端的消息
             */
            response += Charset.forName("UTF-8").decode(byteBuffer);

        }

        /**
         *将channel再次注册到selector上，监听他的可读事件
         */
        socketChannel.register(selector, SelectionKey.OP_READ);

        /**
         *将服务端响应信息打印到本地信息
         */

        if (response.length() > 0) {
            // 广博给其他客户端
            System.out.println(response);
        }

    }

}