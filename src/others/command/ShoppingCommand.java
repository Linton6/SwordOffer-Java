package others.command;

/**
 * @Author Linton
 * @Date 2019/7/8 9:33
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class ShoppingCommand extends Command {
    @Override
    public void execute() {
        System.out.println("zoo");
    }

    @Override
    public void unDo() {
        System.out.println("undo zoo");

    }
}

