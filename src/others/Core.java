package others;

/**
 * @Author Linton
 * @Date 2019/6/5 9:07
 * @Version 1.0
 * @Description
 */

public class Core {
    /**
     * Partion算法（荷兰国旗）（缺点：与标志数相等的数会被放在右边
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public  int Partition(int[] arr, int L,int R) {
        if (arr == null || arr.length <= 0 ||  L < 0 || R >= arr.length) {
            System.out.println("输入有误");
        }

        int index = L + (int)Math.random()*(R - L);
        Swap(arr, index, R);

        int less = L -1;
        for (index = L;index < R; ++index) {
            if (arr[index] < arr[R]) {
                ++less;
                if (less != index){
                    Swap(arr, index, less);
                }
            }
        }

        ++less;
        Swap(arr, less, R);
        return  less;
    }


    /**
     * ' 将两个数组的下标值互换
     * @param arr
     * @param i
     * @param j
     */
    public void Swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}

