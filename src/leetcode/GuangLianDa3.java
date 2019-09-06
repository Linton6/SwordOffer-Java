package leetcode;

/**
 * @Date 2019/8/19 15:53
 * @
 */


public class GuangLianDa3 {

    public static void main(String[] args) {
        System.out.println(area1(1000));

    }

    /**
     * 思路1
     * 判断第二
     */
    private static long area1(long R) {
        long a = R;
        long b = 0;
        long tb = b;
        long count = 0;
        for (a = R; a >= 0; a--) {
            while (a * a + b * b <= R * R)
                b++;  // 说明a和b 还在R的范围内
            b--;
            count += a * (b - tb); // 把重合的部分删除
            tb = b;
        }
        return count * 4;
    }

    /**
     * 思路2
     * 判断第二象限每个方格的右上角的点是否存在（即是否在R的范围内）时间复杂度（O(R平方))
     */
    private static long area2(long R) {
        long res = 0;
        for(int x = 1; x < R; x++) {
            for (int y = 1; y < R; y++) {
                double x2 = Math.sqrt(x*x+y*y);
                if ((double)R >= x2) {
                    res++;
                }
            }
        }
        return res * 4;
    }

}