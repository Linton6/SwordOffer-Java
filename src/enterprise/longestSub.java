package enterprise;

import org.omg.CORBA.MARSHAL;


/**
 * @Author Linton
 * @Date 2019/8/10 19:30
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.Arrays;
import java.util.Scanner;

public class longestSub {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int k = 0; k < n; k++) {
            arr[k] = in.nextInt();
        }
        int[] longSubLength = new int[n];
        for (int j = 0; j < n; j++) {
            longSubLength[j] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])
                    longSubLength[i] = Math.max(longSubLength[j] + 1, longSubLength[i]);
            }
        }
        Arrays.sort(longSubLength);
        System.out.println(longSubLength[n - 1]);
    }
}


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        int i = 0;
//        while (n > 0) {
//            arr[i++] = in.nextInt();
//            n--;
//        }
//        longsub(arr);
//
//    }
//
//    private static void longsub(int[] arr) {
//        int size = arr.length;
//        int[] longSubLength = new int[size];
//        for (int j = 0; j < size; j++) {
//            longSubLength[j] = 1;
//        }
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < i; j++) {
//                if (arr[j] < arr[i])
//                    longSubLength[i] = Math.max(longSubLength[j] + 1 , longSubLength[i]);
//            }
//        }
//        Arrays.sort(longSubLength);
//        System.out.println(longSubLength[size - 1]);
//    }
//}

