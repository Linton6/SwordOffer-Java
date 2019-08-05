package zuo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Linton
 * @Date 2019/8/5 22:01
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 * 字典序：
 * 字符串长度相等，理解为十六进制比较大小，比如“abc"和”bcd"，“abc"字典序比”bcd"小；
 * 如果长度不相等，在短的字符串后面补0，然后按照相等长度字符串比较，如“abc”和“b"，”abc“的字典序比”b00“小
 *
 * 贪心策略典型例题
 * 给一组字符数组，"b","ba","asd","tsd"，拼接成字典序最小的排列，1.哈夫曼编码
 *
 * 贪心策略：
 * str1 和str2 ： str1.str2 <= str2.str1 （字典序）,则str1放在前面，否则str2放在前面
 */

public class GreedyStrategy07 {
    // 代码贼短
    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) { /** @h核心，贪心策略*/
            return (a + b).compareTo(b + a);  /** @原来默认是字典序啊*/
        }
    }
    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
}

