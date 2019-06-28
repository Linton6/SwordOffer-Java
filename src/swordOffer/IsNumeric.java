package swordOffer;

/**
 * @Author Linton
 * @Date 2019/6/28 10:49
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2",
 * "-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */

public class IsNumeric {
    public static void main(String[] a){
        boolean aa =new IsNumeric().isNumeric("12e+3.4".toCharArray());
        System.out.println(aa);
    }

    static  int a = 0;
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0) {
            return false;
        }
        int  strIndex = 0;
        int size = str.length;
        boolean num = false;
        num = scanInteger(str, 0);
        strIndex = IsNumeric.a;
        if(strIndex < size) {
            // 出现 ‘.’
            if (str[strIndex] == '.') {
                // 233.  .56   3.45 三种情况
                num = scanUnsignedInteger(str, ++strIndex) || num;
                if (a < size && str[a] == '.')
                    return false;
            }
            // 出现 eE
            if (a < size && (str[a] == 'e' || str[a] == 'E')) {
                if (a + 1 >= size)
                    return false;
                num = scanInteger(str, ++a) && num;
                if ( a < size && str[a] == '.')
                    return false;
            } else if (a < size){
                return false;
            }
        }
        return num;
    }

    // 判断带符号数
    public boolean scanInteger(char[] str , int strIndex) {
        if((str[strIndex] == '+' || str[strIndex] == '-')) {
            ++strIndex;
        }
        if(strIndex >= str.length) {
            return false;
        }
        return scanUnsignedInteger(str, strIndex);
    }
    // 判断无符号数
    public boolean scanUnsignedInteger(char[] str, int strIndex) {
        int s = strIndex;
        while(strIndex < str.length &&(str[strIndex] == '0' || str[strIndex] == '1'
                || str[strIndex] == '2'|| str[strIndex] == '3'|| str[strIndex] == '4'
                || str[strIndex] == '5'|| str[strIndex] == '6'|| str[strIndex] == '7'
                || str[strIndex] == '8'|| str[strIndex] == '9'
        ) ) {
            ++strIndex;
        }
        // 返回去一个数
        a = strIndex;

        return s < strIndex;
    }
}

