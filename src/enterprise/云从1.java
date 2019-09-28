package enterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Date 2019/9/24 20:03
 * @
 */

public class 云从1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int candies = in.nextInt();
        int num = in.nextInt();
        ArrayList<Integer> list = solution(candies, num);
        int size = list.size();
        System.out.print("[");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.print(list.get(size - 1));
        System.out.print("]");


    }
// list.stream().mapToInt(Integer::intValue).toArray();
    private static ArrayList<Integer> solution(int candies, int num_people) {
        if (candies <= 0 || num_people <= 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (num_people >= candies)  {
            for (int i = 1; i <= candies; i++) {
                list.add(i);
            }
            return list;
        }

        int sum = 0;
        int mul = 0;
        while (candies > sum) {
            for (int i = 1 + mul * num_people ; i <= num_people + mul * num_people; i++) {
                sum += i;
                if (sum == candies ){
                    return list;
                } else if (sum > candies) {
                    int temp = candies - sum + i;
                    list.add(temp);
                    return list;
                } else {
                    list.add(i);
                }
            }
            mul++;

        }
        return list;



    }
}

