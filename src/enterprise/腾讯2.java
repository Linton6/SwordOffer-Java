package enterprise;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Date 2019/9/20 20:50
 * @
 */

public class 腾讯2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solution(arr,n,k);

    }

    private static void solution(int[] arr, int n, int k) {
        if ( arr == null || arr.length == 0 ) {
            return ;
        }
        PriorityQueue<Integer> Q1 = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            Q1.add(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();

        int num = Q1.poll();
        list.add(num);
        int subnum = num;
        for (int i = 1; i <k;i++) {
            if (Q1.isEmpty()) {
                list.add(0);
                continue;
            }

            num = Q1.poll();
            while (!Q1.isEmpty() && num - subnum == 0) {
                num = Q1.poll();
            }

            if (num == subnum && Q1.isEmpty()) {
                list.add(0);
            }else {
                list.add(num - subnum);
                subnum += num - subnum;
            }
        }


        int len = list.size();
        for (int i = 0; i < len; i++) {
            System.out.println(list.get(i));
        }
    }
}




//
//import java.util.ArrayList;
//        import java.util.PriorityQueue;
//        import java.util.Scanner;
//
///**
// * @Date 2019/9/20 20:50
// * @
// */
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
//        solution(arr,n,k);
//
//    }
//
//    private static void solution(int[] arr, int n, int k) {
//        if ( arr == null || arr.length == 0 ) {
//            return ;
//        }
//        PriorityQueue<Integer> Q1 = new PriorityQueue<>();
//        PriorityQueue<Integer> Q2 = new PriorityQueue<>();
//        PriorityQueue<Integer> Q3 = new PriorityQueue<>();
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            Q1.add(arr[i]);
//        }
//
//
//        int num = 0 ;
//        int subnum = 0 ;
//
//
//        for (int i = 0; i < k; i++) {
//            if (Q1.isEmpty()){
//                list.add(0);
//                continue;
//            }
//
//            num = Q1.poll();
//            list.add(num);
//
//            while (!Q1.isEmpty()) {
//                subnum = Q1.poll();
//                int tem = subnum - num;
//                if (tem > 0) {
//                    Q2.add( tem );
//                }
//            }
//            while (!Q2.isEmpty()){
//                Q1.add(Q2.poll());
//            }
//
//        }
//
//        int len = list.size();
//        for (int i = 0; i < len; i++) {
//            System.out.println(list.get(i));
//        }
//    }
//}
//
