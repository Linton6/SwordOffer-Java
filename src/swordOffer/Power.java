package swordOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {

    public static void main(String[] args) {
        System.out.println(Power(0, -8));

    }

    public static double Power(double base, int exponent) {
        double a = base;
        if (exponent > 0) {
            for (int i = 0; i < exponent - 1; i++) {
                base = base * a;
//            base *= a;
            }

        } else if (exponent == 0) {
            return 1;
        } else {
            exponent = Math.abs(exponent);
            for (int i = 0; i < exponent - 1; i++) {
                base = base * a;
//            base *= a;
            }
            if (base == 0) {
                System.out.println("base不能为0");
                return -1;
            }
            base = 1 / base;
        }
        return base;
    }
}
