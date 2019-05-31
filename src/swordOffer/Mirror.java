package swordOffer;


import java.util.ArrayList;

/**
 * @Author Linton
 * @Date 2019/5/21 16:06
 * @Version 1.0
 * @Description
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */

public class Mirror {
    public static void main(String[] args) {
//        int[][] a =new  int[0][0];
//         int i = a.length;
//         int ii = a[2].length;
//        String b = "dsdsd";
//        int[] c = {2,4,3};
//        int q =b.length();
//        int v = c.length;
//        ArrayList r =new ArrayList();
//        r.add(1);
//        int y = r.size();

        int[] a = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> aa = new ArrayList<>();
        aa = GetLeastNumbers_Solution(a,4);
        System.out.println("11");




    }


    // 镜像程序
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return ;
        }
        if (root.left != null || root.right != null) {
            Exchange(root);
        }

    }

    // 左右子节点进行交换
    public static void Exchange(TreeNode root1) {
        TreeNode tmp;
        if (root1.right != null && root1.left != null) {
            tmp = root1.right;
            root1.right =  root1.left;
            root1.left = tmp;
            Mirror(root1.left);
            Mirror(root1.right);

        } else if (root1.right != null && root1.left == null) {
            root1.left = root1.right;
            root1.right = null;
            Mirror(root1.left);

        } else if (root1.right == null && root1.left != null) {
            root1.right = root1.left;
            root1.left = null;
            Mirror(root1.right);
        }

    }

    /**
     *输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
     *  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     *  则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        // 求矩阵大小
        int row = matrix.length; // 行
        int col = matrix[0].length; // 列
        if (row == 0 || col == 0) {
            return null;
        }
        // for循环先行再列，再行再列，直到为0
        int left = 0;
        int right = col - 1;
        int bottom = row - 1;
        int top = 0;
        while (left <= right && bottom >= top) {
            // left to right
            for (int i = left ; i <= right; i++) {list.add(matrix[top][i]);}
            // top to bottom
            for (int j = top + 1; j <= bottom; j++) {list.add(matrix[j][right]);}
            // right to left
            if (top != bottom){
                for(int j = right - 1; j >= left ; j-- ){list.add(matrix[bottom][j]);}
            }
            // bottom to top
            if (left != right) {
                for (int i = bottom - 1; i > top; i--){list.add(matrix[i][left ]);}
            }
            left++;right--;bottom--;top++;

        }
        return list;
    }

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * @param input
     * @param k
     * @return  我写的都是狗屎吗，这么烂！！！！！！
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k == 0) {
            return null;
        }
        ArrayList<Integer> b = new ArrayList<>();
        // 快速排序法排序
        int[] a = new int[input.length-1];
        a = quicksort(input);
        // 取出前面的k个数
        for(int i = 0; i < k ; i++) {
            b.add(a[i]);
        }
        return b;
    }
    public static int[] quicksort(int[] input) {
        int a = input.length;
        if (a == 1) {
            return input;
        }
        int b = 0;
        // 把所有大于基准数的值放右边，小于基准数的值放左边
        for(int i = 1; i < a; i++) {
            if(input[b] >= input[i]) {
                int tmp = input[i];
                b = i;
                i = tmp;
            } else {

            }
        }
        int tmp = input[b];
        input[b] = input[0];
        input[0] = tmp;
        quicksort(transmit(input, 0, b-1));
        quicksort(transmit(input, b+1,a));
        return input;
    }

    public static  int[] transmit(int[] input, int a, int b) {
        int size = input.length;
        int size1 = b-a+1;
        int[] arr1 = new int[size1];
        for(int i = 0; i < size1; i++) {
            arr1[i] = input[a];
            a++;
        }
        return arr1;
    }

    public Integer num(){
        String a = "a";
        return 1;
    }
}


/*
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
 */

