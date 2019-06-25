package swordOffer;

import java.util.*;

/**
 * @Author Linton
 * @Date 2019/6/23 12:46
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class PermutationDup2 {
    public static  void  main(String []args){
        String str = "abc";
        TreeSet set = new TreeSet();
        List list = digui(str);
        System.out.println(list.size());
        for(Object o :list){
            set.add(o.toString());
        }
        System.out.println(list.toString());
        System.out.println(set.toString());
    }

    public static List digui(String str){
        List list =new ArrayList();
        if(str.length() == 1){
            list.add(str);
        }
        for(int i = 0;i < str.length();i++){
            String f = str.substring(i,i+1);
            String res = str.substring(0, i)+str.substring(i+1);  // 把第i个数空出来了

            List px = digui(res);
// 没看懂的地方
            for(int j = 0; j < px.size(); j++){
                list.add(f + px.get(j).toString());
            }
        }
//        if(str.length() == 1){
//            list.add(str);
//        }
//        for (int i = 0; i < str.length(); i++) {
//            String left = str.substring(i,i+1);
//            String
//        }

        return  list;
    }
}

