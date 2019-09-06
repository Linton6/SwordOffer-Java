package newSwordOffer;

import leetcode.ListNode;

/**
 * @Date 2019/8/22 11:05
 * @
 */

public class 从尾到头打印链表_6 {
    /**
     * 面试题6：从尾到头打印链表_6
     * 2019-8-22 11:06:16
     */
    private static ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node ;
        }
        ListNode head = node;
        ListNode tmp1 ;
        ListNode tmp3 = null;
        while (node != null) {
            tmp1 = node.next;
            head = node;
            node.next = tmp3;
            tmp3 = node;
            node = tmp1;

        }
        return head;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b; b.next = c; c.next = d; d.next = e;

        ListNode cc = reverse(a);
        System.out.println();

    }
}

