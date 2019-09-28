package leetcode;

import java.util.Arrays;

/**
 * @Date 2019/9/16 10:36
 * @
 * 思路：
 */

public class 最长上升子序列300 {
    public static void main(String[] args) {
        int arr[] = {2,2,2,2,2};
        System.out.println(findSubsequence(arr));

    }

    private static int findSubsequence( int[] arr) {
        // 动态规划思路：将dp数组定义为：以nums[i] 结尾的最长上升子序列的长度
        if(arr == null || arr.length == 0 ) {
            return 0;
        }
        int len = arr.length;
        if (len == 1) {
            return 1;
        }

        int[] dp = new int[len];
        int[] count = new int[len]; // 用来求以nums[i]结尾的最长递增子序列的个数（也可以理解为表示递增子序列的组合方式）

        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max = 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = Math.max(dp[j] + 1,dp[i]);
                        max = Math.max(dp[i],max);  // dp[i] 更新一次
                        count[i] = count[j];  //   每次dp[i]更新一次，count[j]的值给count[i]
                    }else if (dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
        }

        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] == max) {
                ans += count[i];
            }
        }

        return ans;
    }
}

