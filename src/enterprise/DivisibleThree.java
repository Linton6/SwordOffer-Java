package enterprise;

import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/5 16:50
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class DivisibleThree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int m;
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            int res = num(generater(n, m));
            System.out.println(res);

        }




    }

    // 被3整除的数
    // 产生字符串数组
    private static int[] generater(int n, int m) {
        if (m < n) return null;
        int size = m - n + 1;
        String[] strings = new String[size];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i  < n - 1; i++) {
            stringBuffer.append(i+1);
        }
        int k = 0;
        for (int i= n; i <= m; i++){
            strings[k++] = stringBuffer.append(i).toString();
        }
        int [] arr = new int[size];
        int p = 0;
        for (String a : strings) {
            arr[p++] = Integer.parseInt(a);
        }
        return arr;
    }
    private static  int num (int[] arr) {
        if (arr == null) return 0;
        int k = 0;
        for (int a : arr) {
            if (a % 3 == 0) {
                k++;
            }
        }
        return k;
    }
}

