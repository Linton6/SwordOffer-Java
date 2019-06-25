package others;

/**
 * @Author Linton
 * @Date 2019/6/9 21:57
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class CheckScore {
    // 检查分数合法性的方法check()，如果定义的是运行时异常就不用抛出异常了
    public void check(int score) throws ChaosException{ // 抛出自己的异常类
        if (score > 120 || score < 0) {
            // 分数不合法时抛出异常
            throw new ChaosException("分数不合法，应该在0~120之间");

        } else {
            System.out.println("分数合法，你的分数是: " + score);
        }
        System.out.println("加油！");

    }
}

