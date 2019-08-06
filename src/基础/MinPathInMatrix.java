package 基础;

/**
 * @Author Linton
 * @Date 2019/8/6 12:21
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  暴力递归中出现重复的值，那么一定可以改成递归
 * 无后效性：前面的操作对后面的操作无影响 ，如本题  ；有后效性 ：前面的额操作对后面有影响，如汉诺塔，N皇后问题
 * 无后效性的问题一定可以改成动态规划！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
 *
 * 题目描述：给你一个二维数组，二维数组中 每一个数都是正数，要求从左上角走到右下角，每一步智能向右或者向下。沿途经过的数字要累加起来。返回最小的路径和
 */

public class MinPathInMatrix {

    public static int minPah1(int[][] matrix) {
        return process1(matrix, matrix.length - 1, matrix[0].length - 1);
    }
    /** @暴力递归 */
    // 从(i, j) 出发。到达最右下角位置，最短路径和是多少？
    private static int walk(int[][] matrix, int i, int j ) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) { // ？？
            return matrix[i][j];
        }
        if (i == matrix.length - 1) {
            return matrix[i][j] + walk(matrix, i , i + 1);
        }
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + walk(matrix, i + 1, j);
        }
        int right = walk(matrix, i, j + 1); // right -> 左边位置到右下角的最短路径和
        int down = walk(matrix, i + 1, j);  // down -> 下边位置到右下角的最短路径和
        return matrix[i][j] + Math.min(right, down);
    }


    /** @暴力递归改成动态规划，从右到左，从上到下）  */
    /** @动态规划 空间换时间 */
    private static int process1(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == 0 && j == 0) {
            return res;
        }
        if (i == 0 && j != 0) {
            return res + process1(matrix, i, j - 1);
        }
        if(i != 0 && j == 0) {
            return  res + process1(matrix, i - 1, j);
        }
        return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
    }

    /** @题目： 给一个数组arr,和一个整数aim.如果可以任意选择arr中的数字，能不能累加到aim，返回true或者false */
    private static boolean isSum(int[] arr, int i, int sum, int aim) { /** @背包问题*/
        if (i == arr.length) {
            return sum == aim;
        }
        return isSum(arr, i + 1, sum, aim) || isSum(arr, i + 1, sum + arr[i], aim);  // 不选当前数 || 选当前数
    }

    public static void main(String[] args) {
        int[] arr = {1,4,8};
        int aim = 12;
        System.out.println(isSum(arr, 0, 0, aim));
    }
}

