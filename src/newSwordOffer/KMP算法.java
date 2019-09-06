package newSwordOffer;

/**
 * @Date 2019/8/30 15:06
 * @ 匹配部分字符串 KMP的整体时间复杂度为O(m + n)。
 */

public class KMP算法 {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println(KMPSerach(str1,str2));

    }

    private static int KMPSerach(String str1, String str2) {
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int len1 = chs1.length;
        int len2 = chs2.length;
        int []next = getNext(chs2);
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            /** 如果 j= -1 ,或者当前字符串匹配成功,都令i++,j++*/
            if (j == -1 || chs1[i] == chs2[j]){
                i++;
                j++;
            }else {
                /** next[j]为j所对应的的next值*/
                j = next[j];
            }
        }
        if (j == len2) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] getNext(char[] chs) {
        int size = chs.length;
        int next[] = new int[size];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < size - 1) {
            if (k == -1 || chs[j] == chs[k]) {
                k++;
                j++;
                next[j] = k;
                // 下数5行属于优化
//                if (chs[j] != chs[k]){     // 优化的代码
//                    next[j] = k; // 原本的代码 // 优化的代码
//                } else{                     // 优化的代码
//                    next[j] = next[k];       // 优化的代码
//                }                          // 优化的代码

            } else {
                k = next[k];
            }
        }
        return next;
    }
}

