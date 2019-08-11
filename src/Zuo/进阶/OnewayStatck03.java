package Zuo.进阶;

import java.util.Stack;

/**
 * @Author Linton
 * @Date 2019/8/7 15:45
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  二维数组，1,0，求1围成的最大矩阵
 * 求最大面积的直方图
 */

public class OnewayStatck03 {

    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length;i++ ) {
            for (int j = 0; j < map.length;j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    // [4,3,2,5,6]
    public static int maxRecFromBottom(int[] height) {  //
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) { // 栈中还剩余元素，继续结算
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    /**
     * 题型二
     * 环形山[1,2,4,5,3],相邻可见，不相邻的元素，加入中间的元素数值小于指定两元素的最小值，则指定的两元素可见。否则，不可见
     *  数组个数   能相互看见的对
     *  0           0
     *  1           0
     *  2           1
     *  n           2*n - 3 (前提是数组中不出现相同的元素)
     *  所以使用单调栈（从大到小）用最大值作为底
     */
}

