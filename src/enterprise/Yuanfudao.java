package enterprise;

/**
 * @Date 2019/8/24 15:59
 * @
 */
import java.util.*;
public class Yuanfudao {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str1 = in.nextLine();
            String[] str1s = str1.split(" ");
            int n = Integer.valueOf(str1s[0]);
            int m = Integer.valueOf(str1s[1]);
            String str2 = in.nextLine();
            String[] str2s = str2.split(" ");
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.valueOf(str2s[i]);
            }
            baoshu(arr, m);
        }


    }

    private static void baoshu(long arr[], int m) {
        int size = arr.length;
        int[] hash = new int[size];
        for (int i = 0; i < size; i++) {
            hash[(int)arr[i]]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < hash.length; i++) {
            if ( hash[i] > m) {
                list.add(i);
            }
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (!list.contains((int)arr[i])){
                list2.add((int)arr[i]);
            }
        }
        for (int i = 0; i < list2.size() - 1;i++) {
            System.out.print(list2.get(i) + " ");
        }
        System.out.println(list2.get(list2.size() - 1));
    }
}

