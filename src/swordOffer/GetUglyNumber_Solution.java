package swordOffer;

/**
 * @Author Linton
 * @Date 2019/6/21 12:45
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description  暴力破解法
 */

public class GetUglyNumber_Solution {
    public static void main(String[] args){
        System.out.println(GetUglyNumber_Solution(11));
    }

    public static int GetUglyNumber_Solution(int index) {
        if(index < 0){
            return 0;
        }
        int count = 0;
        int i = 0;
        while(count < index){

            if(isUglyNum(i)){
                count++;
            }
            i++;

        }
        return --i;
    }

    public static boolean isUglyNum(int number) {
        if(number == 0){
            return false;
        }
        while(number % 2 == 0){
            number = number / 2;
        }
        while(number % 3 == 0){
            number = number / 3;
        }
        while(number % 5 == 0){
            number = number / 5;
        }
        return (number == 1)? true:false;
    }
}

