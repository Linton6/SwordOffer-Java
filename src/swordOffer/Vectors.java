package swordOffer;

import java.util.Vector;

/**
 * @Author Linton
 * @Date 2019/5/27 14:35
 * @Version 1.0
 * @Description d对Vector线程安全测试
 */

public class Vectors {
    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
             }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector){
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }}
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(vector.get(i));
                    }}
                }
            },"PrintlnHa");

            removeThread.start();
            printThread.start();

             // 不要同时产生过多的线程，否则会导致操作系统假死
            while (Thread.activeCount() > 20); // 没看懂这段代码的运行逻辑
            System.out.println("Thread.activeCount() "+ Thread.activeCount());
        }
    }
}

