package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/8/25 18:09
 * @
 */

public class DF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int k = 0;
        while (n-- > 0) {
            arr[k++] = in.nextInt();
        }
        int n1 = arr.length;
        for (int i = 0; i < n1; i++)
        System.out.println(pingfang(arr[i]));

    }

    private static boolean pingfang (int n ) {
        while ( n != 1 && n != 4) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return  n == 1;
    }
}

