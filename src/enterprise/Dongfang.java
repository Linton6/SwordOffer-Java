package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/9/9 19:56
 * @纸币取和
 */

public class Dongfang {

    public static void main(String[] args) {
        int[] coins = {1,2,5,10,20};
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s =coinsCount(coins, n);
        System.out.println(s);
    }

    public static int coinsCount(int[] coins,int n){
        if (coins == null || coins.length == 0 || n < 0) {
            return 0;
        }
        if (n == 0 || n == 1)  {
            return n;
        }
        int len = coins.length;

        int[][] dp = new int[len + 1][n + 1];//length+1表示不适用任何币种、只使用1、只使用1 2 只使用1 2 3......等等，共length+1种情况，且n+1表示总计0、1.....至n元共n+1种情况
        for(int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1 ;i <= len; i++){//因为dp[0][i]是0，所以i从1开始
            for(int count = 1; count <= n; count++){//由于dp[i][0]==1，所以j从1开始
                for(int j=0; j <= count/coins[i-1]; j++){//例如，使用面值为1时，对应的coins[]下标是i-1，逻辑上河实际上不是一致的
                    dp[i][count] += dp[i - 1][count - j * coins[i - 1]];
                }
            }
        }
        return dp[len][n];
    }

}

