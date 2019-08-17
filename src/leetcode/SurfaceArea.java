package leetcode;

/**
 * @Author Linton
 * @Date 2019/8/16 20:50
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class SurfaceArea {
    public static void main(String[] args) {
        int[][] grid = {{},{},{},{}};
        int [][] aa = {{1,0},{0,2}};
        surfArea(aa);

    }

    /**
     * 求表面积
     * 2019-8-16 20:50:59
     * @param grid
     */
    private static void surfArea(int grid[][]) {
        int N = grid.length;
        int M = grid[0].length;
        int front = 0;
        int back = 0;
        int left = 0;
        int right = 0;

        int row[] = new int[M];
        int col[] = new int[N];
        int nes = 0;

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] > 0)
                    ++nes;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                 row[j] = grid[i][j] ;
            }
            for (int k = 0; k < M; k++){
                if (k == 0) {
                    right += row[k];
                } else
                    right += Math.max(row[k] - row[k - 1], 0);

            }
            for (int k = M -1; k >= 0; k--){
                if (k == M - 1){
                    left += row[k];
                } else
                    left += Math.max(row[k] - row[k + 1], 0);

            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                col[j] = grid[j][i]  ;
            }
            for (int k = 0; k < N; k++){
                if (k == 0) {
                    front += col[k];
                } else
                    front += Math.max(col[k] - col[k - 1], 0);

            }
            for (int k = N - 1; k >= 0; k--) {
                if (k == N - 1) {
                    back += col[N - 1];
                } else
                    back += Math.max(0, col[k] - col[k + 1]);

            }
        }

        int num =  right + left + front + back + nes*2;
        System.out.println(num);

    }
}

