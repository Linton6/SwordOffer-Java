package sort;

/**
 * 思路和QuickSort一样，只是表现的方法有些复杂
 */

public class QuickSort2 {
    public void quickSort() {
    }

    public void recQuickSort(int[] arr, int left, int right) {
        if (right - left <= 0) {
            return; // 说明数组小于1，已排序
        } else {
            long pivot = arr[right];
//            int partition = partitionIt(left)
        }
    }
}
