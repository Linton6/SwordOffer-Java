package enterprise;


/**
 * @Date 2019/8/25 19:31
 * @ 花园修路
 */
import java.util.Scanner;

public class ZX {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            System.out.println(count(n));
        }

    }
    private static long count (int n) {
        if (n == 2){
            return 1;
        }
        if (n == 4) {
            return 2;
        }

        long a = 1;
        long b = 2;
        long res = 0;

        for (int i = 6; i <= n; i += 2){
            res = 5 *(b - a);
//            if (b > res) {
//                long c  = b; b =  5 *(b - a);
//                a = c;
//                continue;
//            }
            a = b;
            b = res;
        }
        return res % 1000000007;


    }
}

