package others.factory.springBeanFactory;

/**
 * @Author Linton
 * @Date 2019/7/7 22:19
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Train implements Moveable {
    @Override
    public void run() {
        System.out.println("小火车呜呜呜");
    }
}

