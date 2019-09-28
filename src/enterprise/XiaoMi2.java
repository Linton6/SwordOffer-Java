package enterprise;

/**
 * @Date 2019/9/11 19:50
 * @
 */


import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class XiaoMi2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] arr){  // for(for(if))
        for(int i = 0; i < arr.length  ; i++){
            for (int j = 0; j < arr.length - i - 1 ; j++){
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                    count++;
                }
            }
        }
        return count;
    }
    static int count = 0;

//    static int solution(int[] array){
//        if (array.length == 0){
//            return 0;
//        }
//        quickSort(array,0, array.length - 1);
//        return count;
//
//    }
//    static int count = 0;
//    public static void quickSort(int[] array, int low, int high) {
//        if (low >= high) {
//            return;
//        }
//        int i = low, j = high, index = array[i]; // 取最左边的数为基准数
//        while (i < j) {                          // i == j 时，跳出循环
//            while (i < j && array[j] >= index)  // 向左寻找第一个小于index的数
//                j--;
//            if (i < j)
//                array[i++] = array[j];      // 将array[j]填入array[i]，并将i向右移动
//            while (i < j && array[i] <= index)  // 向右寻找第一个大于index的数
//                i++;
//            if (i < j)
//                array[j--] = array[i];//将array[i]填入array[j],并将j向右移动
//            count++;
//        }
//        //count++;
//        array[i] = index; // 将基准数填入最后的坑 i == j
//        quickSort(array,low,i - 1); // 递归调用，分治
//        quickSort(array,i + 1,high); // 递归调用，分治
//    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = solution(_arr);
        System.out.println(String.valueOf(res));

    }
}


