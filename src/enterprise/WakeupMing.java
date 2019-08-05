package enterprise;

import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/3 9:34
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description    包含大量重复运算，如何优化
 */

public class WakeupMing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String strs[] = s.split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int[] interest = new int[n];
        int[] sober = new int[n];
        int i = 0;
        int j = 0;
        int w = n;
        while (n > 0) {
            interest[i++] = in.nextInt();
            n--;
        }
        while (w > 0) {
            sober[j++] = in.nextInt();
            w--;
        }
        System.out.println(wakeMing(sober.length, m , interest, sober));


    }

    private static int wakeMing(int n, int k,int[] interest, int[] sober) {
        // 约束条件
        if(n <= 0 || k < 0) return 0;

        int max = 0;
        int base = 0;
        int extra = 0;

        for (int i = 0; i < n; i++) {
            if (sober[i] == 0) {
                base = 0;
                for (int h = 0; h < i; h++){
                    if (sober[h] == 1) {
                        base += interest[h];  // 包含大量重复运算
                    }
                }
                for (int h = i + k; h < n; h++){
                    if (sober[h] == 1) {
                        base += interest[h];
                    }
                }
                extra = 0;
                int length = n > i + k ? i + k : n;
                for (int j = i;  j < length; j++){
                    extra  += interest[j] ;
                }
                max = base + extra > max ? base + extra : max ;
            }
        }
        return max;
    }
}

