package enterprise;

/**
 * @Date 2019/8/24 20:11
 * @
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class JD1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner in = new Scanner(System.in);
        String n =br.readLine();
        String str = br.readLine();
        String[] strs = str.split(" ");
        int size = strs.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        System.out.println(sing(arr));

    }
    private static int sing(int[] arr) {
        if (arr.length == 2) {
            return 2;
        }
        int size = arr.length;
        int count = 1;
        for (int i = 0; i < size; i++) {
            int len1 = i + 1;
            int len2 = size - 1 - i;
            int[] arr1 = new int[len1];
            int[] arr2 = new int[len2];

            for (int j = 0; j < len1; j++){
                arr1[j] = arr[j ];
            }
            for (int k = 0; k < len2; k++) {
                arr2[k] = arr[i + 1 + k];
            }
           Arrays.sort(arr1);
           Arrays.sort(arr2);
            int max =arr1[len1 - 1];
            if (arr2.length > 0) {
                int min =arr2[0];
                if (min >= max) {
                    count++;
                }
            }

        }
        return count;
    }
}

