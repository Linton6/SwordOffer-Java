package others;

/**
 * @Author Linton
 * @Date 2019/6/7 8:44
 * @Version 1.0
 * @Description 全排列的递归实现
 */

public class AllSort{

    public static void main(String[] args)
    {

        char buf[]={'a','b','c','d'};
        perm(buf, 0, buf.length-1);

    }

    public static void perm(char[] buf, int start, int end) {
        //当读到数组最后一个元素时，遍历数组
        if(start == end) {
            for (char c : buf) {
                System.out.print(c);
            }
            System.out.println("");
        } else {
            for(int i = start; i <= end; i++) {
                swap(buf, start, i);
                perm(buf, start + 1, end);
                //由于上面进行了交换，这里需要还原数组，因此再进行一次交换
                swap(buf, start, i);
            }
        }
    }

    //交换函数
    public static void swap(char[] buf, int i, int j) {
        char temp = buf[i];
        buf[i] = buf[j];
        buf[j] = temp;
    }
}
/*

// 去重的全排列

public class RecursionPermutation {

    public static void permutate(String input){
        if(input == null)
            throw new IllegalArgumentException();
        char[] data = input.toCharArray();
        permutate(data, 0);
    }

    public static void permutate(char[] data, int begin){
        int length = data.length;
        if(begin == length)
            System.out.println(data);
        for(int i = begin ; i < length; i++)
        {
            if(isUnique(data, begin, i)){
                swap(data, begin, i);
                permutate(data, begin + 1);
                swap(data, begin, i);
            }
        }
    }

    private static boolean isUnique(char[] data, int begin, int end){
        for(int i = begin; i < end; i++)
            if(data[i] == data[end])
                return false;
        return true;
    }

    private static void swap(char[] data, int left, int right) {
        char temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }


    public static void main(String... args){
        RecursionPermutation.permutate("aac");
    }

}
 */