package enterprise;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.*;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date 2019/9/21 17:53
 * @
 */

public class 度小满1 {
    public static void main(String[] args) {



        List list = new ArrayList();

    System.out.println(list.getClass());//class java.util.ArrayList
        System.out.println(List.class);//interface java.util.List
        System.out.println(ArrayList.class);//class java.util.ArrayList
        System.out.println(list.getClass() == ArrayList.class);//true
        System.out.println(list.getClass() == List.class);//false
        System.out.println(list.getClass().getName());//java.util.ArrayList
        //--------------

//------------------------------------------------------
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        boolean s = set.remove(1);
        System.out.println(set.isEmpty());


    }

    private static  double solution(int N) {

        double sum = 0;
        int count = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                sum += i * j;
                count++;
            }

        }
        return sum / count;

    }
}

