package Zuo.基础;

/**
 * @Author Linton
 * @Date 2019/8/4 8:06
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  给定数组 arr， arr中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以用任意张，在给定一个正数aim
 * 代表要找的钱数，求还钱有多少种方法。
 */

public class Coins1 {
    public static void main(String[] args) {
        int[] arr = {5,2,3};
        System.out.println(coins1(arr, 0));

    }

    /**
     * @动态规划+空间压缩
     * @至此得到最优解 时间复杂度O(N*aim)，额外空间复杂度O(aim)
     */
//    public static  int coins5(int arr[], int aim) {
//        if (arr == null || arr.length == 0 || aim < 0) {
//            return 0;
//        }
//        int[] dp = new int[aim + 1];
//
//        for (int i = 0; arr[0] * i <= aim; i++) {
//            dp[i * arr[0]] = 1;
//        }
//
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = 1; j < aim; j++) {
//                dp[j] = j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
//            }
//
//        }
//        return dp[aim];
//    }

    /**
     * @动态规划
     */
//    public static int coins4(int[] arr, int aim) {
//        if (arr == null || arr.length == 0 || aim < 0) return 0;
//        int[][] dp = new int[arr.length][aim + 1];
//
//        for (int i = 0; i < arr.length; i++){
//            dp[i][0] = 1;
//        }
//        for (int j = 0; j * arr[0] <= aim; j++) {
//            dp[0][arr[0] * j] = 1;
//        }
//
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = 1; j <= aim; j++){
//                dp[i][j] = dp[i - 1][j];
//                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
//            }
//        }
//        return dp[arr.length - 1][aim];
//    }

    /**
     * @暴力递归法
     * @param arr
     * @param aim
     * @return
     */
    private static int coins1(int[] arr, int aim) {
        if(arr == null || arr.length == 0 || aim < 0) return 0;
        return process1(arr, aim, 0);
    }

    private static int process1(int[] arr, int aim, int index) {
        int res = 0;
        if (index == arr.length ){
             res = aim == 0 ? 1 : 0;
        }else {
            for (int j = 0; j * arr[index] <= aim; j++){
                 res += process1(arr, aim - j*arr[index], index + 1);
            }
        }
        return res;
    }

    /**
     * @记忆优化法，它和coins1方法的区别就是准备好全局变量map，记录已经计算过的递归过程的结果，防止下次重复计算
     * 因为递归过程中刻有两个变量表示，所以map是一张二维表，而map[i][j]表示递归过程process1(i,j)的返回值
     * @param arr
     * @param aim
     * @return
     */
    private static int coins2(int[] arr, int aim) {
        if(arr == null || arr.length == 0 || aim < 0) return 0;
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0,aim, map);
    }
    private static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length ){
            res = aim == 0 ? 1 : 0;
        }else {
            int mapValue = 0;//
            for (int j = 0; j * arr[index] <= aim; j++){
                mapValue = map[index + 1][aim = arr[index] * j];//
                if (mapValue != 0){ // == 0 说明没有被钢槽那个map地址没有动过
                    res += process2(arr, index + 1, aim - arr[index] * j, map);
                } else {
                    res += process2(arr, index + 1,aim - j*arr[index], map);
                }

            }
        }
        map[index][aim] = res == 0 ? -1 : res;//
        return res;
    }


    /**
     * @动态规划
     * 生成行数为arr.length，列数为aim+1的矩阵dp,dp[i][j]的含义是在使用arr[0...i]货币的情况下，组成钱数j有多少种方法。
     * 动态规划的方法就是规定好每一个递归过程的计算顺序，依次进行计算，后计算的过程严格依赖前面计算的过程，即规定好了计算顺序
     */
    public int coins3(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++){
            dp[i][0] = 1; //第一列，钱数为0，只有一种方法
        }
        for (int i = 0; i * arr[0]<= aim; i++){
            dp[0][i * arr[0]] = 1;
        }
        int num = 0;
        /**
         * @dp的第一行和第一列都已经分析过了，所以直接从下标为1的行和列开始*/
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++){
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }
}

