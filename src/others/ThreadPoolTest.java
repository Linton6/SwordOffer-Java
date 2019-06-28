package others;


import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author Linton
 * @Date 2019/6/25 19:46
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class ThreadPoolTest {
    public static void main(String[] args) {
        threadPoolTest();
        thredTest();

    }

    static void  threadPoolTest(){
        int count = 20000;
        long startTime = System.currentTimeMillis();
        final List<Integer>  l = new LinkedList<Integer>();
        ThreadPoolExecutor tp = new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS
        , new LinkedBlockingDeque<>(count));
        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            tp.execute(new Runnable() {
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            });
        }
        /**？？ 不清楚为什么要关闭？？？ */
        tp.shutdown();
        try {
            tp.awaitTermination(1, TimeUnit.DAYS); // 这一行也没看懂？？
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadPoolTest:");
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());
    }

    static void thredTest() {
        int count = 20000;
        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<Integer>();
        final Random random = new Random();

        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            };
            thread.start();          // 开始执行
            try {
                thread.join();      // 顺序创建执行,保证了创建count个线程，不然会少于count个
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ThreadTest:");
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());
    }
}

