package enterprise;

import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/3 16:44
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class SequeExchange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n1  = in.nextLine();
        int n = Integer.parseInt(n1);
        String s = in.nextLine();
        String[] str = s.split(" ");
        int ai[] = new int[n];
        int a = 0;
        for (String s1 : str){
            ai[a++] = Integer.parseInt(s1);
        }
        for (int aai : ai){
            System.out.print(aai+ " ");
        }
    }
    private int[] exchange(int[] ai){
        return ai;
    }
}

