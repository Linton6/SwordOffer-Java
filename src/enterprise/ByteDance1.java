package enterprise;

import java.util.ArrayList;

/**
 * @Author Linton
 * @Date 2019/7/17 14:44
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  有1 2 5 10 问给N元，有多少种不同的方式
 */

public class ByteDance1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10};
        int N = 100;
        ByteDance1 b = new ByteDance1();
        b.transfer(arr, N, 3);
        int size = list.size();
        System.out.println(size);
        System.out.println(b.transer1(arr,N));

    }

    /** 递归法 */
     static  java.util.ArrayList<Integer> list = new ArrayList<>();
    int transfer(int[] arr, int N, int i){
        if (arr == null || arr.length <= 0 || N < 0 || i < 0){
            return 0;
        }
        if (i == 0 ){
            list.add(1);
            return 0;
        }
        if (N == 0){
            list.add(0);
            return 0;
        }
        transfer(arr, N - arr[i],i); // 用
        transfer(arr, N, i-1);  //不用

        return 0;
    }

    // 蛮力法
    int transer1 (int[] arr, int N) {
        int num = 0;
        for (int i = 0 ; i <= N/arr[3]; i++){
            for (int j = 0; j <= N / arr[2]; j++){
                for (int k = 0; k <= N / arr[1]; k++){
                    for (int h = 0; h <= N / arr[0]; h++) {
                        if (N == h*arr[0] + k * arr[1] + j*arr[2] + i * arr[3]){
                            num++;
                        }
                    }
                }
            }
        }

        return num;
    }

    /**
     * 动态规划 时间优化+空间优化
     */
    int coins5(int[] arr, int aim) {
        if (arr == null || arr.length < 1 || aim < 1)
            return 0;
        int[] dp = new int[aim+1];
        for (int i=0; i * arr[0] <= aim; i++) {
            dp[i * arr[0]] = 1;
        }

        for (int i=1; i<arr.length; i++) {
            for (int j=1; j<=aim; j++) {
                if (j - arr[i] >= 0) {
                    dp[j] += dp[j-arr[i]];  // 若 j -arr[i] > 0，则需要加上只用 j-1 种的和用 j 种的。
                }
            }
        }

        return dp[aim];
    }

    //??
/*    int transfer(int[] arr, int aim) {
        if (arr == null || arr.length < 1|| aim < 0) {
            return 0;
        }
        return transfer(arr, 0, aim);
    }

    int transfer(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i=0; i * arr[index] <= aim; i++) {
                res += transfer(arr, index + 1, aim - i * arr[index]);
            }
        }
        return res;
    }*/
}

