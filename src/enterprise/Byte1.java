package enterprise;

import leetcode.ListNode;

import java.util.*;

/**
 * @Author Linton
 * @Date 2019/7/8 16:02
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Byte1 {
    int Numbeer;

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        ListNode node = transmit(a, 3);
        System.out.println();

    }

    public static ListNode transmit(ListNode node, int x) {
        if (node == null || x < 0) {
            return null;
        }
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<>();

        while (node != null) {
            if (node.val < x) {
                list1.add(node.val);
            } else {
                list2.add(node.val);
            }
            node = node.next;
        }
        // 创建链表
        ListNode head = new ListNode(-1);
        ListNode node1 = head;
        while (!list1.isEmpty() || !list2.isEmpty()) {
            if (!list1.isEmpty()) {
                ListNode node2 = new ListNode(list1.poll());
                head.next = node2;
                head = head.next;
            } else {
                ListNode node2 = new ListNode(list2.poll());
                head.next = node2;
                head = head.next;
            }
        }
        return node1.next;

    }
}

