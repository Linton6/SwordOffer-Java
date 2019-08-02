package enterprise;

/**
 * @Author Linton
 * @Date 2019/7/28 14:55
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.*;
import java.util.Scanner;
public class C1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in);
        String list1 = in.nextLine();
        String list2 = in.nextLine();
        String[] list3 = list1.split(" ");
        String[] list4 = list2.split(" ");
        int a1 = list3.length;
        float[] A = new float[a1];
        for(int i = 0; i < a1; i++){
            A[i] = Float.valueOf(list3[i]);
        }
        int a2 = list4.length;
        float[] B = new float[a2];
        for(int i = 0; i < a2; i++){
            B[i] = Float.valueOf(list4[i]);
        }
        float[] C = sort(A ,B);
        if (C == null) {
            System.out.println("NO");
        } else {
            System.out.println(Arrays.toString(C));
        }

//        System.out.println(list1);
//        System.out.println(list2);


    }

    public static float[] sort(float[] A, float[] B){
        if(A == null || A.length < 2 || B == null || B.length == 0 ) return null;
        int a = A.length;
        int b = B.length;
        int indexA = -1;
        for(int i = 0; i < a - 1; i++){
            if(A[i] >= A[i + 1]) {
                if (A[i] > A[i + 2]){
                    indexA = i;
                } else {
                    indexA = i + 1;
                }

            }
        }
        int leftA = indexA - 1;
        int rightA = indexA + 1;
        // 在B中取出范围的值
        float max = A[indexA];
        for(int i = 0; i < b; i++) {
            if(B[i] > A[leftA] && B[i] < A[rightA]){
                if(B[i] > max){
                    max = B[i];
                }
            }
        }
        if(A[indexA] == max) {
            return null;
        } else {
            A[indexA] = max;
            return A;
        }
    }

}

