package sort;

/**
 * @Author Linton
 * @Date 2019/7/10 22:21
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        BinarySearch b = new BinarySearch();
//        System.out.println(b.reRinanrySerch(arr,1, 0 , arr.length-1));
        System.out.println(b.binnarySearch(arr,1));

    }

//    递归实现
    int reRinanrySerch(int[] arr, int key , int low ,int high) {
        //判断非法输入
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid] < key) {
           return reRinanrySerch(arr, key, mid + 1, high);

        } else if (arr[mid] > key) {
            return reRinanrySerch(arr, key, low, mid - 1);
        } else {
            return mid;
        }
    }

//    while循环实现
    int binnarySearch(int[] arr, int key){
        if (arr == null || arr.length == 0 || key > arr[arr.length - 1] || key < arr[0]){
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high){
            mid =( high + low) / 2; // 判断条件啊，你怎么就漏了呢
            if (arr[mid] > key){
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }
}

