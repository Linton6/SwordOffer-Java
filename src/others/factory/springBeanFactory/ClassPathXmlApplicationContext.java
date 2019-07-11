package others.factory.springBeanFactory;

/**
 * @Author Linton
 * @Date 2019/7/8 8:05
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class ClassPathXmlApplicationContext implements BeanFactory {

    // 解析xml文件 添加JDOM
    public ClassPathXmlApplicationContext(String filename) {

    }

    @Override
    public Object getBean(String id) {
        return null;
    }
}

