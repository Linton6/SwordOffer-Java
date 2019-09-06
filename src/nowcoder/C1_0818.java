package nowcoder;


/**
 * @Author Linton
 * @Date 2019/8/18 10:12
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.Scanner;
import java.io.*;
public class C1_0818 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(dp(str));
        br.close();

//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            String str = in.nextLine();
//            if (str.equals("exit")) {
//                break;
//            }
//            String[] strs = str.split(" ");
//            String str1 = strs[0];
//            String str2 = strs[1];
//            System.out.println(bing(str1, str2));
//        }
    }

    /**
     * 最小代价爬楼梯
     */
    /**
     * 动态规划解法
     */
    private static int dp(String str){
        String[] strs = str.split(",");
        int[] arr = new int[strs.length ];
        for (int i = 0; i < strs.length; i++) {
            arr[i ] = Integer.valueOf(strs[i]);
        }
        int len = strs.length;
        int dp[] = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i =2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + arr[i - 1],dp[i - 2] + arr[i - 2]);
        }
        return dp[len];
    }

    private static int stair(String str){
        String[] strs = str.split(",");
        int[] arr = new int[strs.length+1];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }

        int n = arr[0] < arr[1] ? 0 : 1;
        int count = arr[n];
        for (int i = n; i < arr.length - 2 ; i++) {
            if (i == arr.length - 3) {
                count += arr[arr.length - 1];
                return count;
            }
            if (i == arr.length - 2) {
                count += arr[arr.length - 1];
                return count;
            }
            if (arr[i+1] < arr[i + 2]) {
                count += arr[i + 1];
            } else {
                count += arr[i+ 2];
                i++;
            }
        }
        return count;

    }

    /**
     * 字符串包含
     * 2019-8-18 10:19:10
     */
    private static int bing(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        return len1 > len2 ? compare(str1, str2) : compare(str2, str1);
    }

    private static int compare(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            int temp = i;
            int j = 0;
            if (str1.charAt(i) == str2.charAt(j)) {
                while ((i < str1.length() && j < str2.length()) && str1.charAt(i) == str2.charAt(j)) {
                    if (j == str2.length() - 1) {
                        return 1;
                    }
                    i++;
                    j++;
                }
            }
            i = temp;
        }
        return 0;
    }
}

