package swordOffer;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述：
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {

    public static void main(String[] args) {
           new PrintListFromTailToHead().a();
    }

    public void a() {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        ArrayList<Integer> a = printListFromTailToHead(listNode);
        System.out.println(a.toString());
    }

    /**
     * 用递归实现从后往前
     */
    static ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            // 关键 是这this
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }


    /**
     * 用栈来实现从后往前
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        // 用while循环
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;

    }

    /**
     * 垃圾版本
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode == null)
            { return new ArrayList<Integer>();}

        ArrayList<Integer> list = new ArrayList<Integer>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        int a = list.size();
        for (int i = 0; i < list.size(); i++) {
            list1.add(i,list.get(--a));
        }
        return list1;
    }

}

class ListNode {
   int val;
   ListNode next = null;

   ListNode(int val) {
       this.val = val;
   }
}
