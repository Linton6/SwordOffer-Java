package enterprise;


/**
 * @Date 2019/8/29 20:05
 * @给定一个四位整数n(用abcd表示)，让你算出从1-n的整数中包含1的个数
 *
 * /*
 * 链表遍历，p，q指向头结点，
 * p先走k步，然后p、q一起走 ，直到p为空，q节点即为所求
 * */

import leetcode.ListNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SHUNF {
    public static void main(String[] args) {
        String sss = "sdsds2";
        System.out.println(sss.indexOf(1));
        System.out.println(sss.indexOf("d"));
        System.out.println(count(112));


    }

    private static int count(int N) {
        int count = 0;
        for (int i = 1; i <= N ; i++) {
            String s = String.valueOf(i);
            if (s.contains("1")){
                count++;
            }
        }
        return count;

    }




}

