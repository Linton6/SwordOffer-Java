package enterprise;

/**
 * @Author Linton
 * @Date 2019/7/16 16:32
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  0-1 背包问题 Fibonacii
 */

public class Knapsack {
    public static void main(String[] args) {
        Knapsack k = new Knapsack();
//        k.knapsack();;
//        System.out.println(k.B[5][20]);
//        k.fibonacii(9);
        char[] chars = {'1','2','3'};
        k.pertumation(chars,0);

//        System.out.println(k.fibonacii(6));

    }

    int N =6; int W = 21;
    int[][] B = new int[N][W];  // 二维数组，用来保存各个子问题的最优解，B[][]代表最大价值
    int[] w = {0, 2,3 ,4 ,5,9};  // 重量的数组
    int[] v = {0, 3,4 ,5 ,8,10};  // 价值的数组
    void  knapsack(){
        int k ,C;  // k代表第几个物品，C代表剩余承重
        for (k = 1; k < N; k++){
            for (C = 1; C < W; C++){  // 其实对于没有等于号有疑问？
                if (w[k] > C) {
                    B[k][C] = B[k - 1][C];  // 当前物品的重量大于背包承重，直接放弃，不拿
                } else {
                    int value1 = B[k -1][C-w[k]] + v[k];// 拿当前物品
                    int value2 = B[k-1][C];// 不拿当前物品
                    if (value1 > value2){  // 判断 拿和不拿那个的价值大，选做最优解，做下一步
                        B[k][C] = value1;
                    }else {
                        B[k][C] = value2;
                    }
                }
            }
        }
    }


    // 斐波那契数列  递归方式
    int refibonacii(int n){
        if (n == 0){
            return 0;
        }
        if (n == 2 || n == 1){
            return 1;
        }
        return fibonacii(n-1) + fibonacii(n-2);
    }
    // 非递归
    int fibonacii (int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int a = 1;
        int b = 1;
        int result = 0;
        for (int i = 3; i <= n; i++){
            result =  a + b;
            a = b;
            b = result;
        }
        return result;
    }

    // 全排列   个数  如果写算法不考虑优化和优雅，不去考虑时间复杂度和空间复杂度，只是单纯的功能实现，那将没有任何意义和竞争力
    // if {}  else{for}
    void pertumation(char[] chars, int n){
        if (chars == null || chars.length == 0){
            return ;
        }
        if (chars.length-1 == n){
            System.out.println(String.valueOf(chars));
            return ;
        } else {
            for (int i = n; i < chars.length; i++) {
                char temp;
                temp = chars[n];
                chars[n] = chars[i];
                chars[i] = temp;

                pertumation(chars, n + 1);

                temp = chars[n];
                chars[n] = chars[i];
                chars[i] = temp;

            }
        }
        return ;
    }

}

