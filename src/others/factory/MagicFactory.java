package others.factory;

/**
 * @Author Linton
 * @Date 2019/7/7 21:51
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class MagicFactory extends AbstractFactory {

    @Override
    public Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    public Food createFood() {
        return new Mushroom();
    }
}

