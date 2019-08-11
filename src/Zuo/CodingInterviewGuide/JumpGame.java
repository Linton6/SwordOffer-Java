package Zuo.CodingInterviewGuide;

/**
 * @Author Linton
 * @Date 2019/8/10 17:27
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  跳跃游戏
 */

public class JumpGame {


    /**
     * 跳跃游戏
     * 2019-8-10 17:29:10
     */
    private static void jumpGame(int[] arr) {
        int jump = 0;  // 跳了多少步
        int cur = 0;  //  只跳jump步，最远的位置
        int next = 0; //  再多多跳一步最远的位置
        for (int i = 0; i < arr.length; i++) {
            if (cur < i){
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        System.out.println(jump);
    }
}

