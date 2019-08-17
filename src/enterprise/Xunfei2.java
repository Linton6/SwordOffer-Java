package enterprise;

import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/16 18:55
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Xunfei2 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            String s = str.substring(1,str.length() - 1);
            String[] arrs = s.split(",");
            int n = arrs.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.valueOf(arrs[i]);
            }
            int num = query(arr, 0, arr.length , 19);
            System.out.println(num + 1);

        }
    }

    private static int query(int[] arr, int start, int end, int target){
        if (arr == null || arr.length == 0 || start > end) {
            return -2;
        } else {
            int mid = (start + end) / 2;
            if (target == arr[mid]){
                return mid;
            } else if (target < arr[mid]){
                return query(arr, start, mid - 1, target);
            } else {
                return query(arr, mid + 1, end, target);
            }
        }
    }
}

