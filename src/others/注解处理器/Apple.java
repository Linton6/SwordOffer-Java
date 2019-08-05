package others.注解处理器;

/**
 * @Author Linton
 * @Date 2019/8/2 14:34
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  2. 注解使用
 */

public class Apple {
    @FruitProvider(id = 1, name = "烟台红富士集团", adress = "山东省烟台市五星路")

    private String appleProvider;

    public void setAppleProvider(String appleProvider){
        this.appleProvider = appleProvider;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

}

