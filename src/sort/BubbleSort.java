package sort;

public class BubbleSort {
    public static void main(String args[]){
        int[] array = {1,4,2,67,45,23,12,34};
        display(array);
        System.out.println();
//        display(sorted(array));
        display(selectSort(array));

    }

    public static int[] sorted(int[] array){
        int max ;
        for (int i = 0; i < array.length; i++){
            for (int j = i; j < array.length-i-1; j++){
                if (array[j] > array[j+1]){
                    max = array[j];
                    array[j] = array[j+1];
                    array[j+1] = max;
                }
            }
        }
        return array;

    }

    public static int[] selectSort(int[] array){
        int min = 0;
        int num = 0;
        for (int i = 0; i < array.length-1; i++){

            for (int j = i+1; j < array.length ; j++){
                if (array[min] >= array[j]){
                    min = j;
                }
            }
            num = array[i];
            array[i] = array[min];
            array[min] = num;
            min = i+1;


        }
        return array;
    }

    public static void display(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
