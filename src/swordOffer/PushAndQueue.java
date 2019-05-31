package swordOffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */


public class PushAndQueue {
    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        push(4);
        System.out.println(pop());
        push(5);
        System.out.println(pop());
        System.out.println(pop());

    }

   static Stack<Integer> stack1 = new Stack<Integer>();
   static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);

    }

    public static int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int a = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return a;

    }


    /**
     * 失败版本，但是原因还没找出来
     */
/**

    // stack1作为正常栈
    Stack<Integer> stack1 = new Stack<Integer>();
    // stack2作为 stack1倒过来的栈
    Stack<Integer> stack2 = new Stack<Integer>();

    public  void push(int node) {
        stack1.push(node);
        Stack<Integer> stack3 = new Stack<>();
        stack3 = stack1;
        stack2.clear();
        while (!stack3.isEmpty()) {
            stack2.push(stack3.pop());
        }

    }

    public  int pop() {
        if (stack2.isEmpty()){
            System.out.println("队列为空！");
        }
        int a = stack2.pop();
        Stack<Integer> stack4 = new Stack<>();
        stack4 =stack2;
        stack1.clear();
        while (!stack4.isEmpty()) {
            stack1.push(stack4.pop());
        }
        return a;
    }
 **/
}
