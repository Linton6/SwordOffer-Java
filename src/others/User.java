package others;

/**
 * @Author Linton
 * @Date 2019/6/2 17:12
 * @Version 1.0
 * @Description  测试Java的反射机制
 */

public class User {
    private String name = "init";
    private int age;
    public User() {}

    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    private String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }
}
