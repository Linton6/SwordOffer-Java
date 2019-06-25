package swordOffer;

/**
 * @Author Linton
 * @Date 2019/6/10 14:57
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description 24 反转链表
 */

public class ReverseList {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        ListNode a7 = new ListNode(7);
//        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        ListNode b1 = null;
        displayListNode(a1);
        ListNode b = reverseList(a1);
        displayListNode(b);




    }

    public static ListNode reverseList(ListNode pHead){
        if (pHead == null) {
            return null;
        }

        ListNode preNode = null;
        ListNode pNode = pHead;
        ListNode pReversedHead = null;

        while (pNode != null) {
            ListNode nextNode = pNode.next;
            if (pNode.next == null) {
                pReversedHead = pNode;
            }
            pNode.next = preNode;
            preNode = pNode;
            pNode = nextNode;
        }

        return pReversedHead;

    }

    public static void displayListNode(ListNode pHead){
        while (pHead != null) {
            System.out.print(pHead.val + " ");
            pHead = pHead.next;
        }
        System.out.println("");

    }
}

