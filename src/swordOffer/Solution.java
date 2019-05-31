package swordOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author Linton
 * @Date 2019/5/29 11:05
 * @Version 1.0
 * @Description
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {5,7,6,9,11,10,8};
//        System.out.println(solution.VerifySquenceOfBST(array));
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        solution.FindPath(treeNode1,22);
        System.out.println(  solution.listAll.toString());




     }

    /**
     * 面试题34
     * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下
     * 一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
     */
    // 这个人写的真是精妙世无双
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }

    /**
     * 面试题33
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        // 确定边界条件
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        // 判断去掉最后一个节点是否还满足需求
        int i = 0 ;
        int length = sequence.length;
        int end = sequence[length - 1];
        for( i = 0; i < length - 1; i++){
            if(sequence[i] > end){
                break;
            }
        }
        for(int j = i; j < length - 1; j++){
            if(sequence[j] < end ){
                return false;
            }
        }
        // 判断左右子树是不是二叉搜索树
        boolean left = true;
        boolean right=true;
        if(i>0){
            int[] lefta = new int[i];
            for(int k = 0; k < i ; k++){
                lefta[k] = sequence[k];
            }
            left = VerifySquenceOfBST(lefta);
        }
        if(i < length - 1){
            int[] righta = new int[length - i-1];
            int j = 0;
            for(int k = i; k < length - 1 ; k++){
                righta[j] = sequence[k];
            }
            right = VerifySquenceOfBST( righta);
        }
        return left&&right;
    }


    /**
     * 二叉树结构
     */
   public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}


