package enterprise;


/**
 * @Date 2019/8/27 19:59
 * @
 */
import java.util.Scanner;

public class DIDI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n1 = in.nextLine();
        int N = Integer.valueOf(n1);
        String str = in.nextLine();
        tranfer(N,str);

    }

    private static void tranfer(int N, String str) {
        str = str.replace(" ","");
        int n = N -1;
        int size  = str.length();
        char[] symbol = new char[n];
        int[] num = new int[N];
        int a = 0; int b = 0;
        int left = 0;
//        for (int i= 0; i < size; i++) {
//            if (str.charAt(i) == '+' || str.charAt(i) == '-' ||str.charAt(i) == '*' ||str.charAt(i) == '/' ) {
//                symbol[a++] = str.charAt(i);
//                num[b++] = Integer.valueOf(str.substring(left, i));
//                left = i+1;
//            }
//
//        }
//        num[n] = Integer.valueOf(str.substring(left, size)) ;

        int inddexL = 0;
        int indexR = 0;

        System.out.println("1 + 2 + 3 + -5 * -4 + 1");
    }
}

