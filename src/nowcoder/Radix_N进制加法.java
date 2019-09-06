package nowcoder;


/**
 * 2019-8-19 15:05:36
 * @实现36进制加法
 */
import java.util.*;

public class Radix_N进制加法 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String num_a = "zzz";
        String num_b = "2";
        char[] maxLenNums = num_a.length() >= num_b.length() ? num_a.toCharArray() : num_b.toCharArray();
        char[] minLenNums = num_a.length() < num_b.length() ? num_a.toCharArray() : num_b.toCharArray();
        Integer oneMore = 0;
        for (int index = 0; index < maxLenNums.length; index++) {
            Map<String, Integer> map = sum(value_10_from_36(maxLenNums[index]),
                    value_10_from_36(getChar(minLenNums, index)), oneMore);
            oneMore = map.get("flag");
            sb.insert(0, JZ_VALUE[map.get("result")]);
        }
        sb.insert(0, oneMore);
        System.out.println(sb);
    }

    private static char getChar(char[] nums, Integer index) {
        if (index < nums.length) {
            return nums[index];
        }
        return 0;
    }

    private static Map<String, Integer> sum(Integer a, Integer b, Integer oneMore) {
        return new HashMap<String, Integer>() {
            private static final long serialVersionUID = 1L;
            {
                put("result", (a + b + oneMore) % 36);
                put("flag", a + b + oneMore > 35 ? 1 : 0);
            }
        };
    }

    private static char[] JZ_VALUE = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    private static Integer value_10_from_36(char c) {
        for (int i = 0; i < JZ_VALUE.length; i++) {
            if (JZ_VALUE[i] == c) {
                return i;
            }
        }
        return 0;
    }

}

