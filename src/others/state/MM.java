package others.state;

import others.command.Command;
import others.command.HugCommand;
import others.command.ShoppingCommand;

/**
 * @Author Linton
 * @Date 2019/7/8 8:48
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class MM {
    private String name;
    private MMState state = new MMHappyState();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void smile(){
        state.smile();

    }

    public void cry(){
        state.cty();
    }

    public void say() {
        state.say();
    }


}

