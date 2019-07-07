package others.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Linton
 * @Date 2019/7/7 16:51
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 对任意一个方法进行自定义处理
 */

public class TimeHandler implements  InvocationHandler {

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object o) {
        this.target = o;
    }

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    private Object target;



    @Override
    public void invoke(Object o, Method m) {
        long start = System.currentTimeMillis();
        System.out.println("StartTime: " + start);
        System.out.println(o.getClass().getName());

        try {
            m.invoke(target);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));

    }
}

