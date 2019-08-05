package enterprise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/3 9:20
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  w牛客网网易练习题
 */

public class NewTetris {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] strs = s.split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int[] arr = new int[m];
        int i = 0;
        while (m > 0) {
            arr[i++] = input.nextInt();
            m--;
        }
        System.out.println(getScore(n, arr));

    }
     private static int getScore(int n, int[] m) {
        if(n <= 0 || m == null || m.length == 0) return 0;
        int[] hash = new int[n + 1];
        hash[0] = Integer.MAX_VALUE;
         for (int aM : m) {
             hash[aM]++;
         }
         Arrays.sort(hash);
         return hash[0];

     }
}

