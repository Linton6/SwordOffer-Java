package enterprise;

/**
 * @Date 2019/9/4 18:56
 * @链表排序
 * 豚厂给自研的数据库设计了一套查询表达式，在这个表达式中括号表示将里面的字符串翻转。请你帮助实现这一逻辑
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

    public class Xiecheng {

        public static class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
                next = null;
            }
        }

        /*请完成下面这个函数，实现题目要求的功能
         ******************************开始写代码******************************/
        static ListNode partition(ListNode head,int m) {
            if (head == null) {
                return  null;
            }
            ListNode p1 = new ListNode(0);
            ListNode p2 = new ListNode(0);
            ListNode node1 = p1;
            ListNode node2 = p2;
            ListNode tmp;
            while(head != null) {
                if (head.val <= m){
                    tmp = new ListNode(head.val);
                    p1.next = tmp;
                    p1 = p1.next;
                }else {
                    tmp = new ListNode(head.val);
                    p2.next = tmp;
                    p2 = p2.next;
                }
                head = head.next;
            }
            p1.next = node2.next;
            return node1.next;
        }
        /******************************结束写代码******************************/


        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            ListNode head=null;
            ListNode node=null;
            int m=in.nextInt();
            while(in.hasNextInt()){
                int v=in.nextInt();
                if(head==null){
                    node=new ListNode(v);
                    head=node;
                }else{
                    node.next=new ListNode(v);
                    node=node.next;
                }
            }
            head= partition(head,m);
            if(head!=null){
                System.out.print(head.val);
                head=head.next;
                while(head!=null){
                    System.out.print(",");
                    System.out.print(head.val);
                    head=head.next;
                }
            }
            System.out.println();
        }
    }

