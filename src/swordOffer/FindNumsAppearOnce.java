package swordOffer;

import java.util.*;

/**
 * @Author Linton
 * @Date 2019/6/25 16:07
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null) {
            return;
        }
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        int size = array.length;
        boolean status = false;
        for(int i = 0; i < size; i++) {
            status = set1.add(array[i]);
            if(status == false) {
                set2.add(array[i]);
            }
        }
        Iterator<Integer> it1 = set2.iterator();
        while(it1.hasNext()){
            set1.remove(it1.next());
        }
        Iterator<Integer>  it2 = set1.iterator();
        List<Integer> list = new ArrayList<Integer>();
        while(it2.hasNext()) {
            list.add(it2.next());
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }
}

