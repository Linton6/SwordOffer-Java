package newSwordOffer;

/**
 * @Date 2019/8/25 20:28
 * @
 */
public class 最小公约数 {
//    public static void main(String[] args) {
//        // 乌鸦喝水
//        System.out.println(dicimalToFraction(drink(5)));
//    }
        public static double  drink(double n) {
            if (n == 1)
                return 1;
            if (n == 2)
                return  3d/2d;
            double son = 0;
            double b = 3d/2d;
            double res = 0;
            for (int i = 3; i <= n; i++) {
                son = Math.pow(2,i-1);
                res = b + 1/son;
                b = res;
            }
            return res;
        }
        // 小数点转化为分数
    public static String dicimalToFraction(double num){
        int count = 0;
        int base = 10;
        while(num != Math.floor(num)){
            num *= base;
            count++;
        }

        base = (int)Math.pow(base,count);
        int nor = (int)num;
        int gcd = findGCD(nor, base);
        return String.valueOf(nor/gcd) + "/" + String.valueOf(base/gcd);
    }
    //求最大公约数
    private static int findGCD(int a, int b){
        if(a == 0){
            return b;
        }
        return findGCD(b%a, a);
    }
    // 求最大公约数 非递归 辗转相除法
    private static int find(int x, int y){
            int max = 0;
            int min = 0;
            int tmp = 0;
            max = Math.max(x,y);
            min = Math.min(x,y);
            while (max % min != 0) {
                tmp = max % min;
                max = Math.max(min,tmp);
                min = Math.min(min,tmp);
            }
            return min;
    }

    /**
     * 最小公倍数其实只要一个公式，即整数A和整数B的最小公倍数为A*B/gcd(A,B)（gcd(A,B)为A和B的最大公约数）
     */

    public static void main(String[] args) {
        System.out.println(find(12,16));
    }


}

