package enterprise;

import java.util.*;

/**
 * @Date 2019/9/8 15:59
 * @排序计数
 */

public class Aiqiyi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            arr[i] = in.nextInt();
        }

        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = i+1;
        }
        permutaions(a,0,n-1);
        System.out.println(num);


    }


    /**
     * 思路一，暴力法
     * @param arr
     * @param target
     * @return
     */
    // 此数组是否符合要求
    private static boolean judeg(int[] arr, int[] target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1){
                if (target[i] < target[ i+ 1]) {
                    return false;
                }
            } else {
                if (target[i] > target[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
    public  static  int num = 0;
    public  static int[] arr ;
    // 全排列
    public static void permutaions(int[] a, int m, int n) {
        if (m == n) {
            if (judeg(arr,a)){
                num++;
            }
        } else {
            for (int i = m; i <= n; i++) {
                int temp = a[m];
                a[m] = a[i];
                a[i] = temp;
                permutaions(a,m+1,n);
                temp = a[m];
                a[m] = a[i];
                a[i] = temp;
            }
        }
    }


    /**
     * 思路2：递归
     */
    private static int rec(int[] A, int[] P, int len){
        for (int i = 0; i < len - 1; i++) {
                for (int j = 1; j <= len; j++) {
                    if (A[i] == 1) {
                        if (j + 1 > len){
                            break;
                        }
                    } else {
                        if ( j - 1 <= 0) {
                            break;
                        }
                    }
                }

        }
        return 1;
    }
}

