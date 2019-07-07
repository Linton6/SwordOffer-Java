package others.proxy;

/**
 * @Author Linton
 * @Date 2019/7/7 13:50
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  此方式不推荐
 *
 * 通过 “继承” 在原来的方法前后加上前置方法和后置方法
 * 通过 '继承' 实现代理
 */

public class Tank2 extends Tank{
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        try {
            super.move();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
    }
}

