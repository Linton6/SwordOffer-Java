package swordOffer;

/**
 *  手写单例模式 version 1.0
 */

 // 懒汉式
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}
    private static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
             }
        }
        return instance;
    }
}

// 饿汉式
/**
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }

}
 **/
