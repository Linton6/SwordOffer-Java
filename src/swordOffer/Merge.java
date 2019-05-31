package swordOffer;

import java.util.ArrayList;

/**
 * @Author Linton
 * @Date 2019/5/18 21:19
 * @Version 1.0
 * 描述：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 用递归，精妙世无双
 */

/*
 * 别人家的代码
 public ListNode Merge(ListNode list1, ListNode list2) {
          if(list1==null)
              return list2;
          if(list2==null)
              return list1;
          ListNode res = null;
          if(list1.val<list2.val){
              res = list1;
              res.next = Merge(list1.next, list2);
          }else{
              res = list2;
              res.next = Merge(list1, list2.next);
          }
          return res;
      }
 */

public class Merge  {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list11 = new ListNode(4);
        ListNode list12 = new ListNode(5);
        list1.next = list11;
        list11.next = list12;

        ListNode list2 = new ListNode(2);
        ListNode list21 = new ListNode(3);
        ListNode list22 = new ListNode(9);
        list2.next = list21;
        list21.next = list22;

       ListNode listNode =  Merge(list1,null);
        System.out.println(listNode);

    }
    // 放在list1
//    public static ListNode merge(ListNode list1, ListNode list2) {
//        if (list1 == null && list2 == null) {
//            return list1;
//        } else if (list1 != null && list2 == null) {
//            return list1;
//        } else if (list1 == null && list2 != null) {
//            return list2;
//        }
//
//        while (list1!= null || list2 != null) {
//            ListNode list3 = list1;
//            ListNode list4 = list2;
//
//            if (list1.val < list2.val) {
//                list1.next = list2;
//                list2 = list2.next;
//                list1.next.next = list3.next;
//            }
//        }
//        return new ListNode(1);
//    }

    // 新建一个链表
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ArrayList a = new ArrayList();

        if (list1 == null && list2 == null) {
            list1 = null;
        }

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                while (list2 != null) {
                    a.add(list2.val);
                    list2 = list2.next;
                }
            }
            if (list2 == null) {
                while (list1 != null) {
                    a.add(list1.val);
                    list1 = list1.next;
                }
            }
            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    a.add(list2.val);
                    list2 = list2.next;
                } else {
                    a.add(list1.val);
                    list1 = list1.next;
                }
            }
        }

        return translation2(a);

    }

    // 数值转化为链表
    public static ListNode translation(int[] n) {
        if (n.length == 0) {
            return null;
        }
        ListNode[] listNodes = new ListNode[n.length];
        for (int i = 0; i < n.length; i++) {
            listNodes[i] = new ListNode(n[i]);
        }
        for (int i = 0; i < n.length - 1; i++) {
            listNodes[1+1] = listNodes[i].next;
        }
        return listNodes[0];
    }
    // list转为链表
    public static ListNode translation2(ArrayList a ) {
        if (a.size() == 0) {
            return null;
        }
        ListNode[] listNodes = new ListNode[a.size()];
        for (int i = 0; i < a.size(); i++) {
            listNodes[i] = new ListNode((int)a.get(i));
        }
        for (int i = 0; i < a.size() - 1; i++) {
            listNodes[i].next = listNodes[i+1];
        }
        return listNodes[0];
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
