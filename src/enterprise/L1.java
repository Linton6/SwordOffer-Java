package enterprise;



/**
 * @Author Linton
 * @Date 2019/7/30 19:52
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 输出字符串二进制个数   输出1 - 1000 中二进制1的个数
 */
import java.util.Arrays;
import java.util.Scanner;
public class L1 {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String s = input.nextLine();
//        System.out.println(s);
//        int sum = transfer(s);
//        System.out.println(sum);
//        int n = binary(10000);
//        System.out.println(n);
        int[] arr = {2,3,4,2,6,2,5,1};
        int a[] = slide(arr, 3);
        System.out.println(Arrays.toString(a));


    }

    public  static int transfer(String s) {
        if (s == null || s.length() == 0) return 0;
        int num = 0;
        int sum =0;
        for(int i = 0; i< s.length(); i++) {
            num = s.charAt(i);
            while(num / 2 != 0 ) {
                sum++;
                num -= 2;
            }
        }
        return sum;
    }


    /**
     * 输出1 - 1000 中二进制1的个数
     * @param n
     * @return
     */
    public static int binary(int n) {
        int num = 0;
        for (int i = 1; i < n; i++) {
            Integer h = i;
            int size = Integer.bitCount(h);
            num += size;
        }
        return num ;
    }

    /**
     * 滑动窗口最大值
     * @param arr
     * @param n
     * @return
     */
    public static int[] slide(int[] arr, int n) {
        if(arr == null || arr.length == 0 || n <= 0) return null;
        if (n == 1) return arr;
        int[] slide = new int[arr.length - n + 1];
        int cur = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i >= n - 1) {
                int tmp = arr[i];
                for (int j = i; j > i - n ; j--){
                    if (arr[j] >= tmp) {
                        max = arr[j];
                        tmp = arr[j];
                    }
                }
                slide[cur++] = max;
            }
        }

        return slide;
    }
}

