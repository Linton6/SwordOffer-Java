package enterprise;


/**
 * @Date 2019/8/24 20:42
 * @
 */
import java.util.*;

public class JD2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int arr[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        test(n, arr);

    }

    private static void test(int n, int[][] arr) {
        int[] sum = new int[2*n + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                sum[arr[i][j]]++;
            }
        }
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 2 * n; i++) {
            if (sum[i] >= n) {
                count++;
                list.add(sum[i] -1);
            }
        }
        System.out.println(list.size());
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println(list.get(i));
        }
        System.out.print(list.get(list.size() - 1));
    }
}

