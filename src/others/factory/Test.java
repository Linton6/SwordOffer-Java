package others.factory;

import java.util.Calendar;

/**
 * @Author Linton
 * @Date 2019/7/7 18:48
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  简单工厂和工厂方法的区别   抽象工厂：系列产品
 */

public class Test {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new DefaultFactory();

        Vehicle vehicle = abstractFactory.createVehicle();
        vehicle.run();
        Weapon weapon = abstractFactory.createWeapon();
        weapon.shoot();
        Food food = abstractFactory.createFood();
        food.printName();



    }
}

