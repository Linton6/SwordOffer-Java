package others.state;

import others.Bridge.Gift;
import others.Bridge.Ring;
import others.command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Linton
 * @Date 2019/7/8 8:48
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Boy {
    private String name;
    private List<Command> commands = new ArrayList<Command>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void purse(MM mm) {
        Gift g = new Ring();
         give(g, mm);
    }

    public void  give(Gift g, MM mm) {

    }

    public void dosomething(){

    }

    public void addCommand(Command c1) {
        this.commands.add(c1);
    }

    public void executeCommand() {
        for (Command c : commands){
            c.execute();
        }
    }

    public void  undoCommand(){
        // 用栈实现
    }
}

