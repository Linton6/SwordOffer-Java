package swordOffer;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author Linton
 * @Date 2019/6/21 14:19
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description 全排列
 * 解题思路：找[1,2,3,4]的全排列；然后从1开始，找[2,3,4]的全排列；以此类推，显然最后变成了一个递归问题
 */

public class Permutation {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        char[] str = {'a','b','c'};
//        permutation(str,0);
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list.add("asd");
        list.add("dsd");
        list.add("cxcx");
        list.add("io");
        list1 = list.subList(1,3);
//        System.out.println(list1.toString());
        Iterator iterator = list.iterator() ;

        for (;iterator.hasNext();){
            Object str = iterator.next();

            if (str == "io")
                iterator.remove();
            System.out.println(str);
        }
        Iterator it = list.iterator() ;
        while (it.hasNext()){
            System.out.println(it.next());
        }
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        Permutation permutation = new Permutation();
        Class clazz = permutation.getClass();
        String className = clazz.getName();
        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println();
        Permutation o = (Permutation) Class.forName("swordOffer.Permutation").newInstance();
        Method method = clazz.getDeclaredMethod("m",int.class);
        method.invoke(null,1);
        System.out.println();

    }


    public  static int longg;
    public  String m;
    public static void permutation(char[] str, int n){
        if(str == null || n >= str.length){
            return;
        }
        if (n == (str.length - 1)) {
            System.out.println(str);
        } else {
            for (int i = n;i < str.length; i++ ){
//                    char temp = str[i];
//                    str[i] = str[n];
//                    str[n] = temp;
                    swap(str,i,n);
                    permutation(str,n+1);
                    swap(str,i,n);
//                     temp = str[i];
//                    str[i] = str[n];
//                    str[n] = temp;
                }
        }
    }

    public static void swap(char[] str, int i ,int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void m(int i){
        System.out.println("m123m");
    }

}