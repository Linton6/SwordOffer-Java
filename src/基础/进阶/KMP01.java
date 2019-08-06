package 基础.进阶;

/**
 * @Author Linton
 * @Date 2019/8/6 13:43
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 * KMP ： str1 与str2相同子串的起始位置  abc123def 与 1234d
 * 子序列：可以连续也可以不连续
 * 子串/子数组x：必须连续
 * 概念：最长前缀字符串和最长后缀字符串
 */

public class KMP01 {


    /**
     * @题型一
     * str1 与str2相同子串的起始位置  abc123def 与 1234d
     * @param s
     * @param m
     * @return
     */
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {  // -1 没得跳转。 表明str2开头第一个字符都配不上str1的第一个字符，需要i1++
                i1++;
            } else {
                i2 = next[i2];  //  有的跳转
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    //   理解有点难度
    /**
     * @题型二
     * 得到最长前缀和最长后缀的长度数的数组
     * @param str2
     * @return
     * 适用场景题： 给一个字符串str1，然后添加一个字符串str2，要求添加的字符串str2最短，使得新的字符串str3包含两个str1，且开头不再同一位置。
     * 上述题目。本质就是求str1的最长前缀和后缀，求出返回的int值后，str2 即为  int值 - str1.length范围的字符串。
     */
    private static int[] getNextArray(char[] str2) {
        if (str2.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;  // 字符串的指针
        int cn = 0; // 跳转的位置
        while (i < next.length) {
            if (str2[i - 1] == str2[cn]) {
                next[i++] = ++cn;  // 如果前面相同，那么cn值就是在前面的cn值的基础上加1
            } else if(cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
    /**
     * @题型三
     * 求T2 树是否是T1 树的一部分
     * 分析：将T1 和 T2 （前序）序列化为为字符串 str1 和str2 ，判断str2是否是str1的子串，即可证明此题。一个KMP搞定，本质和题型一相同
     * PS：二叉树序列化为字符串，注意两点，空节点用 # 表示，每个节点用 _ 分开
     */

    /**
     * @提醒四
     * 判断某个字符串是否是由某个范式重复得出的。
     * 分析：验证 字符串前缀数目 是否是 整数倍关系即可
     */
}

