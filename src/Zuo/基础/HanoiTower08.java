package Zuo.基础;

import static swordOffer.Permutation.swap;

/**
 * @Author Linton
 * @Date 2019/8/6 11:09
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 * 1. 汉诺塔问题
 * 2. 打印一个字符串的所有子序列，包括空字符串
 *
 */

public class HanoiTower08 {

    /** @汉诺塔 */
    // 时间复杂度O(2的N次幂 - 1）
    public static void process(int N, String from, String to, String help) {
        if(N == 1) {
            System.out.println("Move 1 form " + from + " to " + to);
        } else {
            process(N - 1, from, help, to);
            System.out.println("Move " + N + " from " + from + " to " + to);
            process(N - 1, help, to, from);
        }
    }
    // 另外一个方法，六个过程彼此嵌套


    /** @打印一个字符串的所有子序列，包括空字符串 */
    private static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str, i + 1, res);  // 不要当前字符
        printAllSub(str, i + 1, res + String.valueOf(str[i]));  // 要当前字符
    }

    public static void main(String[] args) {
        String test = "abc";
        printAllSub(test.toCharArray(), 0, "");
    }

    /** @打印字符串全排列 */
    private static void  printAllPermutations1(String str) {
        char[] chs = str.toCharArray();
        process1(chs, 0);
    }
    private static void process1(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs, i ,j);
            process1(chs, i + 1);
            swap(chs, i , j);

        }
    }

}

