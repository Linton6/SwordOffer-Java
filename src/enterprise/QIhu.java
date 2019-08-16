package enterprise;


/**
 * @Author Linton
 * @Date 2019/8/15 20:16
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.util.Scanner;

public class QIhu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
        int N = in.nextInt();
        int M = in.nextInt();
        int arr[][] = new int[N + 2][M + 2];

        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = in.nextInt();
                if (arr[i][j] > 0)
                    res++;
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] > arr[i - 1][j])
                    sum += arr[i][j] - arr[i - 1][j];

                if (arr[i][j] > arr[i + 1][j])
                    sum += arr[i][j] - arr[i + 1][j];

                if (arr[i][j] > arr[i][j - 1])
                    sum += arr[i][j] - arr[i][j - 1];

                if (arr[i][j] > arr[i][j + 1])
                    sum += arr[i][j] - arr[i][j + 1];
            }

        }
        System.out.println(sum + res);

    }
}


