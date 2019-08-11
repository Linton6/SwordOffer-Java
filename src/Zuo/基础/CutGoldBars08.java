package Zuo.基础;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Linton
 * @Date 2019/8/5 22:38
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 * 1、切割金条
 * 标准的哈夫曼编码，用小根堆（用定义比较器），贪心经常用堆解决问题
 * 记住原型，就是套路
 *
 * 2、项目投资最大化
 * cost[]本金数组，profit[]利润数组，初始资金 W， 最多投资 K 个项目，一次投资一个项目。 求最后剩余钱数最大的投资策略
 * 分析：
 * 用数组 存储 项目，一个项目包括本金和利润两个Integer属性
 * 用一个小根堆 存放数组，存放标准是本金，把初始资金能投资的项目， 放入根据收益高 组建的大根堆中，大根堆弹出的项目就是性价比最高的项目
 * 小根堆里是待解锁的项目；大根堆是解锁的项目
 * {@link Investment08}
 */

public class CutGoldBars08 {
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(new MinheapComparator());  // 优先级队列，系统给实现的堆, 生成最小堆
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);  // 所有的数进堆
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static class MinheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;   // < 0  o1 < o2 负数
        }
    }
}

