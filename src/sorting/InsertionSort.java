package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {3,1,6,8,7,2};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp=array[i], j=i-1;

            while(j>=0 && array[j]>temp){
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }
}
