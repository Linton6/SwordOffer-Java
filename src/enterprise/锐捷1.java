package enterprise;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Date 2019/9/19 19:58
 * @1、四个数组成不同的3个数,2、找到中间节点,
 */

public class 锐捷1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        char[] arr = s.toCharArray();
        System.out.println(solution(arr, m));

    }

    private static int solution(char arr[], int m) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int max = 1;

        char[] chs = new char[m];

        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < n ; i++) {
            if (list.size() == 3) {

            }else {
                list.addFirst(arr[i]);
            }
        }
        return m - max;



    }

    // 窗口内的重复次数



    private static int sub(char[] chs, int i, int j) {
        int max = 1;
        int temp = 1;

        char[] arr = new char[j - i + 1];


        for (int k = i; k <= j - 1; k++) {
            for (int h = k + 1; h <= j; h++) {
                if (chs[k] == chs[h]) {
                    temp++;
                }
            }
            max = Math.max(temp, max);
            temp = 1;
        }
        return max;
    }




}

