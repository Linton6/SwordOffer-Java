package enterprise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Date 2019/9/25 15:11
 * @
 */

public class 拼多多1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, M));

    }

    private static long solution(int[] arr, int count) {
        if (arr == null || arr.length < 2 || count > arr.length / 2) {
            return 0;
        }

        if (count == 0) {
            return 0;
        }

        Arrays.sort(arr);

        int len = arr.length;

        long sum = 0;

        int i = 0;
        int j = i + 2*count -1;

        while (j > i) {
            sum += arr[j]* arr[i];
            i++;
            j--;
        }
        return sum;
    }
}

