package others.注解处理器;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @Author Linton
 * @Date 2019/8/2 14:43
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 3.注解处理器
 */

public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitProvider = "供应商信息： ";

        Field[] fields = clazz.getDeclaredFields();// 通过反射获取处理注解
        for (Field filed : fields){
            if(filed.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = (FruitProvider) filed.getAnnotation(FruitProvider.class);
            // 注解信息处理方法
                strFruitProvider = "供应商编号： " + fruitProvider.id() + " 供应商名称： "
                        + fruitProvider.name() + " 供应商地址：" + fruitProvider.adress();
                System.out.println(strFruitProvider);
            }
        }
    }
}

