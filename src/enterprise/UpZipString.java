package enterprise;

/**
 * @Author Linton
 * @Date 2019/7/10 21:46
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 *     编程：字符串的解压。
 *     Input：3%abc#
 *     Output：abcabcabc
 *     其中%和#可以内部嵌套
 *
 *
 */

public class UpZipString {
    public static void main(String[] args) {
        UpZipString u = new UpZipString();
        String s = "3%abc#";
        System.out.println(u.upZipString(s)); // 我写的这段代码 鲁棒性太差了

    }

    String upZipString (String str) {
        // 非法输入
        if (str == null || str.length() == 0){
            return "";
        }
        StringBuffer s = new StringBuffer();
//        char[] chars = str.toCharArray();
        int num = 0;
        int start = 0;
        int end = 0;
        int size = str.length();
        for (int i = 0; i < size;i++){
            if(str.charAt(i) == '%'){
                num = Character.getNumericValue(str.charAt(i-1));
                start = i;
            }
            if (str.charAt(i) == '#'){
                end = i;
            }
        }
        String s2 = str.substring(start+1, end);
        String s1 = str.substring(0, start-1);
        String s3 = str.substring(end+1);
        s.append(s1);
        if (num >= 0) {
            for (int i = 0; i < num; i++) {
                s.append(s2);
            }
        }
        s.append(s3);
        String string = s.toString();

        return string;

    }

}

