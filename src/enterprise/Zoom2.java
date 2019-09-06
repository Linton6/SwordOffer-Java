package enterprise;

import java.util.ArrayList;

/**
 * @Author Linton
 * @Date 2019/8/17 14:54
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.*;
public class Zoom2 {
    public static void main(String[] args) {
        char[] c = {'1','2','3'};
        permutaions(c,0);
        for (String s : list) {
            System.out.println(s);
        }

    }

    /**
     * 全排列  n 值默认为0
     */
    public static ArrayList<String> list = new ArrayList<String>();
    public  static void permutaions(char[] str, int n) {
        if(str == null || n >= str.length) {
            return;
        }
        int size = str.length;
        if(n == size - 1) {
            String s = "";
            for(int i = 0; i < size; i++){
                s = s + str[i]+ " ";
            }
            list.add(s);
        } else {
            for(int i = n; i < size; i++) {
                char temp = str[n];
                str[n] = str[i];
                str[i] = temp;
                permutaions(str,n+1);
                temp = str[n];
                str[n] = str[i];
                str[i] = temp;
            }
        }

    }
}

