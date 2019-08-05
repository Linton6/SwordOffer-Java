package enterprise;
import java.util.*;

/**
 * @Author Linton
 * @Date 2019/8/3 16:07
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.util.*;
public class NumberRing {
    static ArrayList<int[]> lists = new   ArrayList<int[]>();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String t1 = in.nextLine();
        int t = Integer.parseInt(t1);
        int tt = t;
        while (t > 0){
            t--;
            String n1 = in.nextLine();
            int n = Integer.parseInt(n1);
            String str =in.nextLine();
            int[] ai = new int[n];
            int a = 0 ;
            String[] strings = str.split(" ");
            for (String s:strings){
                ai[a++] = Integer.parseInt(s);
            }
            lists.add(ai);
        }
        String[] str = process1(tt, lists);
        for (String astr : str){
            System.out.println(astr);
        }



    }

    private static String[] process1(int t,ArrayList<int[]> lists) {
        String[] str = new String[t];
        for (int i = 0; i < t; i++){
            int[] ai = lists.get(i);
            Arrays.sort(ai);
            for (int j = 0; j < ai.length - 1; j++){
                if (j == 0){
                    if (ai[j+1] + ai[ai.length - 1] <= ai[j]){
                        str[i] = "NO";
                        break;
                    }
                }
                if ( j != 0 && ai[j+1] + ai[j - 1] <= ai[j]){
                    str[i] = "NO";
                    break;
                }
            }
            if (ai[0] + ai[ai.length - 2] <= ai[ai.length - 1]){
                str[i] = "NO";
                break;
            } else {
                str[i] = "true";
            }
        }
        return str;

    }

}


