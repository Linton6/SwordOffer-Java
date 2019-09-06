package enterprise;


/**
 * @Author Linton
 * @Date 2019/8/18 16:08
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.ArrayList;
import java.util.Scanner;

public class RedBooK3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
            int N = in.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i< N; i++) {
                arr[i] = in.nextInt();
            }
            int[] res = likes(N, arr);
            System.out.println( res[0]+ " " + res[1]);
//        }
    }

    private static int[] likes(int N, int[] arr) {
        int dp[] = new int[N]; // 最高的获赞数量
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        dp[2] = Math.max(arr[0] + arr[2], arr[1]);
        int  n = 0;
        if ( arr[0] + arr[2] <= arr[1] ) {
            n = 1;
        } else{
            n = 2;
        }
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
            if (dp[i - 1] < dp[i - 2] + arr[i] && dp[i - 1] == dp[i - 2])  {
                n += 1;
            }
        }
        int[] res = new int[2];
        res[0] = dp[N - 1];
        res[1] = (int)n;
        return res;
     }
}


