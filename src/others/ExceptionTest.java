package others;

import java.util.Scanner;
/**
 * @Author Linton
 * @Date 2019/6/9 22:02
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class ExceptionTest {
    public static void main(String[] args) {


        while (true)  {
            Scanner in = new Scanner(System.in);
            int score = in.nextInt();

            CheckScore checkScore = new CheckScore();
            try {
                checkScore.check(score);

            } catch (ChaosException e) {
//                System.out.println("分数不合法");
                e.printStackTrace();
            }
            System.out.println("执行完毕");
        }
    }

}

