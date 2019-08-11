package Zuo.进阶;

import java.util.HashMap;

/**
 * @Author Linton
 * @Date 2019/8/8 17:15
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 *
 * @题型一、给定一个数组，目标值aim,求出和为 aim 的最长子数组长度
 * 题型二、给定一个数组，求出奇数和偶数相等的最长子数组长度  分析：设奇数为1，偶数为-1，接下来求累加和为0的最长数组就可以了。
 * 或者0和1相同数目的最长子数组，一个道理，都是题型一的变形。
 * 题型三、给定一个数组，划分出子数组，求出子数组异或和为0 的最多子数组数量    异或运算满足交换律和结合律；0^N = N, N^N =0；
 * 分析：dp[i] = dp[i - 1] 或 dp[k - 1] + 1
 *
 */

public class LongestSumSubArrayLength04 {
    /**
     * 题型一
     * @param arr
     * @param k
     * @return
     */
    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // important
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;
    }
    /**
     * 题型三
     */
    public static int mostEOR(int[] arr) {

        int ans = 0;
        int xor = 0;
        int[] dp = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            if (map.containsKey(xor)) {
                int pre = map.get(xor);
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1) ;
            }
            if (i > 0){
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            map.put(xor, i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

