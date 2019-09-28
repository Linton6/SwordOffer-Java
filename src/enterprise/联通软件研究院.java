package enterprise;


import java.util.*;

/**
 * @Date 2019/9/16 20:48
 * @
 */

public class 联通软件研究院 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num = in.nextDouble();
        double sum = in.nextDouble();
        double res = check(num, sum);
        System.out.println(res + " " + sb.toString());

    }

    static Map<Double, Integer> map = new HashMap<>();
     static StringBuilder sb = new StringBuilder();
    private static double check(double count, double sum) {

        double res = sum - count;
        while (res >= 1) {
            if(res >= 10) {
                int n1 =(int) res / 10;
                res = res % 10;
                map.put(10d,n1);
            }

            if (res >= 5) {
                int n1 =(int) res / 5;
                res = res % 5;
                map.put(5d,n1);
            }
            if (res >= 1) {
                int n1 =(int) res ;
                res = res % 1;
                map.put(1d,n1);
            }
        }
        if (res >= 0.5) {
            map.put(0.5,1);
        }
        if (res - 0.5 > 0) {
            map.put(0.1, (int) ((res - 0.5)*10));
        }


        if (map.containsKey(10d)) {
            sb.append("10:"+map.get(10d) + ";");
        }
        if (map.containsKey(5d)) {
            sb.append("5:"+map.get(5d) + ";");
        }
        if (map.containsKey(1d)) {
            sb.append("1:"+map.get(1d) + ";");
        }
        if (map.containsKey(0.5d)) {
            sb.append("0.5:"+map.get(0.5d) + ";");
        }
        if (map.containsKey(0.1d)) {
            sb.append("0.1:"+map.get(0.1d) + ";");
        }

        return sum - count;

    }

}

