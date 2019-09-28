package enterprise;

/**
 * @Date 2019/9/22 16:34
 * @
 */



import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Welcome to vivo !
 */

public class vico2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {
        int num = input[0];
        int count = input[1];

        int n = 0;
        int rest = num;
        int index = 1;
        int l  = 0;
        Queue<Integer> list = new LinkedList<>();
        for (int i =1; i <= num; i++) {
            list.add(i);
        }

        while (!list.isEmpty()) {
            Integer poll = list.poll();
            l++;
            if (rest == 1) {
                n = poll;
                break;
            }

            if (l % count == 1) {
                System.out.println();
                list.add(poll);
                System.out.println("di" + index + " 刺游戏" + poll + 'L' );

            } else if (l % count == 0) {
                System.out.println();
                rest--;
                index++;
            } else {
                list.add(poll);
                System.out.println();
            }
        }

        return "";



//        ArrayList<Integer> list = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//
//        for ( int i = 0; i < len; i++) {
//            list.add(input[i]);
//        }
//        while (list.size() > 1) {
//
//        }

    }

}