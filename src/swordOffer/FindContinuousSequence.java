package swordOffer;

import java.util.*;
/**
 * @Author Linton
 * @Date 2019/6/25 16:54
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if(sum <= 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        int mid = sum / 2 + 1;
        int count = 0;
        for(int i = 0; i < mid; i++) {
            count = i;
            for(int j = i + 1; j < sum; j++) {
                count = count + j;
                if(count == sum){
                    int start = i;
                    int end = j;
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for(int k = i; k <= j; k++) {
                        list.add(k);
                    }
                    listAll.add(list);
                }
                if(count > sum) {
                    break;
                }
            }
        }
        Collections.sort(listAll, new Comparator< ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
                return l1.get(0) - l2.get(0);
            }
        });
        return listAll;

    }
}

