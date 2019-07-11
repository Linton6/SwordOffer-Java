package others.factory.springBeanFactory;

import others.factory.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Linton
 * @Date 2019/7/7 18:47
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Car implements Moveable  {

    private static Car car  = new Car();    // 单例

    private static List<Car> cars = new ArrayList<>(); // 多例



    public Car() {}

    public static Car getInstance() { // 静态工厂

        return car;

    }

    public void run(){
        System.out.println("冒着烟奔跑中....");
    }
}

