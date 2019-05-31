package sort;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Linton
 * @Date 2019-4-11 21:17:29
 * @Description 选择排序
 */

public class SelectSort {
    public static void main(String[] args) throws InterruptedException {
        int[] n = {12,32,4,5,5,3,221,54,67};
        // 睡眠1秒
        TimeUnit.SECONDS.sleep(1);
        // 获取当前时间
        Date date = new Date();
        System.out.println(date);
        // 获取方法执行时间
        long startTime = System.currentTimeMillis();
        BubbleSort.display(selectSort(n));
        long endTime = System.currentTimeMillis();
        long mid = (endTime - startTime);
        System.out.println("执行时间 "+mid );

    }

    public static int[] selectSort(int [] array){
        int out, in, min;
        for (out = 0; out < array.length-1; out++){
            min = out;
            for (in = out + 1; in < array.length; in++){
                if (array[min] > array[in]){
                    min = in;
                }
            }
            int temp ;
            temp = array[min];
            array[min] = array[out];
            array[out] = temp;
        }

        return array;

    }
}
