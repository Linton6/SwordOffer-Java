package swordOffer;

import java.util.*;

/**
 * @Author Linton
 * @Date 2019/6/24 14:23
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class TreeDepth {

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
        c.right = f;

        TreeDepth(a);
        System.out.println();

        HashMap map = new HashMap();
    }

    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int count = 1;

        dept(root, count);
        return Collections.max(list)-1;
    }

    public static void dept(TreeNode root,int count) {
        if(root.left != null){
            int count1 = count;
            count1++;
            dept(root.left, count1);
        }

        if(root.right != null){
            int count2 = count;
            count2++;
            dept(root.right, count2);
        }
        list.add(count);
    }
}

