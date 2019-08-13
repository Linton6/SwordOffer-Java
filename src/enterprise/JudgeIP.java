package enterprise;

import javafx.util.converter.BigIntegerStringConverter;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/8/11 13:17
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class JudgeIP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;
        int P = 0;
        int Error = 0;
        int n = 4;
        while (n > 0) {
            String[] str = new String[1];
            str[0] = in.nextLine();
            count2(str, A, B , C, D, E, P, Error);
//            System.out.println("1");
            n--;
        }
        System.out.println(A + " " + B + " "+ C + " "+ D +" " + E + " " + P );
    }

    /**
     * 识别邮箱的IP地址和掩码并进行分类统计
     * 2019-8-11 13:00:43   合法的智子网掩码，按位取反，加1后，二进制中，只有一个1
     */
    private static void count2(String[] strs, int A,int B, int C,int D, int E ,int P, int Error) {
        int size = strs.length;
        for (int j = 0; j < size; j++) {
            String str = strs[j]; // 一个Str就是一行字符串
            String[] strIPs = str.split("~");  //
            String[] ipS = strIPs[0].split("\\.");  // ipS就是IP数字的集合
            String[] maskS = strIPs[1].split("\\.");  // masks就是掩码数字的集合
            if ( ipS.length == 4 &&  maskS.length == 4) {
                // 判断 四个数的范围
                for (int i = 0; i < 4; i++) {
                    if (Integer.valueOf(ipS[0]) < 127 && Integer.valueOf(ipS[0]) >= 1 && IsMask(maskS) ){
                        A++;
                    } else if (Integer.valueOf(ipS[0]) < 192 && Integer.valueOf(ipS[0]) >= 128 && IsMask(maskS)){
                        B++;
                    }else if (Integer.valueOf(ipS[0]) < 224 && Integer.valueOf(ipS[0]) >= 192 && IsMask(maskS)){
                        C++;
                    }else if (Integer.valueOf(ipS[0]) < 240 && Integer.valueOf(ipS[0]) >= 224 && IsMask(maskS)){
                        D++;
                    }else if (Integer.valueOf(ipS[0]) < 256 && Integer.valueOf(ipS[0]) >= 240 && IsMask(maskS)){
                        E++;
                    } else {
                        Error++;
                    }
                    // 私网范围
                    if (IsPrivate(ipS) && IsMask(maskS) ) {
                        P++;
                    }
                }
            }
        }
    }


    // 判断是否是私网
    private static boolean IsPrivate(String[] priva){
        if ((Integer.valueOf(priva[0]) >= 10 && Integer.valueOf(priva[0]) < 11 )
            || (Integer.valueOf(priva[0])  == 172 && (Integer.valueOf(priva[1]) >= 16 && Integer.valueOf(priva[1]) < 32))
             ||    (Integer.valueOf(priva[0]) == 192 && Integer.valueOf(priva[1]) == 168 && Integer.valueOf(priva[2]) >= 0 && Integer.valueOf(priva[2]) < 256 ) ) {
                return true;
        }
        return false;
    }
    // 判断子网掩码是否正确
    private static boolean IsMask(String[] mask) {
        String m = "";
        int size = mask.length;
        for (int i = 0; i < size; i++) {
             m += Integer.toBinaryString(Integer.valueOf(mask[i]));
        }
        int length = m.length();
        String ss = "";
        for (int i = 0; i < length; i++) {
            if (m.charAt(i) == '1'){
                ss += "0";
            } else {
                ss += '1';
            }
        }
        long ll = Long.valueOf(ss, 2);
        ll =ll + 1;
        int n = Long.bitCount(ll);
        return n == 1;
    }
}

