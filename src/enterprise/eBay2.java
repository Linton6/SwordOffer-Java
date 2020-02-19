package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/10/17 19:57
 * @
 */

public class eBay2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");
        int N = Integer.valueOf(ss[0]);
        int M = Integer.valueOf(ss[1]);
        int K = Integer.valueOf(ss[2]);
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, N, M, K));

    }

    private static int solution(int[] arr, int N, int M, int K) {
        return  K - M;

    }
}

