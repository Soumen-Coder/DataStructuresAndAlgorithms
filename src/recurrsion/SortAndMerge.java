package recurrsion;

import java.util.Arrays;

public class SortAndMerge {
    public static void main(String[] args) {
        int[] arr = {1,7,2,3,0,9,6,4,8};
        sort(arr, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

   public static void sort(int[] arr, int index){
        if(index==1){
            return ;
        }
        int temp = arr[arr.length-1];
        sort(arr, index-1);
        System.out.println("Sorted  "+Arrays.toString(arr));

        //insert(arr, temp, index);
    }

    public static void insert(int[] arr, int temp, int index){
      if(index==0 || temp>=arr[arr.length-1]){
          arr[arr.length-1] = temp;
      }

      int last = arr[arr.length-1];
      insert(arr, temp, index-1);
      arr[arr.length-1] = last;
    }
}
