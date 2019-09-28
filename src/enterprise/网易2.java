package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/9/21 15:50
 * @
 */

public class 网易2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[][] arr = new int[T][4];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < T; i++) {
            int res = solution(arr[i]);
            System.out.println(res);
        }

    }

    private static int solution(int[] arr) {
        if (arr.length < 4) {
            return 0;
        }

        int res = 0;
        int A = arr[0];
        int B = arr[1];
        int p = arr[2];
        int q = arr[3];
        while (true) {
            int temp = p * q;
            if (A + p >= B) {
                res++;
                break;
            } else {
                res++;
                p = temp;
            }
        }
        return res;
    }
}

