package recurrsion;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] result = reverse(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(result));
    }

    public static int[] reverse(int[] arr, int start, int end){
        if(start>=end){
            return arr;
        }
        swap(arr,start,end);
        return reverse(arr, start+1, end-1);
    }

    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
