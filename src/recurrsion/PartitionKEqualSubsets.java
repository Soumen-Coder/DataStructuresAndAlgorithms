package recurrsion;

/*Given an integer array nums and an integer k, return true if it is possible to divide this array into k
        non-empty subsets whose sums are all equal.


        Input: nums = [4,3,2,3,5,2,1], k = 4
        Output: true
        Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.*/
import java.util.Arrays;
import java.util.stream.IntStream;

public class PartitionKEqualSubsets {

    public static void main(String[] args) {

        int[] nums = new int[]{1,5,11,5};
        int k = 2;

        boolean result = canPartitionKSubsets(nums, k);
        System.out.println(result);
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        int sum, reqSum;
        sum = IntStream.of(nums).sum();
        System.out.println("Total Sum of the Array Given is :-"+sum);
        if(nums.length<k || (sum % k)!= 0){
            return false;
        }else{
            reqSum = sum/k;
            System.out.println("Required Sum for each partitions to be eligible is :-"+reqSum);
        }
        System.out.println("Calling helper, with index 0, first call: with params : helper("+0+","+Arrays.toString(nums)+","+(k)+","+1+","+0+","+reqSum+","+ Arrays.toString(new int[nums.length])+")");
        boolean res =  helper(0, nums, k,1,  0,reqSum, visited);
        for (int i = 0; i < k; i++) {
            System.out.print("Partition " + i + " is: ");
            for (int j = 0; j < nums.length; j++)
                if (visited[j] == i+1)
                    System.out.print(nums[j] + " ");
            System.out.println();
        }
        return res;
    }

    private static boolean helper(int index, int[] nums, int k, int subsetNum, int currSum, int reqSum, int[] alreadyPicked) {
        boolean option1;
        boolean option2;

       if(index >= nums.length){
           System.out.println("Index has reached last of the nums array, no more combinations");
           return false;
       }

        if(k==0){
            return true;
        }

       if(currSum > reqSum){
           System.out.println("Subset sum is greater that that required, for a subset");
           return false;
       }

       if(currSum == reqSum){
           System.out.println("Subset sum is equal to the required sum, then call the next subset with index 0, from beginning");
           System.out.println("(((SUBSET NUMBER INCREASES TO :::)))"+(subsetNum+1)+"Calling helper, with index 0, new Subset call: with params : helper("+0+","+Arrays.toString(nums)+","+(k)+","+(subsetNum+1)+","+0+","+reqSum+","+Arrays.toString(alreadyPicked)+")");
           boolean res =  helper(0,nums, k-1, subsetNum+1, 0, reqSum, alreadyPicked);

           return res;
       }


        if(alreadyPicked[index]!=0){
            System.out.println("AlreadyPicked[index] is 1 and index is less than the number of array elements and if the corresponsing elements of the array are same and the next same element is not already picked then don't pick the element");
            System.out.println("Calling helper, with index+1, next element not picked up, same Subset call: with params : helper("+(index+1)+","+Arrays.toString(nums)+","+(k)+","+(subsetNum)+","+currSum+","+reqSum+","+Arrays.toString(alreadyPicked)+")");
            return helper(index+1, nums, k, subsetNum, currSum, reqSum, alreadyPicked);
        }
       else{
           //take the element
           System.out.println("Take the element :- "+nums[index]);
           currSum+=nums[index];
           System.out.println("Incrementing subset sum :- "+currSum);
           alreadyPicked[index] = k;
           System.out.println("Setting Already picked at index "+index+" to 1");
           System.out.println("Calling helper, with index+1, picked up element, same Subset call: with params : helper("+(index+1)+","+Arrays.toString(nums)+","+(k)+","+(subsetNum)+","+currSum+","+reqSum+","+Arrays.toString(alreadyPicked)+")");
           if(helper(index+1, nums, k, subsetNum, currSum, reqSum, alreadyPicked))
               return true;

           //Backtrack
           System.out.println("**************Backtracking*********");
           currSum-=nums[index];
           System.out.println("Decreased sunsetSum to :- "+currSum);
           alreadyPicked[index] = 0;
           System.out.println("Setting Already picked at index+"+index+" to 0");
           System.out.println("**************Backtracking Ends*********");

           //skips the element
           System.out.println("_____Skipping the element_____");
           System.out.println("*Calling helper, with index+1, next element not picked up, same Subset call: with params : helper("+(index+1)+","+Arrays.toString(nums)+","+(k)+","+(subsetNum)+","+currSum+","+reqSum+","+Arrays.toString(alreadyPicked)+"*)");
            if(helper(index+1, nums, k, subsetNum, currSum, reqSum, alreadyPicked))
                  return true;

           System.out.println("Returning the helper with either option 1 or option 2, if any is true, returns true");
           return false;
       }
    }
}
