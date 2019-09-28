package enterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Date 2019/9/20 21:38
 * @
 */

public class 腾讯4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int tem = in.nextInt();
            int[] arr = new int[tem];
            for (int j = 0; j < tem; j++) {
                arr[j] = in.nextInt();

            }
            solution(tem,arr);
        }

    }

    ArrayList<String> list = new ArrayList<>();

    private static void solution(int n, int[] arr) {
        if (arr == null || arr.length == 0) {
            return ;
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 0;

        int min = 0;
        int max = 0;

        for (int i = 0; i < n - 1; i = i+2) {
            min = Math.min(arr[i], arr[i + 1]);
            max = Math.max(arr[i], arr[i + 1]);

            if (left > right) {
                left += min;
                right += max;
            } else {
                left += max;
                right += min;
            }
        }

//        if (n % 2 == 1) {
//
//        }
        int[]  res = new int[2];
        res[0] = Math.min(left,right);
        res[1] = Math.max(right,left);
        System.out.println(res[0] + " " + res[1] );
    }
}

