package swordOffer;

import java.util.*;

/**
 * @Author Linton
 * @Date 2019/6/29 14:21
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 *
 *
 */

// TODO 编程，最可怕的就是不动脑子，粘贴复制代码！！！毁灭，毁灭，毁灭
public class PrintBinaryTree {
    public static void main(String[] args) {
        PrintBinaryTree p = new PrintBinaryTree();

        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(11);
        a.left = b; a.right = c; b.left = d; b.right = e; c.left = f; c.right = g;

        p.Print5(a);
    }

    /**
     * 从上到下，不分行打印二叉树
     */
    public void print1(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();

        list.add(treeNode);
        while (!list.isEmpty()){
            TreeNode node = list.remove();
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            System.out.print(node.val + " ");
        }
    }

    /**
     * 从上到下，分行打印二叉树
     */
    public void print2 (TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();

        // 关键是放置这两个参数！！！
        int tobePrinted = 1;
        int nextLevel = 0;

        list.add(treeNode);
        while (!list.isEmpty()){
            TreeNode node = list.remove();
            System.out.print(node.val + " ");
            tobePrinted--;

            if (node.left != null) {
                list.add(node.left);
                ++nextLevel;
            }
            if (node.right != null) {
                list.add(node.right);
                ++nextLevel;
            }

            if (tobePrinted == 0) {
                System.out.println();
                tobePrinted = nextLevel;
                nextLevel = 0;
            }
        }

    }
    /**
     * 之字形打印 用两个栈
     */
    public ArrayList<ArrayList<Integer> > print4(TreeNode pRoot) {
        if(pRoot == null) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer> >();
        int current = 1;

        stack1.push(pRoot);

        while(!stack1.empty() || !stack2.empty()) {
            // 奇数层：先保存左子节点，再保存右子节点，到是stack1
            if(current % 2 == 1){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while(!stack1.empty()){
                    TreeNode node = stack1.pop();
                    temp.add(node.val);
                    if(node.left != null) stack1.push(node.left);
                    if(node.right != null) stack2.push(node.right);
                }
                list.add(temp);
                current++;
            } else {
                // 偶数层：先保存右子节点，在保存左子节点，到stack2
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while(!stack2.empty()){
                    TreeNode node = stack2.pop();
                    temp.add(node.val);
                    if(node.right != null) stack2.push(node.right);
                    if(node.left != null) stack2.push(node.left);
                }
                list.add(temp);
                current++;
            }

        }
        return list;

    }

    /**
     *
     */
    ArrayList<ArrayList<Integer> > Print5(TreeNode pRoot) {
        if(pRoot == null){
            return new  ArrayList<ArrayList<Integer> >();
        }
        ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer> >();
        LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int tobePrinted = 1;
        int nextLevel = 0;

        list1.add(pRoot);
        while(!list1.isEmpty()) {
            TreeNode node = list1.remove();
            temp.add(node.val);
            tobePrinted--;
            if(node.left != null) {list1.add(node.left);nextLevel++;}
            if(node.right != null) {list1.add(node.right);nextLevel++;}
            if(tobePrinted == 0) {
                tobePrinted = nextLevel;
                ArrayList<Integer> temp1 = new ArrayList<Integer>(temp);
                list.add(temp1);
                nextLevel = 0;
                temp.clear();
            }
        }
        return list;


    }

    /**
     * 之字形打印 用队列失败尝试
     */
    public void print3(TreeNode treeNode){
        if (treeNode == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        // 关键是放置这两个参数！！！
        int tobePrinted = 1;
        int nextLevel = 0;
        int current = 1;
        list.add(treeNode);
        while (!list.isEmpty()){
            TreeNode node = list.remove();
            System.out.print(node.val + " ");
            tobePrinted--;
// TODO 用current表示出当前的二叉树层数，则可以作答
            if (current % 2 == 1) {
                if (node.left != null) {
                    list.add(node.left);
                    ++nextLevel;
                }
                if (node.right != null) {
                    list.add(node.right);
                    ++nextLevel;
                }
            } else {
                if (node.right != null) {
                    list.add(node.right);
                    ++nextLevel;
                }
                if (node.left != null) {
                    list.add(node.left);
                    ++nextLevel;
                }

            }
            if (tobePrinted == 0) {
                System.out.println();
                tobePrinted = nextLevel;
            }
        }

    }


}

