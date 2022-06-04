package arrays;

import java.util.Arrays;

public class FirstSecondBestScores {

    public static void main(String[] args) {
        int[] arr = {84,87,85,90,43,76,77,90,90,90,90,90,1,2,3,4,5,0};
        String result = fetchFirstSecondBestScore(arr);
        System.out.println(result);
    }


    public static String fetchFirstSecondBestScore(int [] arr){
        Arrays.sort(arr);
        int n = arr.length-1;
        int first = arr[n];
        int second=0;
        for(int i=n; i>=0; i--){
            if(arr[i]!=first){
                second = arr[i];
                break;
            }
        }
        return first+" "+second;
    }

}
