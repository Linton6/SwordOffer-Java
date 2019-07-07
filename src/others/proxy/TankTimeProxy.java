
/**
 * @Author Linton
 * @Date 2019/7/7 13:52
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 * 通过 “聚合” 实现在原来的方法前后加上前置方法和后置方法
 *
 * 通过 ' 聚合' 实现代理, 可以灵活组合各种代理！！！！
 *
 * 被代理的类都得实现一个接口Proxy
 * AOP思想是动态代理的一种应用
 */
package others.proxy;
public class TankTimeProxy implements Moveable {

    private  Moveable t;



    public TankTimeProxy(Moveable t) {
        super();
        this.t = t;
    }

    @Override
    public void move() throws Exception {
        long start = System.currentTimeMillis();
        t.move();
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
    }

    @Override
    public void stop() throws Exception  {
        long start = System.currentTimeMillis();
        t.stop();
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));

    }
}

