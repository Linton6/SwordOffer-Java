package swordOffer;

import java.util.Scanner;

public class MinNumberInRotateArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
//        int[] array = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(str));

    }

    public static  StringBuilder minNumberInRotateArray(String array) {
        int size = array.length();
//        int[] array3 = new int[3];
        StringBuilder str1 = new StringBuilder();
        for (int i = 0; i < 3; i++){
            str1.append(array.charAt(i));
        }
        StringBuilder str2 = new StringBuilder();
        for (int i = 3; i < array.length(); i++){
            str2.append(array.charAt(i));
        }
        StringBuilder str = str2.append(str1);
//        str.deleteCharAt(str.length()-1);
        long t = 012;
        double j =0x56;

        return str;

     }
}
