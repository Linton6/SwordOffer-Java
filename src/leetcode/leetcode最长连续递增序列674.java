package leetcode;

import java.sql.ResultSet;
import java.util.Arrays;

/**
 * @Date 2019/9/14 17:22
 * @
 */

public class leetcode最长连续递增序列674 {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {10,9,2,5,3,4};
        System.out.println(findLengthOfLCIS(arr));
        Arrays.fill(arr, 1);
        arr.wait();
    }


    // 2019-9-15 09:26:15  最长连续递增序列674
    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int temp = 1;
        int max = 1;
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                temp++;
                if (max < temp) {
                    right = i + 1;
                    max = temp;
                    left = right - max + 1;

                }

            } else {
                temp = 1;
            }
        }

        for (int i = left ; i <= right; i++) {
            System.out.print(nums[i] + " ");
        }
        return max;
    }


}

