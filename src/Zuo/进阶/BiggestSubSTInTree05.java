package Zuo.进阶;

/**
 * @Author Linton
 * @Date 2019/8/8 21:39
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 * 题型1
 * 给定一颗二叉树的头结点head，请返回最大搜索二叉字数的大小
 */

public class BiggestSubSTInTree05 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node biggestSubBST(Node head) {
        int[] record = new int[3];
//        return posOrder(head, record);
        return new Node(1);
    }


    public static class ReturnType{
        public int size;
        public Node head;
        public int min;
        public int max;

        public ReturnType(int a, Node b, int c, int d) {
            this.size = a;
        }

    }
}

