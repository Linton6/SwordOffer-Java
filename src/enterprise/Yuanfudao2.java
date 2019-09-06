package enterprise;

import java.util.Arrays;

/**
 * @Date 2019/8/24 17:11
 * @
 */
import java.util.*;
public class Yuanfudao2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String n1 = in.nextLine();
        int n = Integer.valueOf(n1);
        String[] strs = new String[n];
        int i = 0;
        while (n-- > 0) {
            String str = in.nextLine();
            strs[i++] = str;
        }
        for (int j = 0; j < strs.length; j++) {
            String[] s = strs[j].split(" ");
            int size = s.length;
            int[] arr = new int[size - 1];
            for (int k = 1; k < size; k++){
                arr[k-1] = Integer.valueOf(s[k]);
            }
            group(arr);
        }

    }

    private static void group(int[] arr) {
        int size = arr.length;
        if (size <= 2){
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);
        System.out.println(arr[size - 3]);

    }
}

