package enterprise;

/**
 * @Date 2019/9/11 20:19
 * @
 */




import java.util.*;

public class XiaoMi3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 4;
        int s = in.nextInt();

        String str = "";

        String[] strs = str.split(" ");
        int len = strs.length;

        for (int i = 0; i < len; i++) {

        }


        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    arr[i][j] *= 2;
                    arr[i][j + 1] = 0;
                }
            }
            int t = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    arr[i][t] = arr[i][j];
                    t++;
                }
            }
            while (t < n) {
                arr[i][t] = 0;
                t++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}