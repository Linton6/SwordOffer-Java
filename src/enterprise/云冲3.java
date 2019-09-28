package enterprise;

import others.coreJava.InetAddressTest;

import java.util.*;
public class 云冲3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.replace("[","");
        str = str.replace("]","");
        str = str.replace(" ","");
        String strs[] = str.split(",");
        int len = strs.length;
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        String str2 = in.nextLine();
        str2 = str2.replace("[","");
        str2 = str2.replace("]","");
        str2 = str2.replace(" ","");
        String str2s[] = str2.split(",");
        int len2 = str2s.length;
        int arr2[] = new int[len2];
        for (int i = 0; i < len2; i++) {
            arr2[i] = Integer.valueOf(str2s[i]);
        }
        System.out.println(solution(arr, arr2));
    }

    private static int[] solution(int[] arr, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int len1 = arr.length;
        int len2 = arr2.length;
        Set<Integer> set = new HashSet<>(Arrays.asList(len1 > len2 ? len1 : len2));
        int max = Math.max(len1,len2);
        for (int i = 0; i < max; i++) {
        }
        return null;
    }
}


/**
 * @Date 2019/9/24 20:52
 * @
 */

