package newSwordOffer;

/**
 * @Date 2019/9/4 20:36
 * @任务调度
 * 在m个节点的分布式计算系统中，有一批任务需要执行，每个任务需要的时间是array[i]，每个节点同一时间只能执行一个任务，每个节点只能
 * 执行连续的任务，例如i,i+1,i+2,但是不能执行i,i+2。请问任务完成的最短时间
 *
 * （1）二分查找法
 * https://blog.csdn.net/u011947630/article/details/81606259
 *
 * （1）动态规划法
 * https://blog.csdn.net/littlestream9527/article/details/12242155
 */


import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class 画匠问题 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    dp[i][j] = min{max{dp[i-1][k],sum[k+1,...j]}}   代表i个工人搞定arr[0...j]这些工作所需的最少时间，其中K代表前i-1个画匠负责arr[0..k],最后一个画匠负责arr[k..j]内容
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
            map[i] = sumArr[i];// 此时是一个工人搞定arr[0...i]的最短时间 为原二维动态规划中的行最大值    、、一到关键节点，各种牛鬼蛇神都冒出来了
        }
        // 核心
        for (int i = 1; i < num; i++) {  // i代表人数
            for (int j = map.length - 1; j > i - 1; j--) {  // j代表画布的数量
                int min = Integer.MAX_VALUE;
                for (int k = i - 1; k < j; k++) {  // k代表
                    int cur = Math.max(map[k],sumArr[j] - sumArr[k]);  //默认前提是map[k]意思是i-1个人完成前k个画布的时间，最后一个人完场k+1到j画布的时间
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


//#include <iostream>
//#include <cassert>
//
//using namespace std;
//        int sum(int A[], int from, int to) {
//        int total = 0;
//        for (int i = from; i <= to; i++)
//        total += A[i];
//        return total;
//        }
////递归的暴力搜素算法
////指数时间的复杂度
//        int partition(int A[], int n, int k) { // k个画家完成画布数量为n的最小时间
//        if (k == 1)
//        return sum(A, 0, n-1);
//        if (n == 1)
//        return A[0];
//
//        int best = INT_MAX;
//        for (int j = 1; j <= n; j++)   // j画布数量  k 为画家数量   sum(A, j, n-1)最后一个画家完成j到n-1的画布工作量，partition(A, j, k-1)k-1个画家完成画布数量为 j-1的最小时间
//        best = min(best, max(partition(A, j, k-1), sum(A, j, n-1)));
//
//        return best;
//        }
//
////改进的动态规划算法
////时间复杂度：O(kN2)
////空间复杂度：O(kN)
//        const int MAX_N = 100;
//        int findMax(int A[], int n, int k) { //  k个画家完成画布数量为n的最小时间
//        int M[MAX_N+1][MAX_N+1] = {0};   // dp 数组  行代表画布数量，也就是A数组的值，列代表画家数
//        // dp数组第一列代表0个画家画画，应该是无限大的数，这里用0代替；第一行，代表只有0个画布，不需要完成，时间永远为0
//        int cum[MAX_N+1] = {0};
//        for (int i = 1; i <= n; i++)
//        cum[i] = cum[i-1] + A[i-1];   // 前n个画布完成时间的依次和
//
//        for (int i = 1; i <= n; i++)
//        M[i][1] = cum[i]; 				// dp数组第二列就是 前n个画布只由一个画家完成，完成时间的依次和
//        for (int i = 1; i <= k; i++)
//        M[1][i] = A[0];                // dp数组第二行就是 前n个画布完成时间的依次和
//
//        for (int i = 2; i <= k; i++) {  // k个画家
//        for (int j = 2; j <= n; j++) {   // n个画布
//        int best = INT_MAX;
//        for (int p = 1; p <= j; p++) {
//        best = min(best, max(M[p][i-1], cum[j]-cum[p]));  // 这块和递归一样来理解；M[p][i-1]是i-1个画家完成前p个画布需要的时
//        // 间，cum[j]-cum[p]为最后一个画家完成p到j的画布的时间，
//        }
//        M[j][i] = best; // i个画家完成j个画布需要的最小时间
//        }
//        }
//        return M[n][k];
//        }
//
//        //想不到的二分查找算法
////时间复杂度：O(N log ( ∑ Ai )).
////空间复杂度：0(1)
//        int getMax(int A[], int n) {
//        int max = INT_MIN;
//        for (int i = 0; i < n; i++) {
//        if (A[i] > max) max = A[i];
//        }
//        return max;
//        }
//
//        int getSum(int A[], int n) {
//        int total = 0;
//        for (int i = 0; i < n; i++)
//        total += A[i];
//        return total;
//        }
//
//        int getRequiredPainters(int A[], int n, int maxLengthPerPainter) {
//        int total = 0, numPainters = 1;
//        for (int i = 0; i < n; i++) {
//        total += A[i];
//        if (total > maxLengthPerPainter) {
//        total = A[i];
//        numPainters++;
//        }
//        }
//        return numPainters;
//        }
//
//        int BinarySearch(int A[], int n, int k) {
//        int lo = getMax(A, n);
//        int hi = getSum(A, n);
//
//        while (lo < hi) {
//        int mid = lo + (hi-lo)/2;
//        int requiredPainters = getRequiredPainters(A, n, mid);
//        if (requiredPainters <= k)
//        hi = mid;
//        else
//        lo = mid+1;
//        }
//        return lo;
//        }
//        int main()
//        {
//enum{length=9};
//        int k=3;
//        int a[length]={9,4,5,12,3,5,8,11,0};
//        cout<<partition(a,length,k)<<endl;
//        cout<<findMax(a,length,k)<<endl;
//        cout<<BinarySearch(a,length,k)<<endl;
//        return 0;
//        }