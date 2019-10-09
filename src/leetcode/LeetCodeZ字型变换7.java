package leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Date 2019/10/9 9:37
 * @
 */

public class LeetCodeZ字型变换7 {

    public static void main(String[] args) {
        int num = 3;
        String s = "LEETCODEISHIRING";
        System.out.println(convert(s,num));

    }


    public static String convert(String s, int numRows) {
        //画图 自己看，有规律
        //先找出竖行
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        if (len <= numRows) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        //最大间距
        int max = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++) {
            int ind = i;
            sb.append(s.charAt(ind));
            if (ind == 0 || ind == numRows - 1) {
                while ((ind = ind + max) < len) {
                    sb.append(s.charAt(ind));
                }
            } else {
                int temp = max - (i * 2);
                while ((ind = ind + temp) < len) {
                    sb.append(s.charAt(ind));
                    if ((ind = ind + max - temp) < len) {
                        sb.append(s.charAt(ind));
                    }
                }
            }
        }
        return sb.toString();
    }
    public static String convert1(String s, int num) {
        if(s == null || s.length() == 0 || num <= 0) {
            return null;
        }

        int start = 2 * num - 3;

        StringBuilder sb = new StringBuilder();

        StringBuilder from = new StringBuilder(s);

        List<Integer> list = new ArrayList<>();

        while (from.length() != 0) {
            int length = from.length();
            int i = 0;
            while (i < length && list.add(i)){
                sb.append(from.charAt(i));

                i =  i + start + 1;
            }

            if (start == 0) {
                break;
            } else {
                start -= 2;
            }
            Collections.reverse(list);
            for(Integer j : list) {
                from.deleteCharAt(j);
            }

            list.removeAll(list);
        }


        return sb.toString();

    }
}

