package enterprise;


import java.util.Scanner;

/**
 * @Date 2019/9/21 15:35
 * @
 */

public class 网易1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            solution(arr[i]);
        }

    }

    private static void solution(int num)  {
        if (num < 10) {
            System.out.println(num);
        } else {
            StringBuilder sb = new StringBuilder();
            int temp;
            while (num > 9) {
                num = num - 9;
                sb.append("9");
            }
            sb.append(String.valueOf(num));
            sb.reverse();
            System.out.println(sb.toString());
        }

    }
}

