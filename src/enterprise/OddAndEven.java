package enterprise;

/**
 * @Author Linton
 * @Date 2019/7/10 16:22
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  2n个元素的数组，n个奇数，n个偶数，设计一个算法使得数组奇数下标位置放置的都是奇数，偶数位置放置的都是偶数
 */
import java.util.*;
public class OddAndEven {
    public static void main(String[] args) {
        int[] arr = {9,8,6,7,0,1,3,2,4,5};
        OddAndEven o = new OddAndEven();
        o.oddAndEven(arr);
        System.out.println(Arrays.toString(arr));

    }

    void oddAndEven(int[] arr){
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int size = arr.length;

        for (int i : arr) {
            if (arr[i] % 2 == 1) { // 奇数
                list1.add(arr[i]);
            } else{
                list2.add(arr[i]);
            }
        }

        for (int i = 0; i < size; i++) {
            if (i % 2 == 1){
                arr[i] = list1.pop();
            } else {
                arr[i] = list2.pop();

            }
        }
//        for(int i = 0; i < size; i++){
//            if (arr[i] % 2 == 1) { // 奇数
//                list1.add(arr[i]);
//            } else{
//                list2.add(arr[i]);
//            }
//        }

    }
}

