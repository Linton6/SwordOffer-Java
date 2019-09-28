package enterprise;

/**
 * @Date 2019/9/10 21:20
 * @将阿拉伯数字转为罗马数字
 */

import java.util.*;
public class DianXinYun2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(convert(n));

    }

    private static String convert(int num) {
        StringBuilder str = new StringBuilder();
        int arr[] = {1000, 500,  100,  50,  10, 5, 1};
        String[] strArr = {"M", "D",  "C",  "L" ,"X","V","I"};
        int len = arr.length;
        if (num < 1 || num > 10000) {
            return "-1";
        } else {
            for (int i = 0; i < len; i++) {
                while (num >= arr[i]) {
                    str.append(strArr[i]);
                    num -= arr[i];
                }
            }
        }
        return str.toString();

    }
}

