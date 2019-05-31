package sort;

public class ArrayList {
    public static void main(String[] args){
        int[] array = {1,4,2,67,45,23,12,34};
        int[] array1 = {1,4,2,67,45,23,12,34};
        int max = getMax(array);
        System.out.println(max);
     display(merge(array,array1));



    }

    public static void display(int[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }

    }
    public static int[] merge(int[] a,int[] b){
        int[] c = new int[a.length+b.length];
        for (int i = 0; i < a.length; i++){
            c[i] = a[i];
        }
        for (int i = 0 ; i < b.length; i++){
            c[i+a.length] = b[i];
        }
        return c;

    }

    public static int getMax(int[] a){
        int max = 0;
        for (int i = 0; i < a.length-1; i++){
            if (a[i] < a[i+1]){
                if (max<a[i+1]){
                    max = a[i+1];
                }
            }else{
                if (max<a[i]){
                    max = a[i];
                }
            }
        }
        return max;
    }
}
