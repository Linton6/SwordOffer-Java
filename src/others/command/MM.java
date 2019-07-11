package others.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Linton
 * @Date 2019/7/8 8:48
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class MM {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void order(Boy b) {
        b.dosomething();
        Command c1 = new ShoppingCommand();
        b.addCommand(c1);
        Command c2 = new HugCommand();
        b.addCommand(c2);
        b.executeCommand();
    }
}

