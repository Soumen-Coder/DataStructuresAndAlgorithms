package arrays;

import java.util.Arrays;

public class ReversingArrays {
    public static void main(String[] args){
        int[] arr = {10,20,30,40,15,32,88,23,12,1,99};
        int[] output = reverse(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(output));
    }

    static int[] reverse(int[] a, int start, int end){
        Arrays.sort(a);
        while(start<=end) {
            if(a[start]<a[end]){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
            }
            else{
                end--;
            }
        }
        return a;
    }
}
