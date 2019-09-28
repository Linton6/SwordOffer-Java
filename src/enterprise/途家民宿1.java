package enterprise;

import java.util.Scanner;

/**
 * @Date 2019/9/22 20:27
 * @
 */

public class 途家民宿1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");

        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        solution(arr);

    }

    private static void solution(int[] arr) {
        int M = arr[0];
        int S = arr[1];
        int T = arr[2];

        int i;
        int distance1;
        int distance2;
        distance1 = 0;
        distance2 = 0;
        for (i = 1; i <= T; i++) {
            if (M >= 10) {
                distance1 += 50;
                M -= 10;
            } else {
                M += 4;
            }
            if (distance1 > distance2 + 13) {
                distance2 = distance1;
            } else {
                distance2 += 13;
            }
            if (distance2 >= S){
                break;
            }
        }

        if (i > T) {
            System.out.println("No");
            System.out.println(distance2);
        } else {
            System.out.println("Yes");
            System.out.println(i);
        }
    }
}

