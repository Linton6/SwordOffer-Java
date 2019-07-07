package others.proxy.test;

import others.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @Author Linton
 * @Date 2019/7/7 18:15
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Tranctionhandler implements InvocationHandler {
    public Tranctionhandler(Object target) {
        super();
        this.target = target;
    }

    private  Object target;

    @Override
    public void invoke(Object o, Method m) {
        System.out.println("Transcation Start");

        try {
            m.invoke(target);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Transcation Commit");


    }
}

