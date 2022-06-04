package arrays;

import java.util.Arrays;
public class ArrayWithoutDuplicatesWithOnlyArrays {

    public static void main(String[] args) {
        int[] array={1,1,2,2,3,3,4,5,6,7};
        int[] result = arrayWithoutDup(array);
        System.out.println(Arrays.toString(result));
    }

    public static int removeDuplicates(int[] arr, int n){
        if(n==0 || n==1){
            return n;
        }

        int j=0;
        for(int i=0; i<n-1; i++){
            if(arr[i]!=arr[i+1]){ // i+1 will given out of bound for arr[10] hence we have to check whether i<n-1,
                                           // so 8+1 =9 and things gets printed without exception
                arr[j] = arr[i];
                j++; // remember to increment j
            }
        }
        arr[j++] = arr[n-1]; // for printing the last element j should be incremented by 1
        return j;
    }

    public static int[] arrayWithoutDup(int[] arr){
        int result = removeDuplicates(arr, arr.length); // have to copy the modified array because the last three elements
                                                        // will remain intact and will cause duplication.
                                                        // Hence take a result sized array and copy the elements to new array
        int[] resultedArray = new int[result];
        for(int i=0; i<result; i++){
            resultedArray[i] = arr[i];
        }
        return resultedArray;
    }

}
