package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/9/17 19:48
 * @
 */

public class 百度1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] arr = new int[m][2];

            for (int j = 0; j < m; j++) {
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
            }

            System.out.println(judge(arr, n));

        }

    }

    private static String judge(int[][] arr, int n) {
        int m = arr.length;
        for (int i = 0; i < m; i++) {
            int t = i;
            if (arr[i][0] == 1) {

            }
        }

        return "IMPOSSIBLE";

    }
}

