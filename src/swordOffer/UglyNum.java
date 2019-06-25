package swordOffer;

/**
 * @Author Linton
 * @Date 2019/6/21 15:25
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class UglyNum {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int i = 1;
        int x2 = 1;
        int x3 = 1;
        int x5 = 1;
        int[] arr = new int[index+2];
        arr[0] = 0;
        arr[1] = 1;

        while(i < index+1){
            int min = min(arr[x2]*2, arr[x3]*3, arr[x5]*5);

            if(arr[x2] * 2 == min){
                x2++;
            }
            if(arr[x3] * 3 == min){
                x3++;
            }
            if(arr[x5] * 5 == min){
                x5++;
            }
            arr[++i] = min;
        }
        return arr[index];
    }

    public int min(int x, int y, int z){
        int k = x < y ? x : y;
        return k > z ? z : k;
    }
}
