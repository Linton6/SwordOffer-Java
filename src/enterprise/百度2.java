package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/9/17 20:33
 * @最小值
 */

public class 百度2 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        System.out.println(min(n, m, k));

    }

    private static int min(int n, int m, int k){
        int sum = n + m;
        int mid = sum / 2;

        return mid;

    }
}

