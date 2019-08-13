package enterprise;

/**
 * @Author Linton
 * @Date 2019/8/12 9:27
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

// 2019-8-12 10:26:54
import java.util.*;
public class MainT{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while(!in.hasNext("exit")){
            String str = in.nextLine();
            // 1.长度超过8位
            if(str.length() < 8) {
                list.add("NG");
                //  System.out.println("NG");
                continue;
            }
            // 2.包括大小写字母.数字.其它符号,以上四种至少三种
            int[] flag = new int[4];
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' ) {
                    flag[0] = 1;
                } else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' ) {
                    flag[1] = 1;
                } else if(str.charAt(i) >= '0' && str.charAt(i) <= '9' ) {
                    flag[2] = 1;
                } else {
                    flag[3] = 1;
                }
            }
            if(flag[0] + flag[1] + flag[2] + flag[3] < 3 ) {
                list.add("NG");
                // System.out.println("NG");
                continue;
            }
            // 3.不能有相同长度超2的子串重复
            boolean NG = false;
            for(int i = 0; i <= str.length() - 6; i++){
                for(int j = i + 3; j <= str.length() - 3; j++) {
                    if(str.charAt(i) == str.charAt(j) && str.charAt(i+1) == str.charAt(j+1)
                            &&  str.charAt(i+2) == str.charAt(j+2)){
                        NG = true;
                        // System.out.println("NG");

                    }
                }
            }
            if (NG) {
                list.add("NG");
                continue;
            }
            //    System.out.println("OK");
            list.add("OK");
        }
        for(String s : list){
            System.out.println(s);
        }
    }
}