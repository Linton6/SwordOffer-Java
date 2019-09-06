package enterprise;


/**
 * @Author Linton
 * @Date 2019/8/18 14:33
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.io.*;
import java.util.Scanner;

public class ReadBook {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int N = Integer.valueOf(strs[0]);
            String array = strs[1].substring(1,strs[1].length() - 1);
            String[] arrays = array.split(",");
            int size = arrays.length;
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.valueOf(arrays[i]);
            }
            System.out.println(buy(arr,N));
//        }

    }

    public static int buy(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) return 0;
        int[][] dp = new int[arr.length][aim + 1];

        for (int i = 0; i < arr.length; i++){
            dp[i][0] = 1;
        }
        for (int j = 0; j * arr[0] <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++){
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }
}

