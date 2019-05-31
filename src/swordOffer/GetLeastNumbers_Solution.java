package swordOffer;

import java.util.ArrayList;

/**
 * @Author Linton
 * @Date 2019/5/21 21:51
 * @Version 1.0
 * @Description
 */

public class GetLeastNumbers_Solution {
    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> b = new ArrayList<>();
        b = GetLeastNumbers_Solution(a,10);
        System.out.println();
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k <= 0 || k > input.length   ) {
            return null;
        }
        if (input.length == 0){
            return null;
        }
        ArrayList<Integer> b = new ArrayList<>();
        // 快速排序法排序
        for(int i = 0; i < input.length -1 ; i++) {
            for (int j = i+1 ; j < input.length ; j++ ) {
                if(input[i] >= input[j] ) {
                    int tmp = input[j];
                    input[j] = input[i];
                    input[i] = tmp;
                }
            }
        }

        // 取出前面的k个数
        for(int i = 0; i < k ; i++) {
            b.add(input[i]);
        }
        return b;
    }

}

