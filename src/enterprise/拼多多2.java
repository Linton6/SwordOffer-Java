package enterprise;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Date 2019/9/25 15:40
 * @
 */

public class 拼多多2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N= in.nextInt();
        int M = in.nextInt();
        int[][] arr  = new int[M][2];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        solution(arr,M);

    }

    private static void solution(int arr[][], int M ) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            for (int j = arr[i][0]; j <= arr[i][1]; j++) {
                set.add(j);
            }
            System.out.println(set.size());
        }
    }
}

