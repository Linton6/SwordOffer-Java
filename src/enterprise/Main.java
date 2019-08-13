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
//        Scanner in = new Scanner(System.in);
////        int n = in.nextInt();
//
//        while (in.hasNext()) {
//            String n1 = in.nextLine();
//            BuddyChar(n1);
//        }
        GradeSort();
    }

    /**
     * 成绩排序
     * 2019-8-13 16:58:14
     */
    private static void GradeSort(){
        Scanner in = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        PriorityQueue<Student> Heap = new PriorityQueue<>();
        int a = 0;
        while (!in.hasNext("exit")) {
            String n = in.nextLine();
            String select = in.nextLine();
            int type = Integer.valueOf(select);
            if (type == 1){
                Heap = new PriorityQueue<>(new MinComparator());
            } else {
                Heap = new PriorityQueue<>(new MaxComparator());
            }
//            Student student = new Student() ;
            for (int i = 0; i < Integer.valueOf(n); i++) {
                String str =  in.nextLine();
                String[] strs = str.split(" ");
                int grade = Integer.valueOf(strs[1]);
                Student student = new Student(strs[0], grade);
                Heap.add(student);
            }
        }
        int n = Heap.size();
        for (int i = 0; i < n; i++){
           Student student =  Heap.poll();
            System.out.println(student.Name + " " + student.grade);
        }
    }


   static class MinComparator implements Comparator<Student> { // 从小到大

        @Override
        public int compare(Student o1, Student o2) {
            return o1.grade - o2.grade;
        }
    }
  static   class MaxComparator implements Comparator<Student> { // 从大到小

        @Override
        public int compare(Student o1, Student o2) {
            return o2.grade - o1.grade;
        }
    }
   static class Student{
        private String Name;
        private int grade;

        Student(String Name, int grade) {
            this.Name = Name;
            this.grade = grade;
        }
        Student(){}

    }

    /**
     * 兄弟单词
     * 2019-8-13 15:40:17
     */
    private static void BuddyChar(String str) {
        String[] strs = str.split(" ");
        ArrayList<String> list = new ArrayList<>();
        int size = strs.length;
        String word = strs[size - 2];


        int num = Integer.valueOf(strs[size - 1]);
        int count = 0;
        ArrayList<Integer> flag = new ArrayList<>();
        String string = "";
        int len = size - 2;
        for (int i = 1; i < len; i++) {  // 找出相同单词的下标
            if (strs[i].equals(word)){
                flag.add(i);
            }
        }
        char[] w =word.toCharArray();
        Arrays.sort(w);
        word = Arrays.toString(w);
        for (int i = 1; i < len; i++) {
            if (flag.contains(i)) {
                continue;
            }
            char[] chas = strs[i].toCharArray();
            Arrays.sort(chas);

            if (word.equals(Arrays.toString(chas))){
                list.add(strs[i]);
            }
        }
        count = list.size();
        if (list.size() == 0 || list.size() < num - 1) {
            System.out.println(list.size());
            return;
        }
        Collections.sort(list);
        string = list.get(num - 1);


        System.out.println(count);
        System.out.println(string);
    }


    /**
     * 素数伴侣
     * 2019-8-13 15:25:10
     */
    private static void PrimeNumPartner(){
        // 有点难，涉及到图论，弃疗
    }

    /**
     * 字符串排序
     * 2019-8-13 10:18:50
     */
    private static void charsSort(String str) {
        int len = str.length();
        int hash[] = new int[len];
        StringBuilder strB = new StringBuilder(); // 可变长度的字符串
        for (int i = 0; i < len; i++) {
            if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')){
                strB.append(str.charAt(i));
                hash[i] = 1;
            }
        }
        char[] chs = strB.toString().toCharArray();
        for (int i = 0; i < chs.length - 1; i++) {  // 冒泡排序竟然还被我弄错了！！
            for (int j = 0 ; j < chs.length - i - 1; j++) {
                int tmp1 = (int)String.valueOf(chs[j]).toUpperCase().charAt(0);
                int tmp2 = (int)String.valueOf(chs[j + 1]).toUpperCase().charAt(0);
                if (tmp2 < tmp1) {
                    char temp;
                    temp = chs[j];
                    chs[j] = chs[j + 1];
                    chs[j + 1] = temp;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int j = 0;
        for (int i = 0; i < len; i++){
            if (hash[i] == 1){
                stringBuilder.append(chs[j++]);
            }else {
                stringBuilder.append(str.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 数据分类处理
     * 2019-8-13 10:10:50
     */

    /**
     * 合唱队
     * 2019-8-12 22:35:37
     */
    // 求最大递增子序列
    private static int[] positive(int[] arr) {
        int size = arr.length;
        int postive[] = new int[size];
        Arrays.fill(postive, 1);
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    max = Math.max(postive[j], max);
                }
            }
            postive[i] = postive[i] + max;
            max = 0;
        }
        return postive;
    }

    // 反转数组
    private static int[] reverseInt(int[] arr) {
        int re[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            re[i] = arr[arr.length - 1 - i];
        }
        return re;
    }

    private static void sing(int[] arr) {
        int size = arr.length;
        int positive[];  // 正向递增序列
        int negative[] = new int[size]; // 反向递增序列
        int count = 0;

        // 求正向最大递增子序列
        positive = positive(arr);
        // 求反向最大递增子序列
        int[] re = reverseInt(arr);
        negative = reverseInt(positive(re));

        for (int i = 0; i < size; i++) {
            positive[i] = positive[i] + negative[i];
        }
        int max = positive[0];
        for (int i = 0; i < size; i++) {
            if (positive[i] > max) {
                max = positive[i];
            }
        }
        int res = size - max + 1;
        System.out.println(res);
    }

    /**
     * s删除字符串中出现次数最少的字符
     * 2019-8-12 22:04:15
     */
    private static void deleteChar(String str) {
        int[] arr = new int[26];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            arr[str.charAt(i) - 'a']++;
        }
        int min = arr[str.charAt(0) - 'a'];
        for (int i = 0; i < len; i++) {
            if (arr[str.charAt(i) - 'a'] <= min) {
                min = arr[str.charAt(i) - 'a'];
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[str.charAt(i) - 'a'] > min) {
                System.out.print(str.charAt(i));
            }
        }
        System.out.println();

    }

    /**
     * 汽水瓶
     * 2019-8-12 21:38:13
     */
    private static void soadScanner() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n != 1) {
                System.out.println(soadT(n));
            } else {
                break;
            }

        }
    }

    private static void soda(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(soadT(arr[i]));
        }
    }

    private static int soadT(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return soadT(n - 2) + soadT(2);
    }

    // 用动态规划
    private static int dpSoda(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int res = 1;
        int prep = 1;
        int pre = 1;
        int two = 1;
        for (int i = 4; i <= n; i++) {
            res = prep + two;
            prep = pre;
            pre = res;

        }
        return res;
    }

    /**
     * 简单密码
     * 2019-8-12 21:12:23
     */
    private static void password(String str) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            char temp;
            if (ch >= 'A' && ch <= 'Z') {
                if (ch == 'Z') {
                    temp = 'a';
                } else {
                    temp = (char) ((int) ch + 33);
                }
            } else if (ch >= 'a' && ch <= 'c') {
                temp = '2';
            } else if (ch >= 'd' && ch <= 'f') {
                temp = '3';
            } else if (ch >= 'g' && ch <= 'i') {
                temp = '4';
            } else if (ch >= 'j' && ch <= 'l') {
                temp = '5';
            } else if (ch >= 'm' && ch <= 'o') {
                temp = '6';
            } else if (ch >= 'p' && ch <= 's') {
                temp = '7';
            } else if (ch >= 't' && ch <= 'v') {
                temp = '8';
            } else if (ch >= 'w' && ch <= 'z') {
                temp = '9';
            } else {
                temp = ch;
            }

            s.append(temp);
        }

        System.out.println(s.toString());
    }

    /**
     * 简单错误记录
     * 2019-8-12 09:21:32
     */
    private static void ErrorRecord() {

    }

    /**
     * 求质数
     * 2019-8-11 11:01:02
     */
    private static void primeNumber(int n) {
        boolean prime = true;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i < n; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.print(i + " ");
                stringBuilder.append(i);
                stringBuilder.append(" ");
            }
            prime = true;
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 识别邮箱的IP地址和掩码并进行分类统计
     * 2019-8-11 13:00:43   合法的智子网掩码，按位取反，加1后，二进制中，只有一个1
     */
    private static void count2(String[] strs) {
        int size = strs.length;
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;
        int Error = 0;

        for (int i = 0; i < size; i++) {
            String str = strs[i];
        }

    }


    /**
     * 坐标移动   本地运行没毛病，牛客上就炸了，why？？ 缺hasNextLine！！
     * 2019-8-11 10:10:28
     */
    private static void convertString(String str) {
        String[] strs = str.split(";");
        int x = 0;
        int y = 0;
        String temp;
        for (String str1 : strs) {
            try {
                if (str1.length() >= 2 && str1.length() <= 3) {
                    temp = str1;
                    if (temp.charAt(0) == 'A') {
                        x -= Integer.parseInt(temp.substring(1));
                    } else if (temp.charAt(0) == 'D') {
                        x += Integer.valueOf(temp.substring(1));
                    } else if (temp.charAt(0) == 'W') {
                        y += Integer.valueOf(temp.substring(1));
                    } else if (temp.charAt(0) == 'S') {
                        y -= Integer.valueOf(temp.substring(1));
                    }
                }
            } catch (NumberFormatException ignored) {
            }
        }
        System.out.println(x + "," + y);
    }


    /**
     * 购物单
     * 2019-8-9 22:26:14
     */

    /**
     * 求Int型整数在内存中存储时1的个数
     */
    private static void OneCount(int n) {
        System.out.println(Integer.bitCount(n));
    }

    /**
     * 字串的链接最长路径查找
     * 2019-8-9 21:40:41
     */
    private static void LongPath(String[] str) {
        Arrays.sort(str);
        for (String s : str) {
            System.out.println(s);
        }
    }

    /**
     * 句子逆转
     * 2019-8-9 21:33:36
     * 空间复杂度O(N)  时间复杂度O(N)   ？？？？？？？？？？？？？空间复杂度为O(1)怎么办呢？
     */

    private static void SentenceReverse(String str) {
        String[] strs = str.split(" ");
        int size = strs.length;
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(strs[i] + " ");
        }
    }

    /**
     * 字符串反转
     * 2019-8-9 21:32:40
     */

    /**
     * 数字颠倒
     * 2019-8-9 21:29:26
     */
    private static void ReversePrint(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder.reverse().toString());
    }

    /**
     * 字符个数统计
     * 2019-8-9 21:25:14
     */
    private static void CharCount(String str) {
        int size = str.length();
        int arr[] = new int[128];
        int res = 0;
        for (int i = 0; i < size; i++) {
            if (arr[str.charAt(i)] == 0) {
                res++;
                arr[str.charAt(i)]++;
            }
        }
        System.out.println(res);
    }

    /**
     * 提取不重复的整数
     * 2019-8-9 20:51:31
     * 哈希表法
     */

    private static void NoRepeat1(String str) {
        int size = str.length();
        int arr[] = new int[10];
        for (int i = size - 1; i >= 0; i--) {
            if (arr[str.charAt(i) - '0'] == 0) {
                System.out.print(str.charAt(i));
                arr[str.charAt(i) - '0']++;
            }
        }
    }

    private static void NoRepeat(int in) {
        StringBuilder str = new StringBuilder(String.valueOf(in));
        StringBuilder res = new StringBuilder("");
        str = str.reverse();
        int size = str.length();
        boolean add = true;
        for (int i = 0; i < size; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (str.charAt(i) == str.charAt(j)) {
                    add = false;
                }
            }
            if (add) {
                res.append(str.charAt(i));
            }
            add = true;
        }
        System.out.println(res.toString());
    }


    /**
     * h合并表记录
     * 2019-8-8 10:36:58
     */

    private static void merge(ArrayList<Integer> list) {
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
        int num = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < size; i += 2) {
            if (treeMap.containsKey(list.get(i))) {
                continue;
            }
            for (int j = i; j < size && list.get(i).equals(list.get(j)); j += 2) {
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
        for (Integer key : treeMap.keySet()) {
            System.out.println(key + " " + treeMap.get(key));
        }
    }

    /**
     * 取近似值
     * 2019-8-7 22:58:37
     */
    private static int Approximate(double f) {
        int f1 = (int) f;
        if (0.5000 >= f - f1) {
            return f1 + 1;
        } else {
            return f1;
        }
    }

    /**
     * 质数因子
     * 2019-8-7 22:56:35
     */
    private String getResult(long ulDataInput) {
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
                num += Math.pow(16, size - i - 1) * 10;
            } else if (str.charAt(i) == 'B') {
                num += Math.pow(16, size - i - 1) * 11;
            } else if (str.charAt(i) == 'C') {
                num += Math.pow(16, size - i - 1) * 12;
            } else if (str.charAt(i) == 'D') {
                num += Math.pow(16, size - i - 1) * 13;
            } else if (str.charAt(i) == 'E') {
                num += Math.pow(16, size - i - 1) * 14;
            } else if (str.charAt(i) == 'F') {
                num += Math.pow(16, size - i - 1) * 15;
            } else {
                num += Math.pow(16, size - i - 1) * ((int) str.charAt(i) - 48);
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
    private static int count2(String str, char c) {
        if (str == null || str.length() == 0) return 0;
        int res = 0;
        for (char s : str.toCharArray()) {
            if (s == c) {
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

    private static void partition(int[] arr, int left, int right) {
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

