package enterprise;

import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/4 19:39
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class SloveBug {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int N = Integer.parseInt(strs[0]);
            int A = Integer.parseInt(strs[1]);
            int X = Integer.parseInt(strs[2]);
            int[] ti = new int[N];
            int a = 0;
            while (N > 0) {
                ti[a++] = in.nextInt();
                N--;
            }
            System.out.println(debug(ti.length, ti, A, X));
        }


    }

    private static int debug(int N, int[] ti, int A, int X){
        int sum = 0;
        for (int t : ti) {
            sum += t;
        }
        double save =  sum / (double)A;
        save = Math.ceil(save);
        if (save <= X * 60) {
            return (int)save;
        } else {
            int res = (int)save - X*60;
            if (res >= (8-X)*60){
                return (int)save + res;
            }else {
                return 0;
            }
        }
    }
}

