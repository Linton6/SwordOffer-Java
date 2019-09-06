package newSwordOffer;

/**
 * @Date 2019/8/24 15:21
 * @
 */

public class 最大公约数 {
    public static void main(String[] args) {
        System.out.println(gongyue(24,60));

    }

    /**
     * 2019-8-24 15:22:07
     */
    private static long gongyue(long a, long b) {
        if (b == 0) {
            return a;
        }
        else{
            return gongyue(b, a % b);
        }
    }

}

