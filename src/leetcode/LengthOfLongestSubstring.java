package leetcode;

import java.util.HashMap;

/**
 * @Author Linton
 * @Date 2019/8/3 9:07
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  无重复字符的最长子串 数目  和 长度
 */

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstrings("abcabcbb"));




    }

    public static String lengthOfLongestSubstrings(String s) {
        if (s.length()==0) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1); // 目前没有重复字符的位置
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1); // 取两个数较大值用Math.max
        }

        String str = s.substring(left,left+max );
        return str;
    }

//
//    public static int lengthOfLongestSubstring(String s) {
//        if (s.length()==0) return 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//        int max = 0;
//        int left = 0;
//        for(int i = 0; i < s.length(); i ++){
//            if(map.containsKey(s.charAt(i))){
//                left = Math.max(left,map.get(s.charAt(i)) + 1); // 目前没有重复字符的位置
//            }
//            map.put(s.charAt(i),i);
//            max = Math.max(max,i-left+1); // 取两个数较大值用Math.max
//        }
//        return max;
//    }


    /*自己的方法*/
    public static int lengthOfLongestSubstring1(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 0;
        int temp = 1;
        int left_cur = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) != s.charAt(j)) {
                    temp++;
                    if (j == s.length() - 1){
                        if(max < temp){
                            max = temp;
                            temp = 1;

                        }
                    }
                } else if(s.charAt(i) == s.charAt(j) ) {
                    if(max < temp){
                        max = temp;
                        temp = 1;

                    }
                    temp  = 1;
                    break;
                }

            }
        }
        return max;
    }

}

