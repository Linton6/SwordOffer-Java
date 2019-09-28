package newSwordOffer;

/**
 * @Date 2019/8/30 20:00
 * @
 */
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;
public class ALI {
    static int[] getIndexAndLongest(String users,int n) {
        int len = users.length();
        int index = 0;
        int[] res = new int[2];
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (users.charAt(i) == 'b') {
                int t = i;
                int k = i;
                int l = 0;
                while (--t >= 0) {
                    if (users.charAt(t) == 'g'){
                        l++;
                    } else {
                        break;
                    }
                    if (t == 0) {
                        t = len - 1;
                    }
                }
                while (++k < len) {
                    if (users.charAt(k) == 'g') {
                        l++;
                    } else {
                        break;
                    }
                    if (l == len - 1) {
                        l = 0;
                    }
                }

                if (max < l) {
                    index = i;
                    max = l;
                }
            }
        }
        res[0] = index;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (users.charAt(i) == 'g') {
                count++;
            }
        }
        int[] arr = new int[count];
        ///////////////////////////////////////////////////////////////
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            if (users.charAt(i) == 'g') {
                while (users.charAt(i++) == 'b') {
                    arr[tmp]++;
                }
                tmp++;
                i--;
            }
        }
        int maxValue = 0;
        for (int i = 0;  i < count - n; i++) {
            maxValue = Math.max(maxValue,arr[i]+arr[i+1] + arr[i+2]);
        }

        return res;



    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int k = in.nextInt();
        int[] arr = getIndexAndLongest(str,k);
        System.out.println(arr[0] + " " +arr[1]);

    }
}

