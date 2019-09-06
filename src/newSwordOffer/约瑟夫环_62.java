package newSwordOffer;

import leetcode.ListNode;

/**
 * @Date 2019/8/24 10:32
 * @
 */

public class 约瑟夫环_62 {
    public static void main(String[] args) {
        int N = 1000;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
//        int arr[] = {0, 1, 2, 3,4};
//        System.out.println(Josephuse(arr, 3,0));
        int index = lastRemain(arr, N, 13);
        System.out.println(arr[index]);

    }

    /**
     * 约瑟夫环:经典解法：用环形链表模拟圆圈
     * 2019-8-24 10:36:40
     */
    private static int Josephuse(int[] arr, int n, int k){
        int size = arr.length;
        ListNode head = new ListNode(1);
        ListNode pHead = head;
        for (int i = 0; i < size; i++){
            ListNode node = new ListNode(arr[i]);
            head.next = node;
            head = head.next;
        }
        head.next = pHead.next;
        head = pHead.next;
        if (head == null || head.next == null)
            return 0;
        ListNode pre = new ListNode(1);
        ListNode tmp = new ListNode(1);

        for (int i = 0; i < k; i++) {
            head = head.next;
        }

        while (head.next != null) {
            for (int i = 1; i < n; i++) {
                pre = head;
                head = head.next;
            }
            if (pre == head){
                break;
            }
             tmp = head.next;
             head.next = null;
             pre.next = tmp;
             head = tmp;
        }
        return head.val;
    }

    /**
     * 公式法：f(m,n) = 0 或 [f(n-1, m) + m] % n
     */
    private static int lastRemain(int[] arr,int n, int m) {
        if (n < 1 || m < 1) {
            return  -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}