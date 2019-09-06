package enterprise;


/**
 * @Date 2019/8/25 17:28
 * @
 */
import java.util.Scanner;

public class Kua {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(insertString(str1, str2));
    }
    private static String insertString(String arr1, String arr2) {
         arr1 = arr1.replace(" ", "");
         arr2 = arr2.replace(" ", "");
        StringBuilder str1 = new StringBuilder(arr1);
        int size2 = arr2.length();
        int j = 0;
        for (int i = 4; i < str1.length(); i += 5) {
            if (j < size2){
                str1.insert(i,arr2.charAt(j++));
            }else {
                break;
            }
        }
        if (j < size2) {
            String s = arr2.substring(j); // 可能会有问题
            str1.append(s);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            sb.append(str1.charAt(i));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

