package enterprise;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Date 2019/9/1 16:44
 * @二维表第K大哥数
 */

public class NIN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");
        int n = Integer.valueOf(strs[0]);
        int m = Integer.valueOf(strs[1]);
        int k = Integer.valueOf(strs[2]);
        sort(n,m,k);

    }

    private static void sort (int n, int m, int K) {
        if(K == 1){
            System.out.println(n*m);
        }
        if (K == 2){
            System.out.println(Math.max(n*(m-1),m*(n-1)));
        }
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <=
                    m; j++) {
                list.add((long)i * j);
            }
        }
        Collections.sort(list);
        long num = list.size();
        System.out.println(list.get((int)num - K));
    }
}

