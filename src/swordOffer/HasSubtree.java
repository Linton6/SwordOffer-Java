package swordOffer;

/**
 * @Author Linton
 * @Date 2019/5/20 16:18
 * @Version 1.0
 * @Description 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

public class HasSubtree {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode b2 = new TreeNode(5);
        TreeNode b1 ;
        a1.left = a2; a1.right = a3; a2.left = a4; a2.right = a5;
        b1 = a2;
        Boolean a = HasSubtree(a1,b1);

        System.out.println(a);

    }

    // 采用递归把子树拿出来
    public static  boolean HasSubtree(TreeNode root1,TreeNode root2) {
        Boolean result = false;
        if (root1 != null || root2 != null) {
            // 比较root1和root2
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }
            //
            if (!result ) {
                result = HasSubtree(root1.left, root2);
            }

            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }

        return result;

    }

    public static boolean doesTree1HaveTree2(TreeNode root1,TreeNode root2){
        // roo2为NULL说明root2在root1里面
        if (root2 == null) {
            return true;
        }
        // root1为NULL说明root2还有，不包括在root1里面
        if (root1 == null) {
            return false;
        }
        // 比较root1和root2的节点
        if (root1.val == root2.val) {
            return doesTree1HaveTree2(root1.left, root2.left)&&doesTree1HaveTree2(root1.right, root2.right);
        }
        if (root1.val != root2.val)
             return false;
        return false;

    }
}


//class TreeNode {
//   int val = 0;
//   TreeNode left = null;
//   TreeNode right = null;
//
//   public TreeNode(int val) {
//       this.val = val;
//
//   }

//}

