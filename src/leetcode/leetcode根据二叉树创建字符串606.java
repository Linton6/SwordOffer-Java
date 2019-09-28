package leetcode;

import swordOffer.Solution;

/**
 * @Date 2019/9/7 10:01
 * @
 */

public class leetcode根据二叉树创建字符串606 {
    public static void main(String[] args) {

    }

    private static String treeTostr(TreeNode t) {
        if (t == null)
            return "";
        StringBuilder sb = new StringBuilder();
        TreeNode pre = null;
        helper(t, pre, sb);
        return sb.substring(1,sb.length() - 1);
    }

    private static void helper(TreeNode t, TreeNode pre, StringBuilder sb) {
        if (t == null)
            return ;
        // 前序遍历
        // 如果pre的左子树为空，右子树不为空，（）不能省略
        if(pre != null && pre.left == null && pre.right != null) {
            sb.append("()");
        }
        sb.append("(").append(t.val);
        pre = t;

        helper(t.left, pre, sb);
        helper(t.right, pre, sb);

        sb.append(")");


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

