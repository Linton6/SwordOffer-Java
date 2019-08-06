package 基础;

/**
 * @Author Linton
 * @Date 2019/8/4 16:11
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  给定两个字符串str1 和str2 ，返回两个字符串的最长公共子串
 */

public class LongestCommonSubString {
    public static void main(String[] args) {
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        System.out.println(lcst2(str1,str2));


    }

    // 先创建出动态矩阵dp
    private static int[][]  getdp(String str1, String str2) {
        int M = str1.length();
        int N = str2.length();
        int[][] dp = new int[M][N];
        if (str1.charAt(0) == str2.charAt(0)) dp[0][0]  = 1;
        for (int i = 0; i < M; i++) {
            if (str1.charAt(i) == str2.charAt(0))
                dp[i][0] = 1;
        }
        for (int j = 0; j < N; j++) {
            if (str2.charAt(j) == str1.charAt(0))
                dp[0][j] = 1;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    /** @遍历矩阵，得到最大值，然后得出最大公有子串
     *  @时间复杂度O(M*N)，空间复杂度O(M*N)
     */
    private static String lcst1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return null;
        int[][] dp = getdp(str1, str2);
        int max = 0;
        int end = 0;
        for (int i = 0; i < str1.length(); i++){
            for (int j = 0; j < str2.length(); j++) {
                if (max < dp[i][j]){
                    max = dp[i][j];
                    end = i;
                }
            }
        }
        return str1.substring(end - max + 1,end + 1);
    }

    /** @动态路径规划  这个方法想出来也是绝了
     * @时间复杂度O(M*N)
     * @空间复杂度O(1)*/
    public static String lcst2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return "";
        int row = 0 ; // 斜线开始位置的行
        int col = str2.length() - 1; // 斜线开始位置的列
        int max = 0; //记录最大长度
        int end = 0; // 最大长度更新时，记录子串的结尾位置
        while(row < str1.length()) {
            int i = row;
            int j = col;
            int len = 0;
             // 从（i，j）开始向右下方遍历
            while (i < str1.length() && j < str2.length()) {
                if (str1.charAt(i) != str2.charAt(j)) {
                    len = 0;
                } else {
                    len++;
                }
                // 记录最大值，以及结束字符的位置
                if (len > max) {
                    end = i;
                    max = len;
                }
                j++;
                i++;
            }
            if (col > 0) { // 斜线开始位置的列先向左移动
                col--;
            } else { // 列移动到最左之后，行向下移动
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);

    }
}

