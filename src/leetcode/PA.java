package leetcode;


/**
 * @Date 2019/8/19 19:26
 * @
 */
import java.util.Scanner;

public class PA {
    public static void main(String[] args) {
//        String s = "ds";
//        Integer.valueOf()
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(stair(n));

    }
    // 爬楼梯
    private static long stair(long n) {
        if (n <= 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;

        long pre = 2 ;
        long prepre = 3;
        long res = 0;
        for (long i = 4; i <= n; i++) {
            res = pre + prepre;
            prepre = pre;
            pre = res;

        }
        return res;
    }
}

