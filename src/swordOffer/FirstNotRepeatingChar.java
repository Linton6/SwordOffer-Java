package swordOffer;

/**
 * @Author Linton
 * @Date 2019/6/21 16:19
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str == null) {
            return -1;
        }
        int size = str.length();
        int num = -1;
        boolean flag = false;
        for(int i = 0; i < size; i++) {
            flag = true;
            char n = str.charAt(i);
            for(int j = 0; j < size; j++){
                if(n == str.charAt(j) && i != j){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return num;

    }
}
