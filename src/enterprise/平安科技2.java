package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/10/10 21:57
 * @ 判断两个指定的IPV4是否处于同一个子网  输入： 1.1.1.1 1.1.1.2 24  输出：true
 */

public class 平安科技2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");
        String str1 = strs[0];
        String str2 = strs[1];
        String str3 = strs[2];

        System.out.println(solution(str1,str2,str3));



    }

    private static boolean solution(String str1, String str2, String str3) {
        int num = Integer.valueOf(str3);
        int[] arr1 = new int[4];
        String[] str1s = str1.split("\\.");
        for (int i = 0; i < 4; i++) {
            arr1[i] = Integer.valueOf(str1s[i]);
        }

        int[] arr2 = new int[4];
        String[] str2s = str2.split("\\.");
        for (int i = 0; i < 4; i++) {
            arr2[i] = Integer.valueOf(str2s[i]);
        }

        int num1 = num / 8; // 前num1个数应该相同
        int num2 = num % 8; // 第 num1的数的值
        int num3 = 0;
        if (num2 == 7) {
            num3 = 254;
        } else if (num2 == 6) {
            num3 = 252;
        } else  if (num2 == 5) {
            num3 = 248;
        }else  if (num2 == 4) {
            num3 = 240;
        }else  if (num2 == 3) {
            num3 = 224;
        }else  if (num2 == 2) {
            num3 = 192;
        }else  if (num2 == 1) {
            num3 = 128;
        }else  if (num2 == 0) {
            num3 = 0;
        }


        return true;

    }
}

