package recurrsion;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        boolean isFound = linearSearch(arr, 4, 0);
        System.out.println(isFound);
    }

    public static boolean linearSearch(int[] arr, int target, int index){
        if(index == arr.length - 1){
            return false;
        }

        return ((arr[index] == target) || linearSearch(arr, target, index+1));
    }
}
