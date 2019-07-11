package swordOffer;

/**
 * @Author Linton
 * @Date 2019/7/9 10:29
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class KthNode {

    public static void main(String[] args) {
        KthNode k = new KthNode();
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(11);
        a.left = b; a.right = c;b.left = d; b.right = e;
        c.left = f;c.right = g;
        k.KthNode(a,2);
        System.out.println();
    }

    TreeNode target = null;
    Integer k1;

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k <= 0) {
            return null;
        }
        k1=k;
        return  midOrder( pRoot);

    }
    // midOder
    TreeNode midOrder(TreeNode pRoot){

        if(pRoot.left != null) {target = midOrder(pRoot.left);}
        if(target == null){
            if(k1 == 1)
                target = pRoot;
            k1--;
        }
        if(pRoot.right != null && target == null) { target = midOrder(pRoot.right);}

        return target;
    }
}

