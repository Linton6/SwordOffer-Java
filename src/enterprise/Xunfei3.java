package enterprise;

/**
 * @Author Linton
 * @Date 2019/8/16 19:21
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

import java.util.Arrays;
import java.util.Scanner;
public class Xunfei3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String  str = in.nextLine();
            String s = transfer(str);
            System.out.println(s);
        }
    }
    private static String transfer(String str){
        if (str ==null || str.length() == 0){
            return "-1";
        }
        int size = str.length();
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < size; i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                strb.append(str.charAt(i));
            }
        }
        int len = strb.length();
        if (len == 0){
            return "-1";
        }
        int[] arr = new int[len];
        for (int j = 0; j < len ;j++) {
            arr[j] = (int) (strb.charAt(j) - '0');
        }
        Arrays.sort(arr);
        strb.delete(0,len);
        for (int i = 0; i < len; i++) {
            strb.append(String.valueOf(arr[i]));
        }
        return strb.toString();
    }
}
