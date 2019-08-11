package enterprise;


/**
 * @Author Linton
 * @Date 2019/8/10 20:24
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.Scanner;
public class SpecailTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[n];
            int i = 0;
            for (String s : strs){
                arr[i++] = Integer.valueOf(s);
            }
            test(arr);
        }
    }

    private static void test(int[] arr){
        int size = arr.length;
        int[] dp = new int[size];
        dp[0] = 0;
        for (int i = 0; i < size; i++) {
            dp[i] = Math.min(dp[i - 1],dp[i] );
        }
        System.out.println(6);
    }
}

