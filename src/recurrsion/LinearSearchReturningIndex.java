package recurrsion;

public class LinearSearchReturningIndex {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int target=4;
        int index = linearSearch(arr, target, arr.length-1);
        System.out.println(index);
    }

    public static int linearSearch(int[] arr, int target, int index){
        if(index == 0){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

        return linearSearch(arr, target, index-1);
    }
}
