package others.proxy;

import java.lang.reflect.Method;

/**
 * @Author Linton
 * @Date 2019/7/7 16:49
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description JDK 代理模式
 */

public interface InvocationHandler {
    public void invoke(Object o , Method m) ;
}

