package swordOffer;

/**
 * @Author Linton
 * @Date 2019/8/1 22:06
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.util.*;

public class DataFlow {
    public static void main(String[] args) {

    }

    ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        if(list.size() % 2 == 1) {
            return list.get(list.size()/2 ).doubleValue();// ji
        } else {
            Double a = list.get(list.size()/2 - 1).doubleValue();
            Double b = list.get(list.size()/2 ).doubleValue();
            return  (a+b)/2;
        }
    }
}

