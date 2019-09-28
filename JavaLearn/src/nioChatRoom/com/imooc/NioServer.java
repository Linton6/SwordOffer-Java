package nioChatRoom.com.imooc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @Date 2019/9/28 10:13
 * @NIO 服务器端  https://www.imooc.com/video/19337
 */

public class NioServer {

    /**
     * 启动
     */
    public void  start() throws IOException {
        /**
         * 1.创建selector
         */

        Selector selector = Selector.open();

        /**
         * 2.通过ServerSocketChannel 创建channel通道
         */
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        /**
         * 3.为channel通道绑定监听端口
         */
        serverSocketChannel.bind(new InetSocketAddress(8000));

        /**
         * 4.将Channel设置为非阻塞模式
         */
        serverSocketChannel.configureBlocking(false);

        /**
         *5.将Channel注册到selector上，监听连接事件
         */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功！");
        /**
         *6.循环等待新接入的连接 / 循环调用selector的select方法，检测就绪情况
         */
        for (;;) { // while(true) 等价于for(;;) 区别：以前代码优化while是三条语句，for是1条语句；现在已经没有明确的代码差异了
            /**
             * TODO 获取可用的channel的数量
             */
          int readyChannels = selector.select();// 阻塞方法，只有监听到注册的方法就绪了才会返回
            /**
             * TODO 为什么要这样做？
             */
            if (readyChannels == 0) {
                continue;
            }

            /**
             *7. 根据就绪状态，调用对应方法处理业务逻辑 / 调用selectorKey方法获取就绪channel集合
             */
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
                 *8.判断就绪时间种类，调用业务处理方法
                 */

                /**
                 * 如果是  接入事件
                 */
                if (selectionKey.isAcceptable()) {
                    acceptHandler(serverSocketChannel, selector);
                }
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
    }

    /**
     * 接入事件处理器
     */
    private void acceptHandler(ServerSocketChannel serverSocketChannel,
                               Selector selector) throws IOException {
        /**
         * 如果是接入事件，创建socketChannel
         */
       SocketChannel socketChannel =  serverSocketChannel.accept();

        /**
         *将socketChannel设置为非阻塞工作模式
         */
        socketChannel.configureBlocking(false);

        /**
         *将channel注册到selector上，监听 可读事件
         */
        socketChannel.register(selector, SelectionKey.OP_READ);// 现在这个channel就归selector管理了

        /**
         *回复客户端 提示信息
         */

        socketChannel.write(Charset.forName("UTF-8")
                .encode("你与聊天室其他人都不是朋友关系，请注意隐私安全"));

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
         *循环读取客户端请求信息
         */
        String request = "";
        while (socketChannel.read(byteBuffer) > 0) {
            /**
             *切换buffer为读模式
             */
            byteBuffer.flip();

            /**
             *读取buffer中的内容, 获得了客户端请求服务端的消息
             */
            request += Charset.forName("UTF-8").decode(byteBuffer);

        }

        /**
         *将channel再次注册到selector上，监听他的可读事件
         */
        socketChannel.register(selector, SelectionKey.OP_READ);

        /**
         *将客户端发送的请求信息  广博给其他客户端
         */

        if (request.length() > 0) {
            // 广博给其他客户端
            System.out.println(request);
            broadCast(selector, socketChannel, request);
        }
    }

    /**
     * 广播给其他客户端
     */
    private void broadCast(Selector selector, SocketChannel sourceChannel, String request) {
        /**
         * 获取到所有已接入的客户端channel
         */
        Set<SelectionKey> selectionKeySet = selector.keys();
        selectionKeySet.forEach(selectionKey -> {
           Channel targetChannel =  selectionKey.channel();

           // 剔除发消息的客户端
           if (targetChannel instanceof SocketChannel
                   && targetChannel != sourceChannel) {
               try {
                   // 将信息发送到targetChannel客户端
                   ((SocketChannel) targetChannel).write(Charset
                           .forName("UTF-8").encode(request));
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        });

        /**
         * 循环向所有channel广播信息
         */

    }

    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) throws IOException {
        NioServer nioServer = new NioServer();
        nioServer.start();
    }
}

