package swordOffer;

import java.util.*;
/**
 * @Author Linton
 * @Date 2019/6/29 8:21
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 删除重复链表
 */

public class DeleteDuplicationList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);
        a.next = b;  b.next = c;  c.next = d;  d.next = e; e.next = f;  f.next = g;

        DeleteDuplicationList del = new DeleteDuplicationList();
       ListNode res =  del.deleteDuplication(a);
        System.out.println();

    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null) {
            return null;
        }

        Set set1 = new TreeSet<Integer>();
        Set set2 = new TreeSet<Integer>();
        while(pHead != null) {
            if(!set1.add(pHead.val))
                set2.add(pHead.val);
            pHead = pHead.next;
        }

        // 这一段lambda表达式用的挺好！！  在set1中删除掉set2中的num值
        set2.forEach(num -> {
            set1.remove(num);
        });

        Iterator<Integer> it = set1.iterator();

        // 新建链表结构  巧妙
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while(it.hasNext()) {
            ListNode node1 = new ListNode(it.next());
            head.next = node1;
            head = head.next;
        }
        return node.next;
    }
}

