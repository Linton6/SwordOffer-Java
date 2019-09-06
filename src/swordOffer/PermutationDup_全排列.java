package swordOffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Author Linton
 * @Date 2019/6/23 12:12
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class PermutationDup_全排列 {
    public static void main(String[] args) {
        String s = "abcd";
        String s1 = s.substring(0,0);
        String s2 = s.substring(2);
        CharSequence s3 = s.subSequence(1,3);
        System.out.println("s1 " + s1 + " s2 " + s2 + " s3 " +s3 );
//        PermutationDup_全排列 permutationDup = new PermutationDup_全排列();
//
//        System.out.println(permutationDup.Permutation(s).toString());
    }

    public ArrayList<String> Permutation(String str) {
        if(str == null ) {
            return null;
        }
        if(str == ""){
            list.add("1");
            return  list;
        }
        int size = str.length();
        char[] chars = new char[size];
        for(int i = 0; i < size; i++) {
            chars[i] = str.charAt(i);
        }
        permutaions(chars, 0);

         TreeSet<String> set = new TreeSet<String>();
         for ( String l : list){
             set.add(l);
         }
        ArrayList<String> list1 = new ArrayList<String>();
         for (String l : set){
             list1.add(l);
         }

        return list1;

    }

    /**
     * 全排列
     */
    public  ArrayList<String> list = new ArrayList<String>();

    public void permutaions(char[] str, int n) {
//        if(str == null || n >= str.length) {
//            return;
//        }
//        int size = str.length;
//        if(n == size - 1) {
//            String s = "";
//            for(int i = 0; i < size; i++){
//                s = s + str[i];
//            }
//            list.add(s);
//        } else {
//            for(int i = n; i < size; i++) {
//                char temp = str[n];
//                str[n] = str[i];
//                str[i] = temp;
//                permutaions(str,n+1);
//                temp = str[n];
//                str[n] = str[i];
//                str[i] = temp;
//            }
//        }

    }
}

