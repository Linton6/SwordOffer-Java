package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/9/20 20:17
 * @
 */

public class 腾讯1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            strs[i] = in.nextLine();
        }
        solution(strs);

    }

    private static void solution(String[] strs) {
        if (strs == null || strs.length == 0) {
            System.out.println("NO");
        }
        int len = strs.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int length = strs[i].length();
            if (length < 11) {
                System.out.println("NO");
            } else {
                for (int j = 0; j < length; j++) {
                    if (strs[i].charAt(j) == '8') {
                        res = length - j;
                        if (res >= 11) {
                            System.out.println("YES");
                        } else {
                            System.out.println("NO");
                        }
                        break;
                    }
                    if (j == length - 1) {
                        System.out.println("NO");
                    }
                }

            }
        }
    }

}

