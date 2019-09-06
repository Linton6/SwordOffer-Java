package enterprise;

/**
 * @Date 2019/9/1 15:06
 * @
 */
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PINDUODUO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(";");
        String ss = strs[0];
        int N = Integer.valueOf(strs[1]);
        sort(ss, N);

    }

    private static void sort(String str, int N) {
        String[] strs = str.split(",");
        int len = strs.length;
        long[] arr = new long[len];
        ArrayList<Long> list1 = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();
        for (int i = 0; i < len; i++){
            //strs[i].charAt(strs[i].length() - 1)
            long n = Long.valueOf(strs[i]);
            if ( n % 2 == 0) {
                list2.add(n);// 偶数
            } else {
                list1.add(n); // 奇数
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int n2 = list2.size();
        int n1 = list1.size();
        int j = 0;
        for (int i = n2-1; i >= 0; i--) {
            arr[j++] = list2.get(i);
        }
        j = n2;
        for (int i =  n1 - 1; i >= 0; i--) {
            arr[j++] = list1.get(i);
        }

        for (int i = 0; i < N-1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[N-1]);

    }
}

