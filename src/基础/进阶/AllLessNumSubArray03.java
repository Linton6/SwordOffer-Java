package 基础.进阶;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author Linton
 * @Date 2019/8/7 10:45
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  求数组中所有子数组满足，子数组的最大值- 最小值 <= aim 值, 满足此条件的子数组数量
 */

public class AllLessNumSubArray03 {
    /** 实际复杂度O(N)
     * 分析：一个子数组，已经达标了，那么子数组内部的子数组一定达标；一个子数组不达标，那么子数组外部的数组（即包含此子数组的数组）一定不达标
     * 利用这个性质，用滑动窗口。创建两个双端队列，一个保存最大值，一个保存最小值（本质：L缩一下，R往右走）
     */
    public static int getNum(int[] arr,int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int L = 0;
        int R = 0;
        int res = 0;
        while (L < arr.length) {
            while (R < arr.length) { // 当R不能再往右括时，停
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.addLast(R);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                R++;
            }
            if (qmin.peekFirst() == L) { // 看下标过期没
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
            res += R - L; //   以L开头的所有符合条件的数组数
            L++;  // 换一个开头
        }
        return res;

    }


    /** 暴力法 时间复杂度O(N的3平方)  找到所有的子数组O(N2)，遍历子数组O(N),所以为O(N3)
     *  分析：遍历出所有的子数组，每个子数组进行判断
     */
    public static int getNum1(int[] arr,int num) {
        int res = 0;
        for (int start = 0; start < arr.length; start++){
            for (int end = start; end < arr.length; end++){
                if (isValid(arr, start, end, num)){
                    res++;
                }
                // int[] sub = Arrays.copyOfRange(arr, start, end);
            }
        }
        return res;
    }
    public static boolean isValid(int[] arr, int start, int end, int num) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i =  start; i <= end; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max - min <= num;
    }
}

