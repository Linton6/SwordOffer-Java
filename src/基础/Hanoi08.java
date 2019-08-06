package 基础;

/**
 * @Author Linton
 * @Date 2019/8/4 14:35
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  汉诺塔
 */

public class Hanoi08 {
    public static void main(String[] args) {
       doTower(5, "左", "中", "右");

    }
    /** @汉诺塔问题*/
    private static void doTower(int n, String from, String mid, String to){
        if (n > 0) {
            if(n == 1) {
                System.out.println("Disk 1 from " + from + " to " + to);
            } else {
                doTower(n - 1, from, to, mid );
                System.out.println("Disk " + n + " from " + from + " to " + to);
                doTower(n - 1, mid, from, to);
            }
        }
    }
}

