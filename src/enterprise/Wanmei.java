package enterprise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Date 2019/8/23 18:57
 * @
 */
import java.util.*;
public class Wanmei {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");
        int size = strs.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        int N = in.nextInt();
        System.out.println(boat(N, arr));

    }
    private static int boat(int limit, int[] weight) {
        if (weight == null || weight.length == 0) {
            return 0;
        }
        Arrays.sort(weight);
        int size = weight.length + 1;
        int[] newArr = new int[size];
        for (int i = 0; i < weight.length; i++) {
            newArr[i] = weight[i];
        }
        int count = 0;
        for (int i = 0; i < size - 1 ; i++) {
            count++;
            if (newArr[i] == 0){
                count--;
            }
            if (newArr[i] + newArr[i + 1] <= limit) {
                i++;
            }
            if (newArr[i] == 0){
                count--;
            }
        }
        return count;
    }
}

