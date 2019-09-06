package newSwordOffer;

/**
 * @Date 2019/9/4 20:36
 * @任务调度
 * 在m个节点的分布式计算系统中，有一批任务需要执行，每个任务需要的时间是array[i]，每个节点同一时间只能执行一个任务，每个节点只能
 * 执行连续的任务，例如i,i+1,i+2,但是不能执行i,i+2。请问任务完成的最短时间
 */


import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class 画匠问题 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    dp[i][j] = min{max{dp[i-1][k],sum[k+1,...j]}}   代表i个工人搞定arr[0...j]这些工作所需的最少时间
    因为dp[i][j]的值仅依赖dp[i-1][...]的值，所以我们不必生成规模为Num*N大小的举证，仅有一个长度为N的数组结构滚动更新，不断复用即可。
    ******************************开始写代码******************************/
    static int schedule(int num,int[] arr) {
        if(arr == null || arr.length == 0 || num < 1) {
            throw new RuntimeException("err");
        }
        int[] sumArr = new int[arr.length];
        int[] map = new int[arr.length];

        sumArr[0] = arr[0];
        map[0] = arr[0];
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];// 挨个求数组的和
            map[i] = sumArr[i];// 此时是一个工人搞定arr[0...i]的最短时间
        }
        // 核心
        for (int i = 1; i < num; i++) {  // i代表人数
            for (int j = map.length - 1; j > i - 1; j--) {  // j代表数组个数
                int min = Integer.MAX_VALUE;
                for (int k = i - 1; k < j; k++) {
                    int cur = Math.max(map[k],sumArr[j] - sumArr[k]);
                    min = Math.min(min, cur);
                }
                map[j] = min;
            }
        }
        return map[arr.length - 1];
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}

