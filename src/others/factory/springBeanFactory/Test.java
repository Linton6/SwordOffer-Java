package others.factory.springBeanFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author Linton
 * @Date 2019/7/7 22:18
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Test {
    public static void main(String[] args) throws Exception {
//        Moveable m = new Car();
        Properties pros = new Properties();
        pros.load(Test.class.getClassLoader().getResourceAsStream("others/factory/springBeanFactory/spring.properties"));
        String vehicleTypeName = pros.getProperty("VehicleType");
        System.out.println(vehicleTypeName);
        // 反射
        Object o = Class.forName(vehicleTypeName).newInstance();// 调用参数为空的构造方法
        Moveable m = (Moveable)o;
        m.run();

    }
}

