package enterprise;

import java.util.Arrays;
import java.util.Map;

/**
 * @Date 2019/9/22 17:36
 * @
 */

public class 挖矿游戏1 {
    public static void main(String[] args) {
        int arr[] = {3,7,4,11,8,10};
        System.out.println(solution(arr));

    }

    private static  int  solution(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int temp;

        if (len == 1) {
            return arr[0];
        }

        while (right > left) {
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            right--;
            left++;
        }
        int A = arr[1];
        int B = arr[0];
        int min ;
        int max;
        for ( int i = 2; i < len ; i = i + 2) {

            if (i == len - 1) {
                if (A > B) {
                    B += arr[i];
                } else {
                    A += arr[i];
                }
                break;
            }
            min = Math.min(arr[i],arr[i + 1]);
            max = Math.max(arr[i],arr[i + 1]);
            if (A > B) {
                A += min;
                B += max;
            }  else {
                A += max;
                B += min;
            }
        }
        return Math.abs(B - A);
    }
}

