package newSwordOffer;

/**
 * @Date 2019/9/8 9:17
 * @  一个矩阵（二维数组）求从左上角到右下角的最短距离和
 * 思路：很简单dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j] 原点到[i][j]的最小距离和，就是
 * [i-1][j]或[i][j-1] + arr[i][j]的最小值  搞懂这个，此题已解
 */

public class 矩阵的最小路径和 {
    public static void main(String[] args) {

    }

    /**
     * 动态规划 时间复杂度O(N*M) 空间复杂度O(N*M)
     * @param arr
     * @return
     * @throws Exception
     */
    private static int countSum(int[][] arr) throws Exception {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            throw new Exception("输入数组格式错误！请重新输入");
        }
        int rows = arr.length;
        int cols = arr[0].length;
        int dp[][] = new int[rows][cols];
        // 第一行
        for (int i = 0; i < cols; i++){
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        //第一列
        for (int i = 0; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        // 其余部分， dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j]
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + arr[i][j];
            }
        }

        return dp[rows-1][cols-1];
    }

    /**
     * 动态规划-空间压缩
     * 核心思想：就是不断的滚动dp[i][j] 成数组arr[i] 降低空间复杂度
     */
    private static int count(int[][] arr) throws Exception {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            throw new Exception("输入数组格式错误！请重新输入");
        }
        int rows = arr.length;
        int cols = arr[0].length;

        int less = Math.min(rows, cols);
        int more = Math.max(rows, cols);

        int[] dp = new int[less];
        dp[0] = arr[0][0];
        boolean rowmore = rows > cols;


        for (int i = 0; i < less; i++) {
            dp[i]  = dp[i-1] + (rowmore ? arr[0][i] : arr[i][0]);
        }

        for (int i = 1; i < more; i++) {
            dp[0] = dp[0] + (rowmore ? arr[i][0] : arr[0][i]);
            for (int j = 1; j < less; j++) {
                dp[j] = Math.min(dp[j - 1],dp[j]) +(rowmore ? arr[i][j] : arr[j][i]);
            }
        }

        return dp[less - 1];



    }


}























