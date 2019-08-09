package 基础.进阶;

import 基础.UnionFind07;

/**
 * @Author Linton
 * @Date 2019/8/7 18:43
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 * @二叉树遍历小结
 * 二叉树的四种遍历方式分别是：先序、中序、后序和层次。
 * 它们的时间复杂度都是O(n)，因为它们只访问每个节点一次，不存在多余的访问。
 * 三种深度优先遍历方法（先序、中序和后序）的时间复杂度是O(h)，其中h是二叉树的深度，额外空间是{ 函数递归的调用栈 }产生的，
 * 而不是显示的额外变量。层次遍历的时间复杂度是O(w)，其中w是二叉树的宽度（拥有最多节点的层的节点数），因为层次遍历通常是用一个queue来实现的。
 *
 * 介绍一种时间复杂度O(N)，额外空间复杂度O(1)的二叉树的遍历方式，N为二叉树的节点个数
 * 莫瑞斯遍历
 * @分析：
 *      来到的当前节点记为cur（引用）
 *  1) 如果Cur无左孩子，Cur向右移动（Cur = Cur.right）
 *  2) 如果Cur有左孩子，找到Cur左子树上最右的节点，记为mostright
 *        i) 如果mostright的right指针指向空，让其指向Cur，Cur向左移动
 *       ii) 如果mostright的right指针指向Cur，让其指向空，Cur向右移动。
 *
 *   PS：节点有左子树可以访问两次，没有左子树可能访问一次
 *
 *
 */

public class MorrisSearch03 {


    private static void process(Node head) {
        if (head == null) {
            return;
        }
//        1
        System.out.println(head.value); // 前序
        process(head.left);
//        2
        System.out.println(head.value);  // 中序
        process(head.right);
//        3
        System.out.println(head.value);  // 后序  会回到自己三次
    }


    /**
     * 莫瑞斯遍历  改成前序和中序就是打印的时机
     */
    class Node{
        int value;
        Node left;
        Node right;
    }

    /**
     * 莫瑞斯遍历改成中序遍历
     */
    public static void morrisIN(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while(mostRight.right != null && mostRight.right != cur) { // 当前左子树最右的节点
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value + " ");  //
            cur = cur.right;
        }
        System.out.println();//
    }
    /**
     * 莫瑞斯遍历改成先序遍历
     */
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                mostRight = cur.left;
                if (mostRight != null) {
                    while (mostRight.right != null && mostRight.right != cur){
                        mostRight = mostRight.right;
                    }
                    if (mostRight.right == null) {
                        mostRight.right = cur;
                        System.out.println(cur.value + " ");  // 与上个方法不同处
                        cur = cur.left;
                        continue;
                    } else {
                        mostRight.right = null;
                    }
                } else {  // 多了个else   一个节点没有左子树，直接打印
                    System.out.println(cur.value + " "); // 与上个方法不同处
                }
                cur = cur.right;
            }
            System.out.println();
        }
    }
    /**
     * 莫瑞斯遍历改成后序遍历
     */
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {  // 一个节点可以回到自己两次，即进入if语句
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {   // 打印时机，第二次访问自己的时候
                    cur2.right = null;
                    printEdge(cur1.left);// 逆序打印左子树的右边界
                }
            }
            cur1 = cur1.right;  // 最后，打印整棵树的右边界
        }
        printEdge(head);
        System.out.println();
    }

    /**
     * 逆序打印左子树的右边界
     * 方法：链表反转，然后再反转回来
     * @param left
     */
    private static void printEdge(Node left) {
    }
}

