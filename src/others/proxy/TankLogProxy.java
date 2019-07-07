package others.proxy;

/**
 * @Author Linton
 * @Date 2019/7/7 13:52
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  通过 “聚合” 实现在原来的方法前后加上前置方法和后置方法    通过 ' 聚合' 实现代理
 */

public class TankLogProxy implements Moveable {

    private  Moveable t;

    public TankLogProxy(Moveable t) {
        super();
        this.t = t;
    }

    @Override
    public void move() throws Exception {
        System.out.println("Tank Start.....");
        t.move();
        System.out.println("Tank Stop....");
    }

    @Override
    public void stop() {

    }
}

