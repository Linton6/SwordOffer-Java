package swordOffer;

/**
 * @Author Linton
 * @Date 2019/7/8 20:20
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class ReconstructLinkedList {
    public static void main(String[] args) {
        int[] a = {1,2,34,7,5};
        ListNode c = reconstructLinkedList(a);
        System.out.println();

    }

    public static ListNode reconstructLinkedList(int[] array) {
        int size = array.length;
        ListNode node = new ListNode(-1);
        ListNode phead = node;
        for (int i = 0; i < size; i++) {
            ListNode node1 = new ListNode(array[i]);
            phead.next = node1;
            phead = phead.next;
        }
        return node.next;

    }
}

