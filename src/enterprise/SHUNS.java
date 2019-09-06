package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/8/29 20:23
 * @
 */

public class SHUNS {
    public static void main(String[] args) {
        Scanner in = new  Scanner(System.in);
        String n = in.nextLine();
        String nums = in.nextLine();
        String[] num = nums.split(" ");
        int size = num.length;
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.valueOf(num[i]);
        }
        System.out.println(sub(arr));

    }

    private static int sub(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int count = 1;
        int size = dp.length;
        for (int i = 1; i < size;i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] >= arr[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            count = Math.max(count, dp[i]);
        }
        return count;
    }
}

