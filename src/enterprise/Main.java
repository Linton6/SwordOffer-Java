package enterprise;



/**
 * @Author Linton
 * @Date 2019/8/7 20:27
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0 ) {
            String s = in.nextLine();
            list.add((Integer.valueOf(String.valueOf(s.charAt(0)))));
            list.add((Integer.valueOf(String.valueOf(s.charAt(2)))));
            n--;
        }
        merge(list);
    }

    /**
     * h合并表记录
     * 2019-8-8 10:36:58
     */

    private static void merge (ArrayList<Integer> list) {
        /**
         * 优秀题解
         */
//        public class Main {
//            public static void main(String[] args) {
//                Scanner sc = new Scanner(System.in);
//                while (sc.hasNext()) {
//                    Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
//                    int n = sc.nextInt();
//                    for (int i = 0; i < n; i++) {
//                        int s = sc.nextInt();  // 空格分隔
//                        int value = sc.nextInt();
//                        if (map.containsKey(s)) {
//                            map.put(s, map.get(s) + value);
//                        } else
//                            map.put(s, value);
//                    }
//                    for (Integer key : map.keySet()) {
//                        System.out.println(key + " " + map.get(key));
//                    }
//                }
//            }
//        }
        /**
         * 自己的挫方法
         */
        int size = list.size();
        int num = 0 ;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < size; i += 2) {
            if (treeMap.containsKey(list.get(i))){
                continue;
            }
            for ( int j = i; j < size && list.get(i).equals(list.get(j)); j += 2 ){
                num += list.get(j + 1);
            }
            treeMap.put(list.get(i), num);
            num = 0;
        }
        // 遍历TreeMap
//        Iterator it = treeMap.entrySet().iterator();
//        int key;int value;
//        while (it.hasNext()) {
//            Map.Entry entry  = (Map.Entry)it.next();
//            key = (int) entry.getKey();
//            value = (int) entry.getValue();
//            System.out.println(key + " " + value);  这个遍历方式简直蠢到极致
//        }
        for (Integer key : treeMap.keySet()){
            System.out.println(key + " " + treeMap.get(key));
        }
    }

    /**
     * 取近似值
     * 2019-8-7 22:58:37
     */
    private static int Approximate(double f){
        int f1 = (int)f;
        if (0.5000 >= f - f1) {
            return f1 + 1;
        }  else {
            return f1;
        }
    }

    /**
     * 质数因子
     * 2019-8-7 22:56:35
     */
    private String getResult(long ulDataInput ){
        return "";

    }

    /**
     * 进制转换
     * 2019-8-7 22:21:36
     */
    private static String transfer1(String str) {
        if (str == null || str.length() == 0) return "";
        int size = str.length();
        int num = 0;
        for (int i = size - 1; i > 1; i--) {
            if (str.charAt(i) == 'A') {
//                num += 16 * (size - i) * 10;
                num += Math.pow(16,size - i - 1) * 10;
            } else if (str.charAt(i) == 'B') {
                num += Math.pow(16,size - i - 1)  * 11;
            }else if (str.charAt(i) == 'C') {
                num += Math.pow(16,size - i - 1) * 12;
            }else if (str.charAt(i) == 'D') {
                num += Math.pow(16,size - i - 1) * 13;
            }else if (str.charAt(i) == 'E') {
                num += Math.pow(16,size - i - 1)* 14;
            }else if (str.charAt(i) == 'F') {
                num += Math.pow(16,size - i - 1)* 15;
            } else {
                num += Math.pow(16,size - i - 1) * ((int)str.charAt(i) - 48);
            }
        }
        return String.valueOf(num);
    }

    /**
     * 字符串分隔
     * 2019-8-7 21:32:24
     */
    private static ArrayList<String> transfer(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        int num = strs.length;
        ArrayList<String> list = new ArrayList<>();
        int k = 0;
        int size = 0;
        for (String str : strs) {
            size = str.length();
            k = 0;
            while (size > 8) {
                list.add(str.substring(k * 8, (k + 1) * 8));
                size -= 8;
                k++;
            }
            StringBuilder string = new StringBuilder(str.substring(str.length() - size));
            for (int j = size; j < 8; j++) {
                string.append('0');
            }
            list.add(string.toString());
        }
        return list;

    }



    /**
     * 计算字符串最后一个单词的长度
     * 2019-8-7 20:28:05
     */
    private static int count1(String string) {
        if (string == null || string.length() == 0) return 0;
        String[] strings = string.split(" ");
        String str = strings[strings.length - 1];
        return str.length();
    }
    /**
     * 计算字符个数
     * 2019-8-7 20:33:51
     */
    private static int count2(String str , char c){
        if (str == null || str.length() == 0 ) return 0;
        int res = 0;
        for (char s : str.toCharArray()) {
            if (s == c){
                res++;
            }
        }
        return res;
    }

    /**
     * 明明的随机数
     * 2019-8-7 20:39:26
     * 用快排
     */
//    Scanner sc = new Scanner(System.in);  用TreeSet岂不妙哉！
//        while(sc.hasNext()){
//
//        int num = sc.nextInt();
//        TreeSet<Integer> set = new TreeSet<Integer>();
//        for(int i = 0 ; i < num ;i++){
//            int curr = sc.nextInt();
//            set.add(curr);
//        }
//        for(Integer i : set){
//            System.out.println(i);
//        }
//    }
    private static int[] quick(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Set<Integer> set = new HashSet<>();
        for (Integer i : arr) {
            set.add(i);
        }
        int[] array = set.stream().mapToInt(Integer::intValue).toArray();
        partition(array, 0, array.length - 1);
        return array;

    }

    private static void partition(int[] arr , int left, int right) {
        if (left >= right)
            return;
        int i = left;
        int j = right;
        int pivot = arr[left];
        while (i < j) {
            while (i < j && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = pivot;

        partition(arr, left, i - 1);
        partition(arr, i + 1, right);
    }
}

