package enterprise;

import java.util.Scanner;

/**
 * noteExpress@Date 2019/10/10 21:41
 * @ 两个指定的字符串最长公共子串  输入：1234567 12893457  输出： 345
 */

public class 平安科技1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");
        String str1 = strs[0];
        String str2 = strs[1];

        System.out.println(getLast(str1,str2));

    }

    public static int getLast(String str1, String str2) {
        char[] ary = str1.toCharArray();
        char[] ary2 = str2.toCharArray();

        int[][] temp = new int[ary.length][ary2.length];
        int length = 0;
        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary2.length; j++) {
                if (ary[i] == ary2[j]) {
                    if (i > 0 && j > 0) {
                       temp[i][j] = temp[i - 1][j - 1] + 1;
                    } else {
                        temp[i][j] = 1;
                    }

                    if (temp[i][j] > length) {
                        length = temp[i][j];
                    }
                } else {
                    temp[i][j] = 0;
                }
            }
        }
        return length;

    }

    private static String solution(String str1, String str2){
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return null;
        }

        int len1 = str1.length();
        int len2 = str2.length();

        if (str1.contains(str2)) {
            return str2;
        }
        if (str2.contains(str1)) {
            return str2;
        }
        return null;



//        int len1 = str1.length();
//        int len2 = str2.length();
//
//        int[] topLine = new int[len1];
//        int[] currentLine = new int[len1];
//
//        int maxLen = 0;
//
//        int pos = 0;
//        char ch = ' ';
//        for (int i = 0; i < len2; i++) {
//            ch = str2.charAt(i);
//            for (int j = 0; j < len1; j++) {
//                if (ch == str1.charAt(j)) {
//                    if (j == 0) {
//                        currentLine[j] = 1;
//                    } else {
//                        currentLine[j] = topLine[j - 1];
//                    }
//
//                    if (currentLine[j] > maxLen) {
//                        maxLen = currentLine[j];
//                        pos = j;
//                    }
//                }
//            }
//
//            for (int k = 0;k < len1; k++) {
//                topLine[k] = currentLine[k];
//                currentLine[k] = 0;
//            }
//        }
//
//        return str1.substring(pos - maxLen + 1, pos + 1);


    }

}

