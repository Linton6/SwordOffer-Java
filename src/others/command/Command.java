package others.command;

/**
 * @Author Linton
 * @Date 2019/7/8 9:28
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  Command模式 实现 Undo操作,历史记录
 */

public abstract class Command {
    public abstract void execute();

    public abstract void unDo();
}

