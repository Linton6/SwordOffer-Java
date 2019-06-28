package swordOffer;

import java.util.*;

/**
 * @Author Linton
 * @Date 2019/6/26 14:46
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class LastRemaining_Solution {

    public static void main(String[] args) {
        new LastRemaining_Solution().LastRemaining_Solution(8,5);
        System.out.println();
    }
    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0 || m <= 1){
            return 0;
        }
        if(n == 1){
            return n;
        }
        Deque<Integer> que = new LinkedList<Integer>();
        for(int i = 0; i < n; i++) {
            que.addLast(i);
        }
        while(que.size() != 1){
            for(int i = 0; i < m; i++) {
                if(i == m - 1){
                    que.removeFirst();
                }else{
                    que.addLast(que.removeFirst());
                }
            }
        }
        return que.removeLast();
    }
}

