package enterprise;


/**
 * @Author Linton
 * @Date 2019/8/10 19:03
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = 0;
        int arr[] = new int[n];
        while (n > 0) {
            arr[i++] = in.nextInt();
            n--;
        }
        getMinAbs(arr);
//        while (in.hasNext()) {
//            int n = in.nextInt();
//            in.nextLine();
//            String str = in.nextLine();
//            String[] strs = str.split(" ");
//            int[] arr = new int[n];
//            int i = 0;
//            for (String s : strs){
//                arr[i++] = Integer.valueOf(s);
//            }
//            getMinAbs(arr);
//        }
    }

    private static void getMinAbs(int[] arr) {
        int abs = Math.abs(arr[1] - arr[0]);
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) < abs ) {
                abs = Math.abs(arr[i] - arr[i + 1]);
                k = i;
            }
            if (abs == 0) {
                break;
            }
        }
        System.out.println(arr[k] + " " + arr[k + 1]);
    }
}

