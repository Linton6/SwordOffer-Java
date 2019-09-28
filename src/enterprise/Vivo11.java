package enterprise;


/**
 * @Date 2019/9/22 16:08
 * @跳盒子游戏，约瑟夫环问题
 */
import java.util.*;
public class Vivo11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String str  = in.nextLine();
        String[] strings = str.split(" ");
        int len = strings.length;
        for (int i = 0; i < len; i++) {
            list.add(Integer.valueOf(strings[i]));
        }

    }

    private static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;

        if (len == 1) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < len) {
            if (i + arr[i] >= len - 1) {
                count++;
                return count;
            }

            int temp = Integer.MAX_VALUE;
            for (int k = i + 1; k < i + arr[i]; k++) {
                if (temp < k + arr[k]) {
                    temp = k + arr[k];
                    j = k;
                }
            }
            i = j;
            count++;
        }
        return -1;

    }
}

