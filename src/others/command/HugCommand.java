package others.command;

/**
 * @Author Linton
 * @Date 2019/7/8 9:33
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class HugCommand extends Command {
    @Override
    public void execute() {
        System.out.println("Hug");
    }

    @Override
    public void unDo() {
        System.out.println("Open your arms");

    }
}

