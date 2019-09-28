package enterprise;

/**
 * @Date 2019/9/10 21:38
 * @最大连续子序列的和
 */
import java.util.*;
public class DianxinYun3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String stt1 = str.replace("[","").replace("]", "");
        String[] stts = stt1.split(", ");
        int len = stts.length;
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.valueOf(stts[i]);
        }
        System.out.println(sum(arr));


    }

    private static int sum(int[] arr) {
        if (arr == null || arr.length == 0 ) {
            return 0;
        }
        int len  = arr.length;
        int max = 0;
        int dp[] = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 0;
        }

        if (arr[0] > 0) {
            dp[0] = arr[0];
        } else {
            dp[0] = 0;
        }

        for (int i = 1;  i < len; i++) {
            if (dp[i - 1] + arr[i] > 0) {
                dp[i] = dp[i - 1] + arr[i];
            } else {
                dp[i] = 0;
            }
        }

        for (int i = 0; i < len; i++  ) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}

