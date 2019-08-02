package enterprise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/7/28 16:04
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class C2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "";
           str  = in.nextLine();
           String[] strs = str.split(" ");

        System.out.println(judge(strs));

    }

    public static boolean judge(String[] strs) {
        if(strs == null || strs.length == 0) return false;
        int size  = strs.length;
        for(int i = 0; i < size - 1; i++) {
            if(strs[i].charAt(strs[i].length() - 1) != strs[i].charAt(0)){
                return false;
            }
        }
        if (strs[0].charAt(0) != strs[size - 1].charAt(strs[size - 1].length() - 1)){
            return false;
        }
        return true ;

    }
}

