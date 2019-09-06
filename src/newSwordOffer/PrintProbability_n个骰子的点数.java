package newSwordOffer;

/**
 * @Date 2019/8/22 9:44
 * @n个骰子的点数 求概率
 * https://www.cnblogs.com/xuanxufeng/p/6896569.html
 */

public class PrintProbability_n个骰子的点数 {
    public static void main(String[] args) {
        PrintProbalility(3);
    }

    /**
     * 基于递归，时间效率不高
     * 2019-8-22 09:57:38
     */
    private static final int g_maxValue = 6;
    private static void PrintProbalility(int number) {
        if(number < 1) return;
        int maxSum = number * g_maxValue;
        int[] pProbabilities = new int[maxSum - number + 1]; // 加上一干嘛
        double total = Math.pow(g_maxValue,number);
        // 用Probability函数求解pProbabilities数组大小
        //probability(number,pProbabilities);这个函数计算n~6n每种情况出现的次数
        prabability(number, pProbabilities);
        for(int i=number;i<=maxSum;i++){
            double ratio = pProbabilities[i-number] / total;
            System.out.println("i: "+i+" ratio: "+ratio);
        }

    }

    private static void prabability(int number, int[] pProbabilities){
        for (int i = 1; i <= number; i++) {
            prabability(number, number, i, pProbabilities);
        }
    }
    //总共original个骰子，当前第 current个骰子，当前的和，贯穿始终的数组
    public static void prabability(int original,int current,int sum,int[] pProbabilities) {
        if (current == 1) {
            pProbabilities[sum - original]++;
        } else {
            for (int i = 1; i <= g_maxValue; i++) {
                prabability(original, current - 1, sum + i, pProbabilities);
            }
        }
    }

    /**
     * 基于循环，时间性能好
     */
    //基于循环求骰子点数
    public static void PrintProbability_1(int number){
        if(number<1){
            return;
        }
        int[][] pProbabilities = new int[2][g_maxValue*number +1];
        for(int i=0;i<g_maxValue;i++){//初始化数组
            pProbabilities[0][i] = 0;
            pProbabilities[1][i] = 0;
        }
        int flag = 0;
        for(int i=1;i<=g_maxValue;i++){//当第一次抛掷骰子时，有6种可能，每种可能出现一次
            pProbabilities[flag][i] = 1;
        }
        //从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
        //在下一循环中，我们加上一个新骰子，此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-5，
        //n-6的次数总和，所以我们把另一个数组的第n个数字设为前一个数组对应的n-1,n-2,n-3,n-4,n-5，n-6之和
        for(int k =2;k<=number;k++){
            for(int i=0;i<k;i++){//第k次掷骰子，和最小为k，小于k的情况是不可能发生的！所以另不可能发生的次数设置为0！
                pProbabilities[1-flag][i] = 0;
            }
            for(int i=k;i<=g_maxValue*k;i++){//第k次掷骰子，和最小为k，最大为g_maxValue*k
                pProbabilities[1-flag][i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
                for(int j=1;j<=i&&j<=g_maxValue;j++){
                    pProbabilities[1-flag][i] += pProbabilities[flag][i-j];
                }
            }
            flag = 1-flag;
        }
        double total = Math.pow(g_maxValue, number);
        for(int i=number;i<=g_maxValue*number;i++){
            double ratio = pProbabilities[flag][i]/total;
            System.out.println("sum: "+i+" ratio: "+ratio);
        }
    }
}

