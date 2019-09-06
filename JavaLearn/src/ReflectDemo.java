/**
 * @Author Linton
 * @Date 2019/8/17 20:20
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */


public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        /**
         *
         * 反射技术：动态的获取类以及类中的成员，并可以调用该类的成员。
         * 以前有什么类就new什么对象。
         * 现在没有类，给什么类就new什么对象。
         *
         *
         * 反射技术的出现提高了程序的扩展性
         * 反射技术中最重要的一点：先获取到那个类。
         * 如何获取类呢？
         *
         * 无论new什么对象，都需要先获取字节码文件
         * 如何获取呢？发现java已对字节码文件进行了描述用Class类完成的
         *
         * 如何获取一个字节码文件的对象呢？
         *
         * 方式一：Object getClass()方法,发现在反射技术里，该方法不合适，反射技术中不明确具体类
         *
         * 方式二：所有的数据类型都由自己对应的class对象，表示方法很简单
         * 每一个数据类型都由一个默认的静态属性。.class用该属性就可以获取到字节码文件对象
         * 虽然不用对象调用，但还是要用具体的类调用静态属性。
         *
         * 方式三：在Class类中找到了forName方法，通过名称就可以获取对应的字节码文件对象
         * 重点！！！！！
         *
         */

//        methodDemo_1();

        methodDemo_2();

//        methodDemo_3();


    }

    //获取Class对象的方式三
    public static void methodDemo_3() throws ClassNotFoundException {

        String className = "Person";

        Class clazz = Class.forName(className);

        System.out.println(clazz);

    }

    //获取Class对象的方式二
    public static void methodDemo_2() {

        Class clazz = Person.class;
        Class clazz2 = Person.class;
        System.out.println(clazz);

    }

    //获取Class对象的方式一
    public static void methodDemo_1(){

        //调用getClass先有对象
        Person p1 = new Person();
        Class c1 = p1.getClass();

        Person p2 = new Person();
        Class c2 = p2.getClass();

        System.out.println(c1==c2);


    }


}
 class Person {

    private String name;
    private int age;
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person() {
        super();
        System.out.println("person run");

    }

    public void show(){
        System.out.println("person show run");
    }

    public static void staticShow(){
        System.out.println("person static show run");
    }

    public void paramShow(String name,int age){
        System.out.println("show:"+name+"---"+age);
    }


}


