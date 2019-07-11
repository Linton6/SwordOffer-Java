package others.factory;

/**
 * @Author Linton
 * @Date 2019/7/7 21:48
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class DefaultFactory extends AbstractFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }

    @Override
    public Food createFood() {
        return new Apple();
    }
}

