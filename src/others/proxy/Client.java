package others.proxy;

/**
 * @Author Linton
 * @Date 2019/7/7 13:48
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 可以对任意的对象、任意的接口方法、实现任意的代理
 */

public class Client {

    public static void main(String[] args) throws Exception {
        Tank t = new Tank();

       InvocationHandler h =  new TimeHandler(t);

        Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class, h); // 所有的代理都由这个方法产生

        m.move();
    }
}

