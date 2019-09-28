package enterprise;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Date 2019/9/21 16:03
 * @
 */

public class 网易4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr));

    }

    private static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int len  = arr.length;
        int num = 0;
        int tem = 0;
        for (int i = 0; i < len - 1; i++) {
            tem = arr[i];
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < tem ) {
                    num += j - i;
                }
            }
        }
        return num;

//        Stack<Integer> stack = new Stack<>();
//        LinkedList<Integer> help = new LinkedList<>();
//        stack.push(arr[0]);
//        int sum = 0;
//
//        int len = arr.length;
//        for (int i = 1; i < len; i++ ) {
//            if (stack.peek() <= arr[i]) {
//                stack.push(arr[i]);
//            } else {
//                while (stack.peek() > arr[i]) {
//                    help.addLast(stack.pop());
//                    if (stack.isEmpty()) {
//                        break;
//                    }
//                }
//                stack.add(arr[i]);
//                int temp = 0;
//                int k = 0;
//                while (!help.isEmpty()) {
//                    stack.push(help.removeFirst());
//                    temp = temp + (++k);
//                }
//                sum += temp;
//            }
//        }
//        return  sum;

    }
}

