package others.proxy;

import java.lang.reflect.Method;

/**
 * @Author Linton
 * @Date 2019/7/7 16:15
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 反射  测试 一个类有多少方法
 */

public class Test2 {
    public static void main(String[] args) {
        Method[] methods = others.proxy.Moveable.class.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }
}

