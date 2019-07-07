package others.factory;

import java.util.Calendar;

/**
 * @Author Linton
 * @Date 2019/7/7 18:48
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Test {
    public static void main(String[] args) {
        Car car = Car.getInstance();
        Car car2 = Car.getInstance();
        if (car == car2) {
            System.out.println("Same Car");
        }


        car.run();

        PlaneFactory factory = new PlaneFactory();
        Moveable f = factory.createPlane();
        Moveable m = new Plane();
        m.run();


    }
}

