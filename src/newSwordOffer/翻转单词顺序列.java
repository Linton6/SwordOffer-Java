package newSwordOffer;

import java.util.HashMap;

/**
 * @Date 2019/9/8 19:41
 * @
 */

public class 翻转单词顺序列 {
    public static void main(String[] args) {
        String str = "student. a am I";
        System.out.println(reverse(str));

    }

    // 分为两步：一步整个字符串反转，下一步反转单个单词
    private static String reverse(String str) {
        if (str == null || str.length() == 0 || str.length() == 1 ) {
            return str;
        }
        char[] chs = str.toCharArray();
        int len = chs.length;
        rev(chs, 0, len - 1);
        int low = 0;
        int high = 0;
        while (high <= len -1) {

            if (high == len - 1) {
                rev(chs, low, high);
                break;
            }

            if (chs[high] != ' ') {
                high++;
                continue;
            }
            rev(chs, low, high - 1);
            low = ++high ;
        }

        return new String(chs);
    }

    // 反转单词
    private static void rev(char[] chs, int low, int high) {
        char temp ;
        while (low < high) {
            temp  = chs[low];
            chs[low++] = chs[high];
            chs[high--] = temp;
        }
    }
}

