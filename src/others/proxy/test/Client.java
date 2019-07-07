package others.proxy.test;

import others.proxy.InvocationHandler;
import others.proxy.Proxy;
import others.proxy.TimeHandler;

/**
 * @Author Linton
 * @Date 2019/7/7 18:18
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Client {
    public static void main(String[] args) throws Exception{
        UserMange mgr = new userMangeImpl();
        InvocationHandler h = new Tranctionhandler(mgr);
        // 两个代理叠加在一起
//        TimeHandler h2 = new TimeHandler(h);
        UserMange u = (UserMange)Proxy.newProxyInstance(UserMange.class, h);
        u.addUser();
    }
}

