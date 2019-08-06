package 基础.进阶;

/**
 * @Author Linton
 * @Date 2019/8/6 16:24
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 * Manacher算法详解与应用 ：@在一个字符串中找到最长回文子串（正着念，反着念都一样）
 *
 * 暴力解法 时间复杂度O(N的平方)
 * 比如11311（无论奇数个还是偶数个），转换成#1#1#3#1#1#，for循环，从第一个字符开始，向两边括 str[i-1],str[i+1]比较 ，得到最大的数。即为最长回文子串数目。
 *
 * Manacher算法 时间复杂度O(N)
 * 回文半径数组 arr[]，回文右边界 R，回文右边界中心 C
 * 分情况：
 *  1) i 在 R 外  继续扩
 *  2) i 在 R 内
 *      i) i'() 在L,R 内  直接返回R
 *      ii) i'() 在L,R 内  直接返回R
 *      iii) i'() 在L,R 压线  继续扩   坚实的基础，好处，遇见类似的题，直接解了
 *
 *  得好好练一练，扣边界
 */

public class Manacher01 {

    /** @题型1
     *  给定一个字符串str1，要求再加上str2构成回文串。且str2最短
     *  分析：求出str1的最短回文串，（包含最后一个字符的最长回文串？？），然后将非回文串部分复制一份，逆序操作，加在str1后面，作为str2
     */
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLengrh(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chartArr = manacherString(str);
        int[] pArr = new int[chartArr.length];
        int C = -1;
        int R = -1;
        int max = Integer.MAX_VALUE;
        for (int  i = 0; i != chartArr.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i ) : 1;
            // 都扩一下，情况2,3 括了会失败，不影响，优化代码长度，把本应该的ifelse处理成while  [扣边界]
            while (i + pArr[i] < chartArr.length && i - pArr[i] >  -1) {
                if (chartArr[i + pArr[i]] == chartArr[i - pArr[i]])
                    pArr[i]++;
                else
                    break;
            }
            if (i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLengrh(str1));
    }


}

