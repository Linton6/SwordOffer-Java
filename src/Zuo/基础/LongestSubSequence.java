package Zuo.基础;

import java.util.Arrays;

/**
 * @Author Linton
 * @Date 2019/8/4 10:52
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 最长递增子序列
 */

public class LongestSubSequence {
    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        int[] a = getdp1(arr);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(generateLIS1(arr, a)));

    }

    // 生成长度为N的数组dp。dp[i]表示在以arr[i]这个数结尾的情况下，arr[0..i]的最大递增子序列长度
    public static int[] getdp1(int[] arr) {
        int [] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }
    // dp数组包含每一步的决策信息，其实根据dp数组找出最长递增子序列的过程就是从某一个位置开始逆序还原决策路径过程。
    public static int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1){
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }
    public static int[] generateLIS1(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++){
            if (len < dp[i]){
                len = dp[i];
                index = i;
            }
        }
        int[] result1 = new int[len];
        result1[0] = arr[index]; // index = 7
        int a = 1;
        for (int j =  index - 1 ; j >= 0; j--) {

            if (arr[j] < arr[index] && (dp[j] == dp[index] - 1)){
                result1[a++] = arr[j];
                index = j;
            }

        }
        int[] result = new int[result1.length];
        int b = 0;
        for (int j = result1.length - 1; j >= 0; j-- ){
            result[b++] = result1[j];
        }
        return result;

    }
}

