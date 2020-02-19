package enterprise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Date 2019/10/17 19:41
 * @
 */

public class eBay1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");
        int n = Integer.valueOf(ss[0]);
        int m = Integer.valueOf(ss[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, m));

    }

    private static int solution(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int len = arr.length;

        int left = 0;
        int right = len - 1;
        int count = 0;

        while (right >= left) {
            if (arr[right] + arr[left] > target) {
                count++;
                right--;
            } else {
                count++;
                right--; left++;
            }
        }
        return count;
    }
}

