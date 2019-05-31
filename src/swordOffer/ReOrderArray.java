package swordOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Linton
 * @Date 2019/5/16 13:20
 * @Version 1.0
 * 描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数
 * 位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * *推荐思路2
 * 运行时间：16ms
 * 占用内存：9368k
 */

public class ReOrderArray {
    public static void main(String[] args) {
        int[] array = {2,2,2,2,1};
        // 为什么这边的array没有返回，也已经改变了值呢？
        reOrderArray2(array);
        System.out.println(Arrays.toString(array));

    }

    public static void reOrderArray(int [] array) {
        if (array.length == 0 || array.length == 1) {
            return ;
        }
        ArrayList<Integer> arry1 = new ArrayList<>();
        ArrayList<Integer> arry2 = new ArrayList<>();
        for (int i = 0; i < array.length;i++) {
            // 可以用&操作提高效率
            if (array[i]%2 == 1) {
                arry1.add(array[i]);
            } else {
                arry2.add(array[i]);
            }
        }
        for (int i = 0; i < arry1.size(); i++) {
            array[i] = arry1.get(i);
        }
        for (int i = 0; i < arry2.size(); i++) {
            array[arry1.size() + i] = arry2.get(i);
        }
//        System.out.println(Arrays.toString(array));

    }

    /**
     * 思路2 ：类似冒泡排序，前偶后奇就交换（推荐）
     */
    public static void reOrderArray2(int [] array) {

        for(int i= 0;i<array.length-1;i++){
            // j每次都从0开始，这一点我没考虑到，还是这个的代码简洁
            for(int j=0;j<array.length-1-i;j++){
                // 前偶后奇，则交换
                if(array[j]%2==0&&array[j+1]%2==1){
                    int t = array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
    }
}

