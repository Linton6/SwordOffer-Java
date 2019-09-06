package leetcode;

/**
 * @Date 2019/9/6 19:09
 * @ 输入一个整数数组， 对于每个数可以选择加号或者减号， 问最后有几种方法可以得到一个S
 *
 * 解题思路分析
 * 基本的思路是按每一个数递归， 遇到一个数, 只有两种选择， 加号和减号； 遇到最后， 看看target是否是0
 * 当然，这里直接递归复杂度太高了， 会有很多重复的子问题， 所以可以用一个map来做记忆化递归, 也就是动态规划的top down模式
 *
 * http://www.noteanddata.com/leetcode-494-Target-Sum-java-solution-note.html
 */

public class leetcode494TargetSum {
    public static void main(String[] args) {

    }

    /** 递归解法**/
    private static int findTarget(int[] arr, int target) {
        if (arr == null || arr.length == 0 ) {
            return 0;
        }

        return  RecFind(arr, target, 0);
    }

    private static int RecFind(int[] arr, int target, int from) {
        if (from == arr.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        return RecFind(arr,target + arr[from],from+1) + RecFind(arr, target - arr[from],from + 1);
    }

    /** bottom up的动态规划解法 **/
//    因为所有数的和不会超过1000， 所以在表格向上平移了1000
//            dp的基本递推关系如下
//    dp[i][j+nums[i]] += dp[i-1][j];
//    dp[i][j-nums[i]] += dp[i-1][j];
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        for(int i = 0; i < nums.length; ++i) {
            if(i == 0) {
                dp[i][1000 + nums[i]] += 1;
                dp[i][1000 - nums[i]] += 1;
            }
            else {
                for(int j = 0; j < dp[i].length; ++j) {
                    if(dp[i-1][j] > 0) {
                        if(j+nums[i] < dp[i].length) {
                            dp[i][j+nums[i]] += dp[i-1][j];
                        }

                        if(j-nums[i] >= 0) {
                            dp[i][j-nums[i]] += dp[i-1][j];
                        }
                    }
                }
            }
        }
        if(S > 1000) {
            return 0;
        }
        return dp[nums.length-1][1000+S];
    }

}

