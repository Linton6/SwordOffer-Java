package others.testCore;

import java.util.Arrays;

/**
 * @Author Linton
 * @Date 2019/7/9 15:05
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class WaysSort {

    public static void main(String[] args) {
        int[] ar = {23,15,37,89,2,21,43,9,56,0,1,22,45,1,90,456};
        WaysSort waysSort = new WaysSort();
        System.out.println("未排序数组： "+Arrays.toString(ar));
//        waysSort.quickSort(ar, 0, ar.length-1); // 快速排序
//        waysSort.BubbleSort(ar); // 冒泡排序
//        waysSort.choiceSort(ar); // 选择排序
//        waysSort.InsertSort(ar,1); //插入排序
//        waysSort.shellSort(ar);    // 希尔排序
//        waysSort.mergeSort(ar);
        waysSort.heapSort(ar);
        System.out.println("排序后数组： "+Arrays.toString(ar));
//        ArrayList.display(ar);

    }

    // 快速排序：取数组中一个关键字作为划分枢纽，划分成左右两个子数组，较小值在左侧，较大值在右侧；在左右子数组中重复上述操作，即递归的调用自身为每一个
    // 子数组进行快速排序，直到子数组只包含一个数据项，此时数组已有序
    //算法实现思路： n个数的数组，选定最左边的值为枢纽值，左右两边设置移动指针i,j；先从右端开始，把找到小于枢纽值的数，再去左边找到大于枢纽值的数，通过移动指针
    // i,j交换这两个数的位置，依次进行，知道i=j,即划分算法（荷兰国旗问题）。分开的两个子数组分别递归使用quickSort
    void quickSort(int[] arr, int left, int right){
        if (left >= right)
            return;
        int i = left; int j = right; int pivot = arr[i]; // 取最左边的值为枢纽值
        while (i < j){                      // i == j 时，跳出循环
            // 从右端开始，发现小于枢纽值，替换到左边的指针处
            while (i < j && arr[j] >= pivot){ // 向左寻找第一个小于index的数
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];  // 将array[j]填入array[i]，并将i向右移动！！！
            }
            // 从左端开始，发现大于枢纽值，替换到右边的指针处
            while (i < j && arr[i] <= pivot) { // 向右寻找第一个大于index的数
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];   //将array[i]填入array[j],并将j向右移动！！！
            }
        }
        // partition完毕，分开的两个子数组分别递归使用quickSort
        arr[i] = pivot;  // 将枢纽值放入最终位置
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    // 冒泡排序(每次循环，每相邻的两个数都需要比较)：n个数的数组比较大小，循环n次，每一次循
    // 环，通过比较相邻的两个数，较大者放在后面，依次进行，最大值会移动到数组末尾。循环n次，则得到排好序的数组
    void BubbleSort(int[] arr){  // for(for(if))
        for(int i = 0; i < arr.length  ; i++){
            for (int j = 0; j < arr.length - i - 1 ; j++){
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    // 选择排序:n个数的数组，循环n次，在每一次循环中，比较出最小的数值，把最小的数值和数组第一个数交换位置。在接下来的循环中，排除已经排好序的部分，使用相同的方式
    // 得出数组未排序部分的最小值。循环结束，则得到排好序的数组。
    void choiceSort(int[] arr){   // for(for、if)
        for (int i = 0 ; i < arr.length; i++) {
            int index =  i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[index] > arr[j]){
                    index = j;
                }
            }
            if (index == i){
                continue;
            } else {
                int tmp = arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    // 插入排序（类似打扑克摆牌）：基本思想就是将无序序列插入到有序序列中。从第二个元素开始，将当前元素插入到前面对应位置，使当前元素i和之前的元
    // 素形成有序数组，依次进行。
    void InsertSort(int[] arr, int h) { // for(if(for))
         h = 1;
        for (int i = h; i < arr.length; i++){
            int j;
            if (arr[i] < arr[i - h]) {
                int tmp = arr[i];   //保存当前数值（即待插入的数）
                for (j = i - h; j >= 0 && tmp < arr[j]; j -= h){
                    arr[j + h] = arr[j];   // 数值复制到后一位，给新的值留出空
                }
                arr[j + h] = tmp;
            }
        }
    }
/*    void InsertSort(int[] arr) { // for(if(for))
        for (int i = 1; i < arr.length; i++){
            int j;
            if (arr[i] < arr[i - 1]) {
                int tmp = arr[i];   //保存当前数值（即待插入的数）
                for (j = i - 1; j >= 0 && tmp < arr[j]; j--){
                    arr[j + 1] = arr[j];   // 数值复制到后一位，给新的值留出空
                }
                arr[j + 1] = tmp;
            }
        }
    }*/

    // 希尔排序（基于插入排序）:先将待排记录序列分割成为若干子序列分别进行插入排序，待整个序列中的记录"基本有序"时，再对全体记录进行一次直接插入排序。
    void shellSort(int[] arr) {
        int i ; int j;
        long tmp;

        int h = 1;
        while (h <= arr.length/3) {  // 求解增量h
            h = h * 3 + 1;
        }
        while (h > 0) {
            // 插入排序的循环使用
            InsertSort(arr, h);
            h = (h - 1)/3;
        }

    }

    // 归并排序：把一个数组分成两半，排序每一半，然后利用merge()方法把数组的两半归并成一个有序的数组。而每一半的排序，递归使用归并排序。
    void mergeSort(int[] arr) {
        int [] temp = new int[arr.length];  // 构造辅助数组
        recMerge(arr, 0 , arr.length - 1, temp);

    }
    void  recMerge(int[] arr, int lowerBound, int upperBound, int[] temp ){
        if (lowerBound == upperBound){  //递归结束条件，分组只有一个数字时，认为有序，返回
            return;
        }else {
            int mid = (lowerBound + upperBound) / 2;
            recMerge(arr, lowerBound, mid, temp);                       // 排序左半数组
            recMerge(arr, mid + 1, upperBound, temp);        // 排序右半数组
            merge(arr, lowerBound, mid + 1, upperBound, temp); // 合并两个数组
        }
    }
    // 合并两个数组
    void merge(int[] arr, int lowPtr, int higthPtr, int upperBound, int[] temp) {
        int n = 0;     //辅助数组的索引
        int start = lowPtr;     //保存 辅助数组数据放回原数组时的 起始点
        int mid = higthPtr - 1; // lowPtr 左数组下边界，mid 左数组上边界; hightPtr(mid+1) 右数组下边界，upperBound 右数组上边界

        while (lowPtr <= mid && higthPtr <= upperBound){  //第一个while循环：沿左右数组走，比较他们的数据项，复制较小的数据到辅助数组
            if (arr[lowPtr] < arr[higthPtr]){
                temp[n++] = arr[lowPtr++];
            } else {
                temp[n++] = arr[higthPtr++];
            }
        }

        while (lowPtr <= mid) {            //第二个while循环：右数组先遍历完，左数组剩余数据项直接复制到辅助数组
            temp[n++] = arr[lowPtr++];
        }
        while (higthPtr <= upperBound){  //第三个while循环：左数组先遍历完，右数组剩余数据项直接复制到辅助数组
            temp[n++] = arr[higthPtr++];
        }

//        把辅助数组的数据放到原空间
        for (int i = 0; i < n ;i++){
            arr[start + i] = temp[i];
        }
    }

    // 堆排序（匆忙）
      void heapSort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }
    }
    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k] >temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }


    // 基数排序



    // swap element
    public void swap(int[] arr, int x, int y){
        int tmp  = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}

