package swordOffer;

import java.util.*;

/**
 * @Author Linton
 * @Date 2019/6/25 15:05
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description  判断二叉树平衡性
 */

public class IsBalanced_Solution {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b; a.right = c;
        c.right = f;
        b.left = d; b.right = e;
        e.right = g;
        IsBalanced_Solution(a);
        System.out.println();

    }

   static List<Integer> list = new ArrayList<Integer>();
    public static boolean IsBalanced_Solution(TreeNode root) {
        //
        Iterator it = list.iterator();
        list.get(0);
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null) {
            return true;
        }

        int n = 1;
        depth(root, n);
        if (list.size() == 1){
            return false;
        }
        Integer v = Collections.max(list) - Collections.min(list);
        return v > 1 ? false : true;



    }

    public static void depth(TreeNode root,int n){
        if(root.left != null){
            int n1 = n;
            n1++;
            depth(root.left, n1);
        }
        if(root.right != null) {
            int n2 = n;
            n2++;
            depth(root.right, n2);
        }
        if(root.left == null && root.right == null) {
            list.add(n);
        }

    }
}

