package enterprise;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/18 15:50
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class RedBoook2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
            String str = in.nextLine();
            reverse(str);
//        }

    }
    private static void reverse(String str) {
        String[] strs = str.split(" +");
        int size = strs.length;
        String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            strings[size - 1 - i] = strs[i];
        }
        for (int i = 0; i < size -1 ; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.println(strings[size - 1]);


    }
}

