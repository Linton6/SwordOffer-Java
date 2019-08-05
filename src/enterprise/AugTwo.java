package enterprise;

import java.util.*;

/**
 * @Author Linton
 * @Date 2019/8/2 15:55
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  牛客网上网易的编程题
 */

public class AugTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        String[] arr = n.split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (N-- > 0) {
            String s = in.nextLine();
            String[] strs = s.split(" ");
            int Di = Integer.parseInt(strs[0]);
            int Pi =  Integer.parseInt(strs[1]);
            hashMap.put(Di, Pi);
        }
        String Ms = in.nextLine();
        String[] Mss = Ms.split(" ");
        int[] member = new int[M];
        int i = 0;
        for(String m : Mss){
            member[i++] = Integer.parseInt(m);
        }

        int[] Pi_arr = choice(member, hashMap);
        for (Integer p: Pi_arr) {
            System.out.println(p);
        }


    }

    // 返回一个数组即可   遇到重复的key就GG
    private static int[] choice (int[] member, HashMap<Integer, Integer> hashMap) {
        if (member == null || member.length == 0 || hashMap == null) return null;
        int size_hashMap = hashMap.size();
        Set<Integer> set = hashMap.keySet();
        int[] Di_arr = new int[size_hashMap];
        int[] Pi_arr = new int[size_hashMap];
        int k = 0;
        int p = 0;
        int u = 0;
        for(Integer s : set) {
            Di_arr[k++] = s;
        }
        Arrays.sort(Di_arr);
        for (int aMember : member) {
            Pi_arr[p++] = find(aMember, Di_arr);
        }
        for(Integer aPi : Pi_arr) {
            Pi_arr[u++] = hashMap.get(aPi);
        }
        return Pi_arr;
    }

    // 在一个数组中找到比它小的最大值，返回int arr是已排序的数组
    private static int find (int num, int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        for(int i = 0; i < arr.length; i++) {
            if (num < arr[i] && i > 0) {
                return  arr[i - 1];
            } else if (num == arr[i] ) {
                return arr[i];
            }
        }
        return 0;
    }
}

