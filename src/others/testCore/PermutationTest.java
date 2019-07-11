package others.testCore;

/**
 * @Author Linton
 * @Date 2019/7/10 15:41
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 解题思路：找[1,2,3,4]的全排列；然后从1开始，找[2,3,4]的全排列；以此类推，显然最后变成了一个递归问题
 * 如果要去重的全排列，则在此方法的基础上，用Set存放
 */

public class PermutationTest {

    public static void main(String[] args) {
        char[] chars = {'1','2', '3', '4'};
        PermutationTest p = new PermutationTest();
        p.permutation(chars, 0);
    }

    void permutation(char[] chars , int n ){  // n = 0 全排列
        // 判断非法输入
        if (chars == null || chars.length == 0 || n < 0){
            return;
        }
        //
        if (n == chars.length - 1){
            System.out.println(chars);
        } else {
            for (int i = n; i < chars.length; i++){
                swap(chars, i , n);
                permutation(chars, n+1);
                swap(chars, i, n);
            }
        }
    }

    void swap(char[] arr, int x, int y){
        char tmp  = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}

