package leetcode;

/**
 * @Author Linton
 * @Date 2019/7/4 11:20
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Two {
    public static void main(String[] args) {
        Two two = new Two();
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(9);
        ListNode d = new ListNode(9);
        ListNode e = new ListNode(9);
        ListNode f = new ListNode(9);
        ListNode b1 = new ListNode(9);
        ListNode c1 = new ListNode(9);
        ListNode d1 = new ListNode(9);
        ListNode e1 = new ListNode(9);
        ListNode f1 = new ListNode(9);

       b.next = c;c.next = d;d.next=e;e.next=f;f.next=b1;b1.next=c1;c1.next=d1;d1.next=e1;e1.next=f1;
        two.addTwoNumbers(a,b);


    }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return null;
            }

            long n1 = convert(l1);
            long n2 = convert(l2);

            long sum = n1 + n2;

            ListNode node = tansmit(sum);

            return node;


        }

        // 根据链表得出数的大小
        public long convert(ListNode node) {
            long sum = 0l;
            long i = 1l;
            while (node != null) {
                long a = node.val;
                sum = sum + a * i;
                i = i*10;
                node = node.next;
            }

            return sum;
        }

        // 根据值，把数字转化成链表
        public ListNode tansmit(long num) {
            String s = String.valueOf(num);
            int size = s.length();
            int n = 10;
            // 构建链表
            ListNode head = new ListNode(-1);
            ListNode node = head;


            while (num != 0) {
                long num1 = num % n;
                ListNode node1 = new ListNode((int)num1);// 链表赋值
                head.next = node1;
                head = head.next;
                num = num / n;
            }

            return node.next;
        }
    }

