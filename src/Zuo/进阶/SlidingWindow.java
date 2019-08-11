package Zuo.进阶;

import java.util.LinkedList;

/**
 * @Author Linton
 * @Date 2019/8/7 10:05
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 * 介绍窗口以及窗口内最大值或最小值的更新结构(单调双向队列)
 */

public class SlidingWindow {
    // 时间复杂度O(N)
    public static int[] getMaxWindows(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();  // 双端队列里面放的是下标
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) { // 加操作
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w){  // 判断下标是否过期，减操作
                qmax.pollFirst();
            }
            if (i >= w - 1) {  // 把最大值放进res数组
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}