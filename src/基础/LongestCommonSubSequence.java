package 基础;

/**
 * @Author Linton
 * @Date 2019/8/4 14:49
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  最长公共子序列 给定两个字符串str1和str2，返回两个字符串最长的公共子序列
 */

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";  // 返回123456
        System.out.println(lcse(str1, str2));

    }

    // dp[i][j]的含义是str1[0..i]与str2[0..j]的最长公共子序列的长度，从左到右，从上到下计算矩阵dp.
    private static int[][] countCommon(String str1, String str2) {
        int M = str1.length();
        int N = str2.length();
        int[][] dp = new int[M][N];
        dp[0][0] = str1.charAt(0) ==str2.charAt(0) ? 1 : 0;
        for (int i = 0; i < M; i++) { // dp矩阵第一列
            if (str1.charAt(i) == str2.charAt(0)){
                for (int j = i; j < M; j++){
                    dp[j][0] = 1;
                }
                break;
            }
        }
        for (int i = 0; i < N; i++) {
            if (str1.charAt(0) == str2.charAt(i)){
                for (int j = 0; j < N; j++){
                    dp[0][j] = 1;
                }
                break;
            }
        }
        int max = 0;
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];

                if (str1.charAt(i) == str2.charAt(j))
                    dp[i][j] = dp[i][j] > (dp[i - 1][j - 1] + 1) ? max :  (dp[i - 1][j - 1] + 1);
            }
        }
        return dp;
    }
    /** 现在得到了公共子串的最大长度，开始反推求出最长公共子串 */
    private  static String lcse(String str1, String str2){
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return null;
        int[][] dp =  countCommon(str1, str2);
        int m = str1.length() - 1;
        int n = str2.length() - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = str1.charAt(m);
                n--;
                m--;
            }
        }
        return String.valueOf(res);
    }
}

