package swordOffer;

/**
 * @Author Linton
 * @Date 2019/6/21 16:37
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */


public class InversePairs {
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }

        int size = array.length;
        int P = 0;
        for(int i = 0; i < size; i++){
            int n = array[i];
            for(int j = i+1; j < size; j++) {
                if(n > array[j]){
                    P++;
                }
            }
        }
        P = P % 1000000007;
        return P;
    }
}
