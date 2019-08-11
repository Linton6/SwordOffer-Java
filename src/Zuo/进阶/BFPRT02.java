package Zuo.进阶;

import static sort.HeapSort.swap;

/**
 * @Author Linton
 * @Date 2019/8/6 21:55
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 * BFPRT算法详解与应用 ：
 * 在无序数组中找到第K 小或大的数  时间复杂度O(N)，而不是排序中的O(NlogN)
 * 1) 整个数组5个一组，分成N/5组  O(1)
 * 2) 对每一个小组排序（组内排序）  O(N)
 * 3) 对每个小组的中位数拿出来，成一个新数组  O(N)
 * 4) 递归调用BFPRT数组,得num = bfprt(new_arr, new_arr.length/2) ，num只是一个划分值，用来partition  T(N/5)C
 * 5) 将num拿出来与K比较，符合返回，不符合继续递归
 *
 * @解法一 用堆 O(NlogN)
 * @解法二 BFPRT算法  O(N)
 */

public class BFPRT02 {

    /** @堆 O(N*logK) */
    public static int[] getMinKNumsByHeap(int[] arr, int k) {
        if(k < 1 || k > arr.length) {
            return arr;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i != k; i++) {
            heapInsert(kHeap, arr[i], i);
        }
        for (int i = k; i != arr.length; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 - 1;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]){
                largest = left;
            }
            if(right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index){
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    private static void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    // O(N)

    // BFPRT 主体/核心
    public static int bfprt(int[] arr, int begin, int end, int i){
        if (begin == end) {
            return arr[begin];
        }
        int pivot = medianOfMedians(arr, begin, end); // 求中位数
        int[] pivotRange = partition(arr, begin, end, pivot); // 拿到划分值
        if (i > pivotRange[0] && i <= pivotRange[1]) {   // 以下判断是否命中，走左走右还是直接返回
            return arr[i];
        } else if (i < pivotRange[0]) {
            return bfprt(arr, begin, pivotRange[0] - 1, i);
        } else {
            return bfprt(arr, pivotRange[i] + 1, end, i);
        }

    }

    // 求中位数 视频节点02 01:13
    private static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);

    }

    // 获取中位数
    private static int getMedian(int[] arr, int begin, int end) {
        return arr[0];
    }

    private static int[] partition(int[] arr, int begin, int end, int pivotValue) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur != big) {
            if (arr[cur] < pivotValue) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivotValue) {
                swap(arr, cur, --begin);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

}

