package swordOffer;

import java.util.*;

/**
 * @Author Linton
 * @Date 2019/6/24 11:08
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode a = new ListNode(10);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(11);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;

        e.next = c;
        d.next = a;

        ListNode result = FindFirstCommonNode(a,e);
        System.out.println(result.val);


    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null && pHead2 == null){
            return null;
        }
        List<ListNode> list1 = new ArrayList<ListNode>();
        List<ListNode> list2 = new ArrayList<ListNode>();
        // 如果其中一个是环形链表，就会炸掉
        while(pHead1 != null){
            list1.add(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null){
            list2.add(pHead2);
            pHead2 = pHead2.next;
        }

        for(ListNode node : list1){
            if(list2.contains(node)){
                return node;
            }
        }

        return null;

    }
}

