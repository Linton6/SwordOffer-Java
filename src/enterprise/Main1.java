package enterprise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/7/17 20:16
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Scanner in1 = new Scanner(System.in);
        String str = in1.nextLine();
        Main1 main1 = new Main1();
        int[] num = main1.tranfer(str);
        int n1 = main1.count(num , num.length);
        System.out.print(n1);

    }
    // 求出最大值的最小值
    int count(int[] arr, int n){
        if(arr == null || arr.length == 0) {
            return -1;
        }

        Arrays.sort(arr);
        int max = arr[n-1] - arr[0];
        int min = arr[1] - arr[0];

        return max - min;
    }

    // 把输入的string类型转化为n个数字
    int[] tranfer(String str) {
        if (str == null || str.length() == 0){
            return null;
        }
        String[] strings = str.split(" ");
        int[] num = new int[strings.length];
        for (int i = 0; i < strings.length; i++){
            num[i] =Integer.valueOf(strings[i]) ;
        }

        return num;
    }
}

