package enterprise;


/**
 * @Author Linton
 * @Date 2019/8/10 19:51
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.Scanner;
public class HeightRace {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[n];
            int i = 0;
            for (String s : strs){
                arr[i++] = Integer.valueOf(s);
            }
            race(arr);
        }


        private static void race(int[] arr) {
            int size = arr.length;
            int res = 0;
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if ( (arr[i] <= arr[j] && arr[i] >= 0.9 * arr[j]) || ( arr[i] >= arr[j] && arr[j] >= arr[i] * 0.9)){
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }