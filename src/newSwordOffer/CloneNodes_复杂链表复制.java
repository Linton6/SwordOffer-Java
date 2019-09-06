package newSwordOffer;

/**
 * @Author Linton
 * @Date 2019/8/19 14:44
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */



 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class CloneNodes_复杂链表复制  {

    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);

        a.next = b; b.next = c; b.random = e;c.next = d;d.next = e;d.random = b;

        RandomListNode clone = Clone(a);
        System.out.println();

    }

    private static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) {return null;}

        //复制链表-
        RandomListNode node = pHead;
        while(node != null) {
            RandomListNode cloneNode = new RandomListNode(node.label);
            RandomListNode nodeNext = node.next;
            node.next = cloneNode ;
            cloneNode.next = nodeNext;
            node = nodeNext;

        }

        node = pHead;

        //复制随机节点
        while(node != null) {
            node.next.random = node.random==null?null:node.random.next;
            if(node.next !=null)
            {node = node.next.next;} else{node = null;}
        }

        //拆分
        node = pHead;
        RandomListNode clone = pHead.next;
        RandomListNode tmp;
        while(node.next != null) {
            tmp = node.next;
            node.next = tmp.next;  // node.next 变成了node.next.next
            node = tmp;
        }

        return clone;
    }
}


