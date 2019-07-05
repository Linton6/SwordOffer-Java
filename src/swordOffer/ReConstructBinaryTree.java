package swordOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        ReConstructBinaryTree r = new ReConstructBinaryTree();
        TreeNode a = r.reConstructBinaryTree(pre, in);


    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre, int startPre, int endPre, int [] in, int startIn, int endIn) {

        if(startPre > endPre || startIn > endIn)
            return null;
        //  新建一个节点，前序遍历的第一个数，是根节点的值
        TreeNode root = new TreeNode(pre[startPre]);

        for(int i = startIn; i <= endIn; i++)
            if(in[i] == pre[startPre]){
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }

        return root;
    }
}

class TreeNode {
   int val;
   TreeNode left = null;
   TreeNode right = null;
   TreeNode(int x) {
       val = x;
   }
}