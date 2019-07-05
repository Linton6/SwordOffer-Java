package others;

/**
 * @Author Linton
 * @Date 2019/6/30 19:37
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 字节跳动 笔试题  1995-05-20
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        Scanner sc1 = new Scanner(System.in);
        String[] strings = new String[num];
//        for (int i = 0; i < num; i++){
            String n = sc1.nextLine();
            strings[0] = n;
        String n1 = sc1.nextLine();
        strings[1] = n1;
//        }
        for (int i = 0; i < num; i++){
            daysCount(strings[i]);
        }

    }
    //
    public static void daysCount(String  n){
        int year = Integer.valueOf(n.substring(0, 4));
        int month = Integer.valueOf(n.substring(5, 7));
        int day = Integer.valueOf(n.substring(8));
        int days = 18*365;

        if (judge(year)) {
            // TODO
            if (judge(month, day) == 0){
                System.out.println(-1);
            } else{
                days++;
                for (int i = 0; i < 18; i++) {
                    year = year + 1;
                    if (judge(year)){
                        days = days + 1;
                    }
                }
                if (judge(month , day) <=1 && judge(year)){
                    days--;
                }
                System.out.println(days);
            }
        } else {
            for (int i = 0; i < 18; i++) {
                year = year + 1;
                if (judge(year)){
                    days = days + 1;
                }
            }
            if (judge(month , day) <=1 && judge(year)){
                days--;
            }
            System.out.println(days);
        }
    }

    // 判断是否是闰年
    public static boolean judge(int yeear) {
        if ((yeear % 4 == 0 && yeear % 100 != 0) || (yeear % 100 == 0 && yeear % 400 == 0)) {
            return true;
        }
        return false;
    }
    // 判断是否是闰月
    public static int judge(int month, int day){
        if (month == 2 && day == 29) {
            return 0;
        }else if (month > 2){
            return 1;
        } else {
            return -1;
        }
    }
}