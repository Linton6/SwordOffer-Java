package enterprise;

/**
 * @Date 2019/9/1 20:27
 * @搬运工
 */
import java.util.*;
public class Tencent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int ai[] = new int[n];
        for (int i= 0; i < n; i++) {
            ai[i] = in.nextInt();
        }

        System.out.println(carry(ai,n,m));

    }

    private static int carry(int[] ai,int n, int m) {
        int sum = 0;
        int mid = 0;
        for (int i = 0; i < n; i++) {
            sum += ai[i];
            if (sum > m) {
                i = mid;
                break;
            }
        }
        if (sum <= m) {
            return n+1;
        }
        return m + n - mid + 1;

    }
}

