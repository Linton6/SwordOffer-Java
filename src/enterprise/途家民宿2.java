package enterprise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Date 2019/9/22 20:51
 * @
 */

public class 途家民宿2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] NMR = new int[3];
        NMR[0] = in.nextInt();
        NMR[1] = in.nextInt();
        NMR[2] = in.nextInt();

        int[] rR = new int[NMR[2]];
        for (int i = 0; i < NMR[2]; i++) {
            rR[i] = in.nextInt();
        }

        int[][] MM = new int[NMR[1]][3];
        for (int i = 0; i < NMR[1]; i++) {
            for (int j = 0; j < 3; j++) {
                MM[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(NMR, rR, MM));

    }

    private static int solution(int[] NMR, int[] rR, int[][] MM) {
        int N = NMR[0];
        int M = NMR[1];
        int R = NMR[2];

        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            
        }

        return 3;


    }
}

