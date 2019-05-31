package sort;

/**
 * 插入排序：
 * 1、（划分两侧）无无序数组分为左右两个局部数组，左侧为有序数组，右侧为无序数组。
 * 2、（右侧插入左侧）标记右侧数组最左边的数为标记数，将标记数插入到左侧有序数组的合适位置。
 * 3、（重复）标记数向右移动一位（即仍然是右侧无序数组最左边的数），重复上述过程。
 * 4、（终止条件）知道右侧无序数组的数全部插入到左侧有序数组的合适位置为止。
 *
 */

public class InsertSort {

    public static void main(String[] args) {
        int[] n = {12,34,354,65,54};
        BubbleSort.display(inserSort(n));
    }



    public static int[] inserSort(int[] array){
        int left, right;
        for (right = 1; right < array.length; right++) {
            int temp = array[right];
            left = right;
            while (left > 0 && (array[left - 1] >= temp)) {
                array[left] = array[left - 1];
                --left;
            }
            array[left] = temp;
        }

        return array;
    }
}
