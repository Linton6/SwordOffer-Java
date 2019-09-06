package enterprise;


/**
 * @Author Linton
 * @Date 2019/8/17 14:30
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.*;
public class Zoom1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            System.out.println(count(str));
        }
    }

    private static int count(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        ArrayList<Integer> list = new ArrayList<>();
        int num= 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                list.add(str.charAt(i) - '0');
            }
            if (str.charAt(i) == '-') {
                num++;
                while ( i + 1 <len &&str.charAt(++i) == '-') {
                    num++;
                }
               // i--;
                if (num % 2 == 1) {
                    if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                        int n = str.charAt(i) - '0';
                        n = -1 * n;
                        list.add(n);
                    }
                } else {
                    i--;
                }
                num = 0;
            }
        }
        int max = 0;
        if (list.size() == 0) {
            return 0;
        }
        for (Integer n : list) {
            max += n;
        }
        return max;
    }
}

