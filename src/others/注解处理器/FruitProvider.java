package others.注解处理器;

import java.lang.annotation.*;

/**
 * @Author Linton
 * @Date 2019/8/2 14:35
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description   1.定义注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /** 供应商编号*/
    public int id() default -1;
    /** 供应商名称*/
    public String name() default "";
    /** 供应商地址 */
    public String adress() default "";

}

