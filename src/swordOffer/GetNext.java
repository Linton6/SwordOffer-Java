package swordOffer;

import java.util.*;

/**
 * @Author Linton
 * @Date 2019/6/29 9:59
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 二叉树的下一个节点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的
 * 结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
 // 二叉树的下一个节点
public class GetNext {
    public static void main(String[] args) {
        GetNext getNext = new GetNext();
        TreeLinkNode a = new TreeLinkNode(8);
        TreeLinkNode b = new TreeLinkNode(6);
        TreeLinkNode c = new TreeLinkNode(10);
        TreeLinkNode d = new TreeLinkNode(5);
        TreeLinkNode e = new TreeLinkNode(7);
        TreeLinkNode f = new TreeLinkNode(9);
        TreeLinkNode g = new TreeLinkNode(11);
        a.left = b;a.right = c; b.left = d; b.right = e; c.left = f; c.right = g;
        getNext.getNext(a);




    }

    ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
    public TreeLinkNode getNext(TreeLinkNode pNode)
    {
        if(pNode == null) { return null; }

        // 查找父节点
        TreeLinkNode node = new TreeLinkNode(-1);
        TreeLinkNode pHead = pNode;
        while(pHead != null) {
            if(pHead.next == null) {
                node = pHead;
            }
            pHead = pHead.next;
        }

        // 中序遍历
        midquery(node);

        Iterator<TreeLinkNode> it = list.iterator();
        int num = -1;
        while(it.hasNext()) {
            num++;
            if(it.next() == pNode) {
                num++;
                break;
            }
        }
        if(list.size()>num){
            return list.get(num);
        }
        return null;

    }
    // 中序遍历
    public void midquery( TreeLinkNode node) {
        if (node.left != null) midquery(node.left);
        list.add(node);
        if (node.right != null) midquery(node.right);

    }
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    }

