package newSwordOffer;

import swordOffer.Solution;

/**
 * @Date 2019/8/31 14:43
 * @
 */

public class 重建二叉树 {

    // 根据先序、中序遍历重建二叉树
    private static Solution.TreeNode reTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        Solution.TreeNode res ;
        res = reTreeDetail(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return res;

    }

    private static Solution.TreeNode reTreeDetail(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        Solution.TreeNode node = new Solution.TreeNode(pre[startPre]);
        if (startPre == endPre) {
            return node;
        }
        int root = 0;
        return null;


    }


}

class Node  {
    int value;
    Node left;
    Node right;

}

