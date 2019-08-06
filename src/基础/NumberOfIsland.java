package 基础;

/**
 * @Author Linton
 * @Date 2019/8/5 20:47
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  求岛的个数：
 * 一个矩阵中的只有0和1,两种值，每个位置都可以有自己的上下左右四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛。
 */

public class NumberOfIsland {
    public static void main(String[] args) {

    }

    private static int countUslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] m, int i , int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) { // 防止越界和不等于1
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }
}

