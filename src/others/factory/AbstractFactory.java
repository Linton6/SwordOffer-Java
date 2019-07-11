package others.factory;

/**
 * @Author Linton
 * @Date 2019/7/7 21:56
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public abstract class AbstractFactory {
  public abstract Vehicle createVehicle();

  public abstract  Weapon createWeapon();

  public abstract  Food createFood();
}

