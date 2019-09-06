package newSwordOffer;

/**
 * @Date 2019/9/4 14:03
 * @
 */

public class 链表是否有环 {


    private static boolean hasCircle(Node node) {
        Node fast = node;
        Node slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

   static class Node {
        int val;
        Node next;
        public  Node(int val){
            this.val  =val;
            this.next = null;
        }
    }
}

