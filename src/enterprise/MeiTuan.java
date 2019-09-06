package enterprise;


/**
 * @Date 2019/8/22 16:15
 * @ MPMPCPMCMDEFEGDEHINHKLIN  9 7 8
 *   MPMPCPMCM  ADEFEGDEA  HINHKLIN
 */
import java.util.*;
public class MeiTuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        patch(str);

    }
    private static void patch(String str) {
        int len = str.length();
        ArrayList<Integer> list = new ArrayList<>();
        int max = find(str.charAt(0),str);
        for (int i = 0; i < len;i++ ) {
            max = Math.max(max, find(str.charAt(i),str));
            for (int j = i; j <=  max; j++) {
                max = Math.max(max, find(str.charAt(j),str));
            }
            list.add(max - i + 1);
            i = max;
        }
        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }
    // 找到最大的下标
    private static int find (char c, String str) {
        int len = str.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == c) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
}


