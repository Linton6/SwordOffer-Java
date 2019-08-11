package Zuo.基础;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Linton
 * @Date 2019/8/5 23:02
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 *
 * * 2、项目投资最大化
 *  * cost[]本金数组，profit[]利润数组，初始资金 W， 最多投资 K 个项目，一次投资一个项目。 求最后剩余钱数最大的投资策略
 *  * 分析：
 *  * 用数组 存储 项目，一个项目包括本金和利润两个Integer属性
 *  * 用一个小根堆 存放数组，存放标准是本金，把初始资金能投资的项目， 放入根据收益高 组建的大根堆中，大根堆弹出的项目就是性价比最高的项目
 *  * 小根堆里是待解锁的项目；大根堆是解锁的项目
 */

public class Investment08 {
    public static class Node { // Node就是项目
        public int p;  // 收益
        public int c;   // 花费

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

/** @用比较器生成堆 */
    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class  MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length]; // nodes数组是项目数
        for (int i = 0; i < Profits.length; i++) {  // 可以改成lambda表达式,生成所有项目
            nodes[i] = new Node(Profits[i],Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());// 小根堆

        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator()); // 大根堆

//        for (int i = 0; i < nodes.length; i++) {
//            minCostQ.add(nodes[i]);
//        }   下面是它的简化版
        minCostQ.addAll(Arrays.asList(nodes));  // 把所有的项目加入小根堆

        for (int i = 0; i <  k; i++) {  // 开始做项目了，最多做K个
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }

            if (maxProfitQ.isEmpty()) {  // 做不到K个项目就停止的情况
                return W;
            }

            W += maxProfitQ.poll().p;
        }
        return W;
    }
}

