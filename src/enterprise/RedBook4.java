package enterprise;


/**
 * @Author Linton
 * @Date 2019/8/18 16:39
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.Scanner;

public class RedBook4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            int T = in.nextInt();
            int M = in.nextInt();
            int[] H = new int[N];
            for (int i = 0; i < N; i++) {
                H[i] = in.nextInt();
            }
        System.out.println(kill(N,T,M,H));
    }
    private static int kill (int N, int T, int M, int[] H) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += H[i];
        }
        int n  = (sum - (T - M)) / M;
        return n+1;

    }
}

