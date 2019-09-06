package enterprise;



/**
 * @Date 2019/8/25 17:07
 * @
 */
import java.util.Scanner;
public class KuaiSHou {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String n1 = in.nextLine();
            int n =Integer.valueOf(n1);
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = in.nextLine();
            }
            for (int i = 0; i < n; i++) {
                System.out.println(judeg(strs[i]));
            }
        }


    }

    private static boolean judeg(String str) {
        str = str.replace(".", "");
        String[] strs = str.split(" ");
        int size1 = strs[0].length();
        int size2 = strs[1].length();

        if (strs[0].compareTo(strs[1]) > 0) {
            return  false;
        } else {
            return  true;
        }
//        int i = 0; int j = 0;
//        while ( i < size1 || j < size2) {
//            while (   i < size1 && j < size2  && strs[0].charAt(i) == strs[1].charAt(j)){
//                i++;j++;
//            }
//            if ( i < size1 && j < size2 ) {
//                int num = strs[0].charAt(i) -strs[1].charAt(j);
//                if (num < 0) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//            while (i < size1) {
//                   if (strs[0].charAt(i) != '0') {
//                       return false;
//                   }
//               i++;
//            }
//            while (j < size2) {
//                    if (strs[1].charAt(j) != '0') {
//                        return true;
//                    }
//                j++;
//            }
//
//        }
//        return false;
    }
}

