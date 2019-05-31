package sort;

public class ArrayPar {
    private long[] theArray;
    private int nElems;

    public ArrayPar(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert (long value){
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        System.out.print("A= ");
        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println("");

    }
}
