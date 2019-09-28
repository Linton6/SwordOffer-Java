package enterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Date 2019/9/9 19:50
 * @最长子数组
 */

public class DongFangcaifu {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();



        int[] arr = {1 ,7 ,2 ,4 ,5, 3};
        findLengthOfLCIS(arr);

    }
    public static void findLengthOfLCIS(int[] nums) {

        if(nums.length == 0)
            return ;

        int max = 0;
        int num = 1;
        ArrayList<Integer> listMax = new ArrayList<>();
        ArrayList<Integer> listIndex = new ArrayList<>();

        int len = nums.length;

        for(int i=0; i < len -1; i++){
            if(nums[i] < nums[i + 1]){
                num++;
            }else{
                if(max <= num){
                    max = num;
                    listMax.add(max);
                    listIndex.add(i);
                }
                num = 1;
            }
        }
        if (max < num) {
            max = num;
            listMax.add(max);
            listIndex.add(len - max);
        }
     //   max = Math.max(num,max);
        int size = listMax.size();
        for (int i = 0; i < size; i++) {
            if (max == listMax.get(i)){
                int k = listIndex.get(i);
                for (int j = 0; j < max; j++) {
                    System.out.print(nums[k++] + " ");
                }

            }
        }

    }

}

