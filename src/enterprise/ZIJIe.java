package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/8/25 19:12
 * @ 字节：豆油瓶
 */

public class ZIJIe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n1 = in.nextLine();
        int n = Integer.valueOf(n1);
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s =  in.nextLine();
            String[] ss = s.split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.valueOf(ss[j]);
            }
        }
        System.out.println(douyou(arr));

    }
    private static int douyou (int[][] arr) {
        boolean[] flag = new boolean[arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!flag[i]) {
                digui(arr, flag, i);
                res++;
            }
        }
        return res;

    }

    private static void digui(int[][] arr, boolean[] flag, int i) {
        for (int j = 0; j < arr.length; ++j) {
            if (arr[i][j] >= 3 && !flag[j] ) {
                flag[j] = true;
                digui(arr, flag, j);
            }
        }
    }
}

