package others.thread;

/**
 * @Date 2019/9/14 21:24
 * @
 * 设计4个线程，其中两个线程每次对j加1，另外两个线程对j每次减少1，
 * 使用内部类实现线程，对j增减的时候，没有考虑顺序问题
 */

public class ThreadTest1 {
    private int j ;

    public static void main(String[] args) {
        ThreadTest1 tt = new ThreadTest1();  // 建立外部类ThreadTest1的实例
        Inc inc = tt.new Inc(); // 根据外部实例建立Inc和Dec，这两个内部类实例
        Dec dec = tt.new Dec();

        for (int i = 0; i < 2; i++) {  // 创建了四个线程
            // PS: 实现runnable接口的线程要想执行必须得放到Thread类中实例化一个对象
            Thread t = new Thread(inc);  //
            t.start();
            t = new Thread(dec);
            t.start();
        }

    }

    private  synchronized void inc() {  // 加锁和不加锁的区别？？？？？？
        j++;
        System.out.println(Thread.currentThread().getName() + " -inc:" + j);
    }

    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + " -dec:" + j);
    }

    class  Inc implements Runnable { // 成员内部类 Inc

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {   // 成员内部类 Dec

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }

}

