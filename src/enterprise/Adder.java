package enterprise;

/**
 * @Author Linton
 * @Date 2019/8/8 19:07
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.util.Scanner;

public class Adder {
    private static String add(String num1, String num2)
    {
        char[] num1s = num1.toCharArray(); 
        char[] num2s = num2.toCharArray();
        StringBuilder str = new StringBuilder();
        int i = num1s.length - 1;
        int j = num2s.length - 1;
        int count = 0;
        while (i >= 0 || j >= 0){ 
            int temp = 0;
            if (i < 0) {
                temp = num2s[j--] + count - '0';
            }
            if (j < 0) {
                temp = num1s[i--] + count - '0';
            }
            if (i >= 0 && j >= 0) {
                temp = num1s[i--] + num2s[j--] + count - 2 * '0';
            }
            if (temp > 9) {
                count = 1;
                temp -= 9;
            } else {
                count = 0;
            }
            str.append(temp);
            if (i < 0 && j < 0 &&count == 1) {
                str.append(count);
            }
        }
        String string = str.reverse().toString();
//        string = string.replace('-','.');
//        int size = string.length();
//        int h = 0;
//        for (int k = size -1; k > 0 ; k--) {
//            if (string.charAt(k) =='0') {
//                h = k;
//            } else {
//                break;
//            }
//        }
//        String wwe = string.substring(0, h);
        // 2234567890223456789022345678902234567890.223456789022345678902234567890223456789
        return   string;
    }

    // please don't modify any code below.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        String sum = add(num1, num2);
        System.out.println(sum);
    }
}