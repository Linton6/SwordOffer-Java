package enterprise;

import java.util.*;

/**
 * @Date 2019/9/1 15:43
 * @扑克游戏
 */

public class TT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n1 = in.nextLine();
        int N = Integer.valueOf(n1);
        String[] strs = new String[N*2];
        for (int i = 0; i < N* 2; i++) {
            strs[i] = in.nextLine();
            strs[++i] = in.nextLine();
        }

        for (int i = 0; i < N * 2; i++){
            tran(strs[i],strs[++i]);
        }

    }

    private static ArrayList<String> tran( String str1, String str2){
        int len = str1.length();
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        per(len, list,sb);
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder(str1);


        int size = list.size();
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            int length = str.length();

            for (int j = 0; j < length; j++){
                if (str.charAt(j) == 'd'){
                    sb1.setCharAt(j,'a');
                } else if (str.charAt(j) == 'r' ){
                    sb1.append(sb1.charAt(j));
                    sb1.setCharAt(j,'a');
                }
            }

            String s = sb1.toString().replace("a","");
            if (!s.equals(str2)){
                res.add(list.get(i));
            }
        }

        return res;

    }
    // 得到所有的策略
    private static void per(int len, ArrayList<String> list , StringBuilder s  ) {
        if (len == 0) {
            list.add(s.toString());
            return;

        }
// 无法区分多种情况
        if (len > 0) {
            s.append('d');
            per(len - 1, list, s);
        }
        if (len > 0) {
            s.append('l');
            per(len - 1, list, s);
        }
        if (len > 0) {
            s.append('r');
            per(len - 1, list, s);
        }
    }
}

