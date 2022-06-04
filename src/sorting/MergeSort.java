package sorting;

import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[1000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("/nAfter");
        printArray(numbers);
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    private static void mergeSort(int[] numbers) {
         int midIndex = numbers.length/2;
         int[] leftArray = new int[midIndex];
         int[] rightArray = new int[numbers.length - midIndex]; // pattern


         if(numbers.length<2){
             return;
         }

        for (int i = 0; i < midIndex; i++) {
            leftArray[i] = numbers[i];
        }
        for (int i = midIndex; i < numbers.length; i++) {
            rightArray[i - midIndex] = numbers[i];//pattern to pick up from middle
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(numbers, leftArray, rightArray);
    }

    private static void merge(int[] numbers, int[] leftArray, int[] rightArray) {
        int i=0, j=0, k=0;
        while(i<leftArray.length && j<rightArray.length){
            if(leftArray[i]<= rightArray[j]){
                numbers[k] = leftArray[i];
                i++;
            }else{
                numbers[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i<leftArray.length){
            numbers[k] = leftArray[i];
            i++;
            k++;
        }
        while(j<rightArray.length){
            numbers[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
