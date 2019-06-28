package swordOffer;

/**
 * @Author Linton
 * @Date 2019/6/26 16:52
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面
 * 的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符
 * 串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */

public class Match {
    public static void main(String[] args) {
        char[] a = {'a'};
        char[] b = {'.','*'};
        boolean c =  new  Match().match(a,b);
        System.out.println(c);
    }
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null) {
            return false;
        }

        int strIndex = 0;
        int patternIndex = 0;

        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //  同时结束，返回true
        if(str.length == strIndex && pattern.length == patternIndex) {
            return true;
        }
        // pattern先结束，返回false
        if(patternIndex == pattern.length && str.length > strIndex) {
            return false;
        }

        // pattern的第二个字符为 ‘*’
        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // 第一个字符匹配（核心）
            if(str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.') {
                // P +2， S +1
                return matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                // S +1， P +0
                || matchCore(str, strIndex + 1, pattern, patternIndex)
                // S +0, P +2
                || matchCore(str, strIndex, pattern, patternIndex + 2);
            }
            // 第一个字符不匹配
            else {
                // S +0, P +2
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        //  pattern的第二个字符不为 ‘*’
        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] != '*' ) {
            // 第一个字符匹配
            if(str[strIndex] == pattern[patternIndex + 1]) {
                // S +1, P +1
                return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
            }
            // 第一个字符不匹配
            else {
                return false;
            }
        }
        // 应该没有情况了  这就是str先结束的情况
        return false;
    }
}

