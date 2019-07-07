package others.proxy;

import java.util.Random;

/**
 * @Author Linton
 * @Date 2019/7/7 13:43
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Tank implements Moveable{

    @Override
    public void move() throws Exception {

        System.out.println("Tank Moving...");
        Thread.sleep(new Random().nextInt(10000));

    }

    @Override
    public void stop() {
        System.out.println("Tank stop.....");
    }
}

