package leetcode;

/**
 * @Author Linton
 * @Date 2019/7/26 16:12
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  第四章 动态规划
 */

public class Zuochengyun {

    public static void main(String[] args) {


    }



    // 求两个矩阵相乘的具体实现  里面嵌套3个for循环
    public int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        int max = Math.max(m1.length, m2[0].length);
        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m2[0].length; j++)
                for (int k = 0; k < m2.length ; k++)
                    res[i][j] += m1[i][k] + m2[k][j];

        return res;
    }
}

