package arrays;

import java.util.Arrays;

public class OneInteger {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        Arrays.sort(arr);
        int cost = 0;
        for(int i=0; i<arr.length - 1; i++) {
            arr[i+1] = arr[i] + arr[i+1];
            cost = cost + arr[i+1];
        }
        System.out.println(cost);
    }
}
