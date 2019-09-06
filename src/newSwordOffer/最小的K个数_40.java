package newSwordOffer;

/**
 * @Date 2019/8/22 12:55
 * @
 */

public class 最小的K个数_40 {
    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        minK(arr,1);
    }

    /**
     * 2019-8-22 12:55:50
     * 用partition得出前K个最小的数
      */
    private static void minK(int[] arr, int K) {
        if (K <= 0 || arr == null || arr.length == 0 || arr.length < K ) {
            return ;
        }
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);
        while (index != K - 1) {
            if (index > K - 1){
                index = partition(arr, start, index - 1);
            } else if (index < K - 1) {
                index = partition(arr, index + 1, end);
            }
        }
        for (int i = 0; i < K; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        while (end > start) {
            while (end > start && arr[end] > pivot) {
                end--;
            }
            arr[start++] = arr[end];
            while (end > start && arr[start] <= pivot) {
                start++;
            }
            arr[end--] = arr[start];
            if (end > start ){
                int tmp;
                tmp = arr[end] ;
                arr[end--] = arr[start];
                arr[start++] = tmp;
            }
        }
        return start;
    }
}

