package leetcode;

import java.util.*;
import java.util.Arrays;

/**
 * @Date 2019/8/19 15:17
 * @
 */


public class AS {
    public static void main(String args[]) {
        // 深度遍历二叉树


    }

    private static void print(int N) {
        char[] chs = new char[N];
        rec(chs, N);
    }

    static ArrayList<String> list = new ArrayList<>();

    private static void rec(char[] chs, int N) {


        if (N == 0) {
            list.add(chs.toString());
            return;
        } else {
            chs[N - 1] = 'a';
            rec(chs, N - 1);
        }


    }



    /**
     * 招银网络：计算奖励的数量.
     * @param n
     * @return
     */
    private static int count(int n) {
        if (n == 1) {
            return 3;
        }
        if (n == 2) {
            return 8;
        }
        int sum = (int) Math.pow(3, n);
        int div = (int) Math.pow(3, n - 2) * (n - 2) + (int) Math.pow(3, n - 2) * (n * (n - 1) / 2);

        return sum - div;
    }
}