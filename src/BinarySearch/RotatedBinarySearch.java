package BinarySearch;

public class RotatedBinarySearch {
    public static void main(String[] args) {
          int[] arr = {5,6,7,8,9,1,2,3,4};
          int index = findTarget(arr, 4, 0, arr.length-1);
          System.out.println(index);
    }

    //[5,6,7,8,9,1,2,3,4]
    //[5,6,1,2,3,4]
    static int findTarget(int[] arr, int target, int start, int end){
        if(start>end){
            return -1;
        }

        int mid = start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }

        if(arr[start] <= arr[mid]) {
            if (target >= arr[start] && target <= arr[mid]) {
                return findTarget(arr,target,start,mid-1);
            } else {
                return findTarget(arr,target,mid+1,end);
            }
        }

        if(arr[start]>=arr[mid]) {
            if (target < arr[end] && target > arr[mid]) {
                return findTarget(arr,target,mid + 1,end);
            } else {
                return findTarget(arr,target,start,mid-1);
            }
        }
        return mid;
    }
}
