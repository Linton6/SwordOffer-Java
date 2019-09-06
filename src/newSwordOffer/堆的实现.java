package newSwordOffer;

import java.util.HashMap;

/**
 * @Date 2019/9/2 15:31
 * @什么是堆
 * 最小堆是一种数据结构，有着如下特点：
 *
 * 顺序：堆顶元素永远是最小的。
 * 形状：堆是一颗完全二叉树。
 * 这两个特性保证了堆在插入和删除的过程中最大时间复杂度也是满足O(logn)的，所以是一种非常高效的数据结构格式。
 *
 * 更新堆的方式
 * 更新堆的两种方式，分别对应了插入元素和删除堆顶元素操作：
 *
 * 自底向上
 * 自顶向下
 * 堆的实现
 * 可以使用数组作为隐式树（因为结构是完全二叉树），不使用索引为0的元素，从1开始。
 *
 * 如果当前元素的下标为i，那么：
 *
 * 当前元素的父亲下标：i / 2
 * 当前元素的左子节点下标：i * 2
 * 当前元素的右子节点下标：i * 2 + 1
 * ————————————————
 * 版权声明：本文为CSDN博主「zhangzhetaojj」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/zhangzhetaojj/article/details/81014408
 */

// 2019-9-4 09:53:08
import java.util.*;
public class 堆的实现{

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];
        Heap heap = new Heap(10);
        System.out.print("原数组: ");
        for (int i = 0; i < 10; i ++) {
            int p = random.nextInt(10);
            System.out.print(p + " ");
            heap.siftUp(p);
        }

        System.out.println(" ");
        System.out.print("最小堆: ");

        for (int i = 1; i <= 10; i ++) {
            System.out.print(heap.nums[i] + " ");
        }

        System.out.println(" ");
        System.out.print("堆排序: ");

        for (int i = 0; i < 10; i ++) {
            System.out.print(heap.siftDown() + " ");
        }
    }
    /*
    两个要点：
    1. 顺序
    2. 形状

    数组形式的隐式树
 */

    public static class Heap {

        public int[] nums;
        private int pointer;

        public Heap(int capacity) {
            nums = new int[capacity + 1];
            pointer = 1;
        }

        /**
         * 生成最小堆 - 从下到上，元素的插入
         * @param newVal
         */
        public void siftUp(int newVal) {
            if (pointer < 0 || nums == null || pointer >= nums.length) return;

            nums[pointer] = newVal;
            int i = pointer, p;
            pointer ++;

            while (true) {
                if (i == 1) break;// 说明是根节点，直接break；
                p = i / 2;
                if (nums[p] <= nums[i]) break;// 父节点大于子节点，不需要改动，直接break；
                swap(p, i);
                i = p;
            }
        }

        /*
            1. 左子节点如果不存在，break
            2. 如果存在右子节点，判断两个子节点的大小，取小的一个
            3. 比较nums[i]和最小字节点的大小，小则break，大则替换
         */

        /**
         * 删除堆顶元素，堆排序，从上到下
         * @return
         */
        public int siftDown() {
            if (pointer < 0 || nums == null || pointer > nums.length) return -1;
            int res = nums[1];
            nums[1] = nums[pointer - 1];
            int i = 1, child;
            pointer --;
            while (true) {
                child = 2 * i;
                if  (child >= pointer) break;
                if (child + 1 < pointer) {
                    if (nums[child] > nums[child + 1]) child ++;
                }
                if (nums[i] <= nums[child]) break;
                swap(i, child);
                i = child;
            }
            return res;
        }

        private void swap(int i, int p) {
            if (i < 0 || p < 0 || nums == null || i >= nums.length || p >= nums.length) return;
            int tmp = nums[i];
            nums[i] = nums[p];
            nums[p] = tmp;
        }

    }
}

