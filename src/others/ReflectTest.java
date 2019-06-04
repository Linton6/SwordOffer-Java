package others;


import com.sun.istack.internal.logging.Logger;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author Linton
 * @Date 2019/6/2 17:12
 * @Version 1.0
 * @Description
 */

public class ReflectTest {
    public static void main(String[] args) {
          Logger logger = Logger.getLogger(ReflectTest.class);
          Class<User> userClass = User.class;
        // 获取Class对象的三种方式
        logger.info("根据类名:  \t" + User.class);
        logger.info("根据对象:  \t" + new User().getClass());
//        logger.info("根据全限定类名:\t" + Class.forName("sun.awt.util.IdentityArrayList"));
        // 常用的方法
        logger.info("获取全限定类名:\t" + userClass.getName());
        logger.info("获取类名:\t" + userClass.getSimpleName());
        logger.info("获取类名:\t" + userClass.getConstructors());
        HashMap<String,String> a = new HashMap<String, String>(2);
//        logger.info("实例化:\t" + userClass.newInstance());
        Constructor<?>[] constructors = userClass.getConstructors();
        // 取消安全性检查,设置后才可以使用private修饰的构造函数，也可以单独对某个构造函数进行设置
        // Constructor.setAccessible(constructors, true);
        for (int i = 0; i < constructors.length; i++) {
            Class<?> parameterTypesClass[] = constructors[i].getParameterTypes();
            System.out.print("第" + i + "个构造函数:\t (");
            for (int j = 0; j < parameterTypesClass.length; j++) {
                System.out.print(parameterTypesClass[j].getName() + (j == parameterTypesClass.length - 1 ? "" : "\t"));
            }
            logger.info(")");
        }
        // 调用构造函数，实例化对象
//        logger.info("实例化，调用有参构造:\t" + constructors[1].newInstance("韦德", 35));
    }

}

