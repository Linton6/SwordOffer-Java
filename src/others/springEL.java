package others;

import sun.nio.ch.ThreadPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author Linton
 * @Date 2019/5/31 10:24
 * @Version 1.0
 * @Description
 */

public class springEL {
    public static void main(String[] args) {
        // 表达式解析
        int a1 = Runtime.getRuntime().availableProcessors();
        int a = 1,b = 3;
        swap(a,b);
        System.out.println(a1);

    }
    public interface Tran{
        int a =0;
        int a1 = 9;

    }

    public static void swap(int a, int b) { // 用数组才有意义
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a1 =" +a+"b1="+b);
    }
}

