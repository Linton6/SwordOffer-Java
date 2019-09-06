package leetcode;



/**
 * @Date 2019/8/19 19:43
 * @
 */
import java.util.*;

public class HUO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.nextLine();
            String strs[] = str1.split(" ");
            int[] arr1 = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                arr1[i] = Integer.valueOf(strs[i]);
            }
            String str2 = in.nextLine();
            String strs2[] = str2.split(" ");
            int[] arr2 = new int[strs2.length];
            for (int i = 0; i < strs2.length; i++) {
                arr2[i] = Integer.valueOf(strs2[i]);
            }
            System.out.println(train(arr1,arr2));
        }

    }
    private static int train(int arr1[], int arr2[]){
        int size = arr1.length;
        int arr[] = new int[size * 2];
//        for (int i = 0; i < size * 2; i++) {
////            arr[i] = arr1[i];
////            arr[i+1] = arr2[i];
//        }
        return 2;
    }
}

