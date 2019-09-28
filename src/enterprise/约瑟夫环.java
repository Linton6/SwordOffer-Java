package enterprise;

import sun.nio.cs.ext.IBM037;

import java.util.ArrayList;

/**
 * @Date 2019/9/22 17:17
 * @
 */

public class 约瑟夫环 {

    public static void main(String[] args) {
        int[] in = {10,3};
        System.out.println(yesefu(in));
    }
    public static String yesefu(int input[]) {
        int num = input[0];
        int count = input[1];

        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= num; i++) {
            list.add(i);
        }

        int k = 0; // 从第K个数开始计数

        while (list.size() > 0) {

            k = k + count;
            // 第m个人的索引位置
            k = (k % list.size())  - 1;  // 因为索引从0开始，进行取余是因为防止k大于圈中的人的总数
            //

            /**
             * 判断是否到队尾，即k的大小为list大小，此时k 为 -1,如果到队尾，则输出队尾元素，k重新回到起始位置
             * 不然的话，输出k位置的元素，并删除这个位置的元素
             */
            if (k < 0) { //
                sb.append(list.get(list.size() - 1));
                sb.append(" ");
                list.remove(list.size() - 1);
                k = 0;
            } else {
                sb.append(list.get(k)); //
                sb.append(" ");
                list.remove(k);
            }
        }

        int len = sb.length();
        sb.deleteCharAt(len - 1);
        return sb.toString();
    }
}



















































