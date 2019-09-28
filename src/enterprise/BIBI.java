package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/9/10 20:17
 * @
 */

public class BIBI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        System.out.println(transfer(str1,str2));

    }

    private static int transfer(String str1, String str2) {
        if (str1 == null || str2 == null){
            return 0;
        }
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[Integer.MAX_VALUE][1005];

        for (int i = 0; i <= len2; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j - 1)) {
                   dp[i][j] =  dp[i - 1][j - 1] ;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]))+ 1;
                }
            }
        }

        return dp[len1][len2];

    }
}

