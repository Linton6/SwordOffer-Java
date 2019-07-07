package others.proxy.test;

/**
 * @Author Linton
 * @Date 2019/7/7 18:13
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class userMangeImpl  implements UserMange{
    @Override
    public void addUser() {
        System.out.println("1: 插入记录到user表");
        System.out.println("2： 做日志在另外一张表");
    }
}

