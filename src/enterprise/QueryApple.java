package enterprise;

import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/3 10:31
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class QueryApple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ai[] = new int[n];
        int i = 0;
        while (n > 0) {
            ai[i++] = in.nextInt();
            n--;
        }
        int m = in.nextInt();
        int qi[] = new int[m];
        int j = 0;
        while (m > 0) {
            qi[j++] = in.nextInt();
            m--;
        }
        apple(ai.length, ai, qi.length, qi);


    }

    private static void apple(int n, int ai[], int m, int qi[]) {
        // 边界条件
        for (int i = 1; i < n; i++){
            ai[i] = ai[i - 1] + ai[i];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ai[j] >= qi[i] ) {
                    System.out.println(j+1);
                    break;
                }
            }
        }
    }
}

