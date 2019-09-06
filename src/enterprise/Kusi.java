package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/8/25 17:45
 * @
 */

public class Kusi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n1 = in.nextLine();
        int n =Integer.valueOf(n1);
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = in.nextLine();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(judge(strs[i]));
        }
    }

    private static  boolean judge(String str) {
        String[] strs = str.split(" ");

        String[] v1 = strs[0].split("\\.");
        String[] v2 = strs[1].split("\\.");
        int l1 = v1.length;
        int l2 = v2.length;
        int min = Math.min(l1, l2);
        for (int i = 0; i < min; i++) {
            int i1 = Integer.valueOf(v1[i]);
            int i2 = Integer.valueOf(v2[i]);
            if (i1 < i2) {
                return true;
            } else {
                return false;
            }
        }
        if (l1 > l2) {
            for (int i = min; i < l1; i++) {
                if (Integer.valueOf(v1[i]) != 0) {
                    return false;
                }
            }
            return false;
        } else {
            for (int i = min; i < l2; i++) {
                if (Integer.valueOf(v2[i]) != 0) {
                    return true;
                }
            }
            return false;
        }
    }
}

