package newSwordOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Date 2019/9/9 9:03
 * @
 */

public class 滑动窗口数组中连续k个数的最大或小值 {
    public static void main(String[] args) {
        int arr[] = {4,2,5,1,9,10,8};
        int k = 3;
        int[] res = windowsDeque(arr, k);
//        PriorityQueue
        System.out.println(Arrays.toString(res));

    }

    /**
     * 双端队列法-有水平，用堆也可以试试
     * 队列里面存的是数组下标
     * 思路：
     * 放值：把下标存入数组，
     * 求最大：然后求最大值的小标，
     * 弹出：小于最大值的小标直接弹出
     * 判断当前最大值是否还在窗口内
     * 模仿不可耻，这是学习的必经之路
     *
     *
     */
    private static int[] windowsDeque (int arr[], int k) {
        if(arr.length == 0 && k == 0) {
            return new int[0];
        }
        int len = arr.length;
        int[] res = new int[len - k + 1];

        LinkedList<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < len; i++) {

            /**
             * 如果是求滑动窗口最小值，则改为  arr[deque.peekLast()] >= arr[i])
             */
            while (!deque.isEmpty() && (arr[deque.peekLast()] <= arr[i])) { // 保证加入的下标，前面的数都是有价值的。除了比当前i 大的数，其余都不进入队列
                deque.removeLast();// 清空队列
            }

            deque.addLast(i); // 加入队列

            if (i - deque.peekFirst() == k) {  // 若此时窗口的长度超出K的范围，移除最前面的元素，保持窗口大小不变
                deque.removeFirst();
            }

            if (i >= k - 1) { // 当队列长度等于窗口长度时，开始输出最大值
                res[index++] = arr[deque.peekFirst()];
            }

        }
        return res;

    }

}

