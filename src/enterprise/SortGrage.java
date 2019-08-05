package enterprise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/3 15:31
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class SortGrage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n1 = in.nextLine();
        int n = Integer.parseInt(n1);
        String s = in.nextLine();
        String[] strings = s.split(" ");
        int[] ai = new int[n];
        int a = 0;
        for ( String str : strings){
            ai[a++] = Integer.parseInt(str);
        }
        int q = in.nextInt();
        int[] qi = new int[q];
        int b = 0;
        while (q > 0){
            int j = in.nextInt();
            qi[b++] = j;
            q--;
        }
        double[] resut = sort(n, ai, qi.length, qi);
        for(double f : resut) {
            System.out.printf("%.6f\n",f);
        }

    }

    private static double[] sort(int n, int[] ai, int q, int[] qi) {
        int[] ni = new int[n];
        int a = 0;
        int b = 0;
        int s ;
        int count ;
        for (int aai : ai){
            ni[a++] = aai;
        }
        Arrays.sort(ni);
        double[] Ni = new double[q];
        for (int i = 0; i < q; i++) {
            s = ai[qi[i] - 1];
            count = 0;
            for (int j = 0; j < n; j++){
                if (s >= ai[j] ){
                    count++;
                }
            }
            Ni[b++]  = ((count - 1d) / n)*100;
            count = 0;
        }

        return Ni;
    }
}

