package enterprise;



/**
 * @Author Linton
 * @Date 2019/8/15 9:57
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.Scanner;
public class EnterPrise {
    public static void main(String[] args) {
        getReward();
    }
    /**
     * 获得最多的奖金
     * 2019-8-15 09:57:46
     */
    public static void getReward(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        int n1 = 0;
        while (n-- > 0){
            arr[n1++] = in.nextLong();
        }
        int left = 0;
        int right = arr.length - 1;
        long left_sum = arr[left];
        long right_sum = arr[right];
        long max = 0;
        /**
         * 双指针思想：
         * 左右指针遍历数组找左边数组的和和右边数组的和比较来移动指针
         * 1.相等则保存当前值，左指针右移，右指针左移动
         * 2.左边和 > 右边和  右指针左移
         * 3.左边和 < 右边和  左指针右移
         */
        while (right > left) {
            if (left_sum == right_sum) {
                max = left_sum;
                left_sum += arr[++left];
                right_sum += arr[--right];
            } else if (left_sum > right_sum) {
                right_sum += arr[--right];
            } else {
                left_sum += arr[++left];
            }
        }
        System.out.println(max);

    }
}

