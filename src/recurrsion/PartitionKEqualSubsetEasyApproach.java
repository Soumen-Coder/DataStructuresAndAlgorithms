package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PartitionKEqualSubsetEasyApproach {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,3,5,2,1};
        int k = 4;

        boolean result = canPartitionKSubsets(nums, k);
        System.out.println(result);
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int[] visited = new int[nums.length];
        int sum, reqSum;
        sum = IntStream.of(nums).sum();
        if(sum%k!=0)return false;

        reqSum = sum/k;
        Arrays.sort(nums); // Sort the array from smallest to largest [1,2,2,3,3,4,5]
        System.out.println("Sorted Array :- "+Arrays.toString(nums));
        boolean result =  helper(0, nums, k, visited, 0, reqSum);
        if (!result)
        {
            System.out.println("k-partition of set nums is not possible");
        }
        for (int i = 0; i < k; i++) {
            System.out.print("Partition " + i + " is: ");
            for (int j = 0; j < nums.length; j++)
                if (visited[j] == i+1)
                    System.out.print(nums[j] + " ");
            System.out.println();
        }
        return result;
    }

    private static boolean helper(int index, int[] nums, int k, int[] visited, int currSum, int reqSum) {
        if(k>nums.length) return false;
        if(reqSum<nums[nums.length-1]){
            return false;
        }
        if(k==0) {
            return true;
        }
        if(reqSum == currSum){
            boolean res =  helper(0, nums, k-1, visited, 0, reqSum);
            return res;
        }
        if(currSum>reqSum){
            return false;
        }
        if(index >= nums.length){
            return false;
        }

        for(int start=index; start<nums.length; start++){
            //if(visited[start]!=0 || (start<nums.length-1 && nums[start]==nums[start+1] && visited[start+1]==0)) continue;
            if(visited[start]==0 && nums[start]+currSum<=reqSum){
                visited[start] = k;
                if(helper(index+1, nums, k, visited, nums[start]+currSum, reqSum)){
                    return true;
                }
                visited[start]=0;
            }
        }
        return false;
    }
}
