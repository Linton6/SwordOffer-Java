package swordOffer;

/**
 * @Author Linton
 * @Date 2019/6/29 10:45
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 对称点额二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 */

//推荐
/*思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
 * 左子树的右子树和右子树的左子树相同即可，采用递归
 * 非递归也可，采用栈或队列存取各级子树根节点
 *
 * public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }
    private boolean comRoot(TreeNode left, TreeNode right) {
        // TODO Auto-generated method stub
        if(left == null) return right==null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }
}
 */

import java.util.*;
public class IsSymmetrical {

    public static void main(String[] args) {
        IsSymmetrical is = new IsSymmetrical();
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(5);
        a.left = b; a.right = c; b.left = d; b.right = e; c.left = f; c.right = g;
        is.isSymmetrical(a);


    }
    static ArrayList<TreeNode> list_left = new ArrayList<TreeNode>();
    static ArrayList<TreeNode> list_right = new ArrayList<TreeNode>();
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) {
            return false;
        }
        if(pRoot.left == null && pRoot.right == null) {
            return true;
// 本地测试 if if 和 if  else if 区别
        } else if (pRoot.left == null || pRoot.right == null) {
            return false;
        }
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        preQuery(left);
        reerQuery(right);
        int size_left = list_left.size();
        int size_right = list_right.size();
        if(size_left != size_right) return false;
        for(int i = 0; i < size_left; i++) {
            if(list_right.get(i).val!= list_left.get(i).val){
                return false;
            }
        }
        return true;


    }
    //前序遍历
    public void preQuery(TreeNode node){
        list_left.add(node);
        if(node.left != null) preQuery(node.left);
        if(node.right != null) preQuery(node.right);
    }
    //后续遍历,不是后续遍历，前序遍历的改版
    public void reerQuery(TreeNode node) {
        list_right.add(node);
        if(node.right != null) reerQuery(node.right);
        if(node.left != null) reerQuery(node.left);

    }

}

