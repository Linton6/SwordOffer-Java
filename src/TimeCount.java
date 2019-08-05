/**
 * @Author Linton
 * @Date 2019/8/4 8:26
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class TimeCount {
    // 毫秒
    public static void countTimeByMs(){
        long startTime = System.currentTimeMillis();
        doSomethings();
        long endTime = System.currentTimeMillis();

        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    // 纳秒
    public static void countTimeByNs() {
        long startTime = System.nanoTime();
        doSomethings();
        long endTime  = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }

    private static void doSomethings() {
    }
}

