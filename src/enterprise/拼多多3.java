package enterprise;

import others.coreJava.InetAddressTest;

import java.util.*;

/**
 * @Date 2019/9/25 15:57
 * @
 */

public class 拼多多3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();

        System.out.println(solution(N, M, K));

    }

    private static String solution(int N, int M, int K) {
        char[] chs = new char[N + M];
        for (int i = 0; i < N; i++) {
            chs[i] = 'a';
        }
        for (int i = N; i < M + N; i++) {
            chs[i] = 'b';
        }
        ArrayList<Integer> list = new ArrayList<>();

        if (K == 0) {

        }

return null;
    }


}

//    private static char[] s (char[] chs , int n) {
//        String s = new String(chs);
//        s = s.substring(0, n);
//        return s.toCharArray();
//    }
//
//    public static ArrayList<String> list = new ArrayList<String>();
//
//    public static void permutaions(char[] chs, int n) {
//        if(chs == null || n >= chs.length) {
//            return;
//        }
//        int size = chs.length;
//        if(n == size - 1) {
//            String s = "";
//            for(int i = 0; i < size; i++){
//                s = s + chs[i];
//            }
//            list.add(s);
//        } else {
//            for(int i = n; i < size; i++) {
//                char temp = chs[n];
//                chs[n] = chs[i];
//                chs[i] = temp;
//                permutaions(chs,n+1);
//                int k = 0;// 删除
//                temp = chs[n];
//                chs[n] = chs[i];
//                chs[i] = temp;
//            }
//        }
//    }
//}

