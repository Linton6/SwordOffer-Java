package enterprise;

import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/5 17:26
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  牛客网企业题 - 安置路灯
 */

public class Placelamp {
    public static void main(String[] args) {
//        System.out.println(lamp("...XX....XX"));
//        Scanner in = new Scanner(System.in);
//        int  t = in.nextInt();
//        in.nextLine();
//        String[] strings = new String[t];
//        int k = 0;
//        while (t > 0){
//            int n = in.nextInt();
//            in.nextLine();
//            String str = in.nextLine();
//            strings[k++] = str;
//            t--;
//        }
//        for (String s : strings) {
//            System.out.println(lamp(s));
//        }
        System.out.println(lamp("X"));
    }

    private static int lamp(String str) {
        if (str == null || str.length() == 0) return 0;
//        if (str.length() <= 3) return 1;
        int size = str.length();
        int count = 0;
        int j = 0;
        for (int i = 0; i < size; i = i + j) {
            if ('.' == (str.charAt(i))) {
                count++;
                j =  3;
            } else {
                j = 1;
            }

            /** @处理最后的两个字符
             * @把自己绕进去了，这部分就不该要
             */

//            if (i + 3  >=  size) {
//                if (i + 1 == size) continue;
//                if (i + 2 == size){
//                    if ('.' == (str.charAt(i + 1))){
//                        count++;
//                        continue;
//                    }
//                }
//                if (i + 3 == size){
//                    if ('.' == (str.charAt(i + 1)) || '.' == (str.charAt(i + 2))) {
//                        count++;
//                    }
//                }
//            }

        }
        return count;
    }
}

