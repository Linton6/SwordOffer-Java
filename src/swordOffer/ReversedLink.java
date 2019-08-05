package swordOffer;

/**
 * @Author Linton
 * @Date 2019/8/5 15:55
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 单向链表反转
 */

public class ReversedLink {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode b = new ListNode(3);
        a.next = c; c.next = b;
        ListNode d = reverse(a);
        System.out.println();


    }


    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head; //
        ListNode pre = null; //
        ListNode next = null; //
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;

        }
        return pre;

    }

}

