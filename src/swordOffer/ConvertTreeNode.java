package swordOffer;

import java.lang.reflect.Constructor;
import java.util.*;
/**
 * @Author Linton
 * @Date 2019/7/8 21:42
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class ConvertTreeNode {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(14);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(8);
        TreeNode f = new TreeNode(12);
        TreeNode g = new TreeNode(16);

        a.left = b; a.right = c; b.left = d; b.right = e;
        c.right = g; c.left = f;
        ConvertTreeNode convertTreeNode = new ConvertTreeNode();
        TreeNode  sd = convertTreeNode.Convert(a);
        System.out.println();
    }
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        // 一直递归到最小处
        ConvertSub(pRootOfTree.left);

        if (head == null) {
            //
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            // 难点在这里
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
    /*
    static ArrayList<Integer> list = new ArrayList<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){return null;}
        midQuery(pRootOfTree);
        return transmit(list);

    }

    // 中序遍历产生一个ArrayList
    public ArrayList midQuery(TreeNode node){
        if(node.left != null) {
            midQuery(node.left);
        }
        list.add(node.val);
        if(node.right != null) {
            midQuery(node.right);
        }
        return list;
    }

    // 重建二叉树  的逻辑有点乱啊
    public TreeNode transmit(ArrayList list){
        TreeNode node = new TreeNode(-1);
        TreeNode nodes =node;
        TreeNode node3;


        for(int i = 0; i < list.size(); i++){
            TreeNode node1 = new TreeNode((Integer) list.get(i));
            TreeNode node2 = new TreeNode((Integer) list.get(i+1));
            node1.right = node2;
            node2.left = node1;

            node.right = node1;
            node = node.right;
        }

        //TreeNode phead = node.left;
        return nodes.left;
    }*/

}


