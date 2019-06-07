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
