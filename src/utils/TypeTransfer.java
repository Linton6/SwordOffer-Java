package utils;

import java.util.*;
/**
 * @Author Linton
 * @Date 2019/8/4 10:31
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class TypeTransfer {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(Arrays.asList(ListToInteger(list)));

    }

    /** @ 自带的进制转换 */
    {
        System.out.println(Integer.parseInt("66",7));
    }
    /**  @ List和int[] 相互转换 */
    public int[] ListTpints(ArrayList<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    private static Integer[] ListToInteger(ArrayList<Integer> list){
        return list.toArray(new Integer[0]);
    }
    public List<Integer> IntsToList(Integer[] arr){ //还是foreach一个一个添加吧
        return Arrays.asList(arr);
    }

    /** @ 输出小数点后几位 */
    {
        System.out.printf("%.2f\n", 2.34545);
        System.out.println(123);
    }


    /** @ 遍历HashMap */
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1,2);
        map.put(3,4);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
    /** 建立大根堆和小根堆 */
    {

    // 建立一个小跟堆  // 建立一个大根堆
      class MinComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
      class MaxComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
        int[] arr ={};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinComparator());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxComparator());
        for (Integer i : arr) {
            maxHeap.add(i);
        }
        for (Integer i : arr) {
            minHeap.add(i);
        }
        maxHeap.poll();
        minHeap.poll();
        minHeap.poll();

        System.out.println();

    }
}

