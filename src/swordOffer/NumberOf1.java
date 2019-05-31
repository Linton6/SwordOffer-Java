package swordOffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(-15));
        System.out.println(Integer.toBinaryString(-15));

    }

    public static int NumberOf1(int n) {
        int b = 0;
        String a = Integer.toBinaryString(n);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 49) {
                b++;
            }
         }
        return b;
    }

    /**
     * 求整数的补码
     *
     * @param value
     */
    public static void getNum(int value) {
        for (int i = 0; i < 32; i++) {
            int t = (value & 0x80000000 >>> i) >>> (31 - i);
            System.out.print(t);
        }
    }

}
