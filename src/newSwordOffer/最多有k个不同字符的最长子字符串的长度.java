package newSwordOffer;

/**
 * @Date 2019/9/14 17:01
 * @最多有k个不同字符的最长子字符串的长度  旷世笔试题
 * https://www.jianshu.com/p/76cde56c2d85
 */
import java.util.*;
public class 最多有k个不同字符的最长子字符串的长度 {

    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int result = 0;
        int left = 0;
        //声明一个HashMap，用来存储k Distinct，还可以根据value用来判断元素是否可以删除
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            //右指针依次把字符串中的字符放到map中
            map.put(s.charAt(right),right);
            //当map元素大于k Distinct时，得到满足要求的子字符串
            while (map.size() > k) {
                // 删除最左的字符，删除成功，则退出循环
                char leftChar = s.charAt(left); // 得到最左边的字符
                /**  核心的思想 */
                if (map.get(leftChar) == left) { // 判断最左边的字符是否就是只有一个？
                    map.remove(leftChar);        // 如果不是，就不能删除，left++，判断下一个字符
                }
                // 左指针右移
                left++;
            }
            //子结果即左右指针之间的长度
            int subResult = right - left + 1;
            //结果取最大
            result = Math.max(result,subResult);
        }
        return result;
    }
}

