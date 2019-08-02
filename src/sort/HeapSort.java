package sort;

import java.util.Arrays;

/**
 * 堆排序
 * 博客地址：https://www.cnblogs.com/chengxiao/p/6129630.html
 * 基本思路：
 * 1.将无序序列构造成一个堆，根据升序或降序需求选择大顶堆或小顶堆
 * 2.将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端（后续操作排除最后一个元素）
 * 3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
 */

public class HeapSort {
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr)); // 学会了新的表达方式


    }

    public static void sort(int[] arr) {
        // 1.构建大顶堆 ??
        for (int i = arr.length/2 - 1; i >= 0; i--){
            // 从第一个非叶子节点从下至上，从右至左调整
            adjustHeap(arr, i, arr.length);
        }
        // 2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--){
            swap(arr,0,j); // 将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j); // 重新对堆进行调整
        }
    }
    /**
     * 调整大顶堆（建立大顶堆的基础上）
     */
    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];
        for (int k = i*2+1; k < length; k= k*2+1){
            if (k+1 < length && arr[k]<arr[k+1]) {
                k++ ;
            }
            if(arr[k] > temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k ;
            } else {
                break;
            }

        }
        arr[i] = temp;//将temp值放到最终的位置
    }
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
