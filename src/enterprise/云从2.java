package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/9/24 20:33
 * @
 */

public class 云从2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.replace("[","");
        str = str.replace("]","");
        str = str.replace(" ","");
        String strs[] = str.split(",");
        int len = strs.length;
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        String nn = in.nextLine();
        int amount = Integer.valueOf(nn);
        System.out.println(solution(arr,amount));

    }

    private static int solution(int[] coins, int amount) {
        int len = coins.length;
        int[] dp  = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = i;
            for (int j = 0; j < len; j++) {
                if (coins[j] <= i && dp[i - coins[j]] + 1 < dp[i]) {
                    dp[i] = dp[i - coins[j]] + 1;
                }

            }
        }

        if (dp[amount] == amount - 1) {
            return -1;
        }{
            return dp[amount];
        }

    }
}

