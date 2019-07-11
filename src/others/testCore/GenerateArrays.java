package others.testCore;

import java.util.*;
/**
 * @Author Linton
 * @Date 2019/7/9 21:43
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class GenerateArrays {

    public static void main(String[] args) {
        GenerateArrays g = new GenerateArrays();
        int[] arr = g.randomArray(50,50);
        int[] arr2 = g.randomArray(1,1);

        WaysSort waysSort = new WaysSort();
        long start1 = System.currentTimeMillis();
        waysSort.InsertSort(arr,1); //插入排序
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        long start2 = System.currentTimeMillis();
        waysSort.shellSort(arr2);    // 希尔排序
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

    public int[] randomArray(int n, int bound) {
        Random random = new Random();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(bound);
        }

        return array;
    }

}

