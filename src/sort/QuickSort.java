package sort;

import java.util.Arrays;

/**
 * 快速排序
 * 参考博客：https://blog.csdn.net/v123411739/article/details/80071521
 * 时间复杂度最好O(nlogn)，最差O(n^2)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] ar = {23,15,37,89,2,21,43,9,56};
        quick(ar);
        System.out.println(Arrays.toString(ar));
        ArrayList.display(ar);

    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high, index = array[i]; // 取最左边的数为基准数
        while (i < j) {                          // i == j 时，跳出循环
            while (i < j && array[j] >= index)  // 向左寻找第一个小于index的数
                j--;
            if (i < j)
                array[i++] = array[j];      // 将array[j]填入array[i]，并将i向右移动
            while (i < j && array[i] <= index)  // 向右寻找第一个大于index的数
                i++;
            if (i < j)
                array[j--] = array[i];          //将array[i]填入array[j],并将j向右移动
        }
//        array[i] = index; // 将基准数填入最后的坑
        array[j] = index;
        quickSort(array,low,i - 1); // 递归调用，分治
        quickSort(array,i + 1,high); // 递归调用，分治
    }

    public static void quick(int[] array){
        if (array.length == 0){
            return;
        }
        quickSort(array,0, array.length - 1);
    }
}
