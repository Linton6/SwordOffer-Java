package newSwordOffer;

/**
 * @Date 2019/9/6 11:13
 * @
 */

import java.util.*;
public class 二叉树的深度和广度优先遍历 {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value=value;
        }
    }
    TreeNode root;
    public 二叉树的深度和广度优先遍历(int[] array){
        // 根据给的数组构建二叉顺（数据是层次遍历的节点顺序）
        root=makeBinaryTreeByArray(array,1);
    }

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static TreeNode makeBinaryTreeByArray(int[] array,int index){
        if(index<array.length){
            int value=array[index];
            if(value!=0){
                TreeNode t=new TreeNode(value);
                array[index]=0;
                t.left=makeBinaryTreeByArray(array,index*2);
                t.right=makeBinaryTreeByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
//             ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();
        Stack<TreeNode> stack = new Stack();   //也可以用栈实现
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            System.out.print(node.value+"    ");
            if(node.right!=null){ // 先右后左 这样弹出来的时候才能实现层次遍历
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        System.out.print("\n");
    }

    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            System.out.print(node.value+"    ");
            if(node.left!=null){   // 对列的话，就是从左节点到右节点了
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }

    /**
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     */
    public static void main(String[] args) {
        int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        二叉树的深度和广度优先遍历 tree=new 二叉树的深度和广度优先遍历(arr);
        System.out.println("深度优先遍历：");
        tree.depthOrderTraversal();
        System.out.println("广度优先遍历：");
        tree.levelOrderTraversal();
    }
}


