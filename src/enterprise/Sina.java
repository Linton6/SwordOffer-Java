package enterprise;


import java.util.Arrays;

/**
 * @Date 2019/8/31 16:21
 * @
 */

public class Sina {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);//正负21.4亿
        String[] list = {"3","4.3.5.4", "2.10.3", "2.4"};
        System.out.println(IN(list));
        System.out.println('a'+"");

    }

    private static String IN(String[] list){
        int size = list.length;
        Arrays.sort(list);
        int min = 0;
        String[] s = new String[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            String[] strs = list[i].split("\\.");
            int len = strs.length;
            for (int j = 0; j < len; j++) {
                if (Integer.valueOf(strs[j]) > 9) {
                    int n = Integer.valueOf(strs[j]) - Integer.valueOf("9");
                    int num = 96 + n;
                    char c = (char)Integer.parseInt(String.valueOf(num));
                    strs[j] = c+"";
                }
            }
            s[k] = "";
            for (int h = 0;h < len;h++) {
                s[k] += strs[h];
            }
            k++;
        }
        Arrays.sort(s);

        return s[0];
    }
}

