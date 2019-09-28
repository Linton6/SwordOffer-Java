package enterprise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Date 2019/9/21 16:26
 * @
 */

public class 网易3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            int arr[] = new int[k];
            for (int j = 0; j < k; j++) {
                arr[j] = in.nextInt();
            }
            list.add(arr);
        }
        for (int i = 0; i < n; i++) {
            int t = solution(list.get(i));
            System.out.println(t);
        }

    }

    private static int solution(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int len  = arr.length;

        int sum = 0;
        int max = 1;

        for (int i = 0; i < len - 1; i++) {
            sum = 0;
            for (int j = i ; j < len; j++) {
                if (arr[j] >= sum){
                    sum += arr[j];
                } else {
                    max = Math.max(max, j - i);
                    break;
                }

            }
        }
        return max;
    }
}

