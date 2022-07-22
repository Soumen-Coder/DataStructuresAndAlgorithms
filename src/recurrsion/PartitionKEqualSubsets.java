package recurrsion;

/*Given an integer array nums and an integer k, return true if it is possible to divide this array into k
        non-empty subsets whose sums are all equal.


        Input: nums = [4,3,2,3,5,2,1], k = 4
        Output: true
        Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PartitionKEqualSubsets {

    public static void main(String[] args) {

        int[] nums = new int[]{4,3,2,3,5,2,1};
        int k = 4;

        boolean result = canPartitionKSubsets(nums, k);
        System.out.println(result);
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum, reqSum;
        sum = IntStream.of(nums).sum();
        System.out.println("Total Sum of the Array Given is :-"+sum);
        if((sum % k)!= 0){
            return false;
        }else{
            reqSum = sum/k;
            System.out.println("Required Sum for each partitions to be eligible is :-"+reqSum);
        }
        System.out.println("Calling helper, with index 0, first call: with params : helper("+0+","+Arrays.toString(nums)+","+(k)+","+1+","+0+","+reqSum+","+ Arrays.toString(new int[nums.length])+")");
        return helper(0, nums, k,1,  0,reqSum, new int[nums.length], new ArrayList<>(), new ArrayList<>());
    }

    private static boolean helper(int index, int[] nums, int k, int subsetNum, int subsetSum, int reqSum, int[] alreadyPicked, List<Integer> partition, List<List<Integer>> subSets) {
        boolean option1;
        boolean option2;

       if(index >= nums.length){
           System.out.println("Index has reached last of the nums array");
           return false;
       }

       if(subsetSum > reqSum){
           System.out.println("Subset sum is greater that that required");
           return false;
       }

       if(subsetSum == reqSum){
           /*// print all k–partitions
           for (int i = 0; i < k; i++)
           {
               System.out.print("Partition " + i + " is ");
               for (int j = 0; j < nums.length; j++)
               {
                   if (alreadyPicked[j] == i + 1) {
                       System.out.print("()()()()()()()()"+nums[j] + " ");
                   }
               }
               System.out.println();
           }*/
           System.out.println("Subset sum is equal to the required sum, then call the next subset with index 0, from beginning");
           System.out.println("(((SUBSET NUMBER INCREASES TO :::)))"+(subsetNum+1)+"Calling helper, with index 0, new Subset call: with params : helper("+0+","+Arrays.toString(nums)+","+(k)+","+(subsetNum+1)+","+0+","+reqSum+","+Arrays.toString(alreadyPicked)+")");
           return helper(0,nums, k, subsetNum+1, 0, reqSum, alreadyPicked, new ArrayList<>(), subSets);
       }

       if(subsetNum == k+1){
           System.out.println("No of subset has reached a total of K and we no more create subsets now, returning true");
           subSets.add(partition);
           System.out.println("***********************************************"+subSets);
           return true;
       }

       if(alreadyPicked[index] == 1){
           System.out.println("AlreadyPicked[index] is 1 and printing the numbers not taken into considerations :-"+nums[index]);
           System.out.println("Calling helper, with index+1, next element not picked up, same Subset call: with params : helper("+(index+1)+","+Arrays.toString(nums)+","+(k)+","+(subsetNum)+","+subsetSum+","+reqSum+","+Arrays.toString(alreadyPicked)+")");
           return helper(index+1, nums, k, subsetNum, subsetSum, reqSum, alreadyPicked, new ArrayList<>(partition), subSets);
       }
       else{
           //take the element
           System.out.println("Take the element :- "+nums[index]);
           subsetSum+=nums[index];
           System.out.println("Incrementing subset sum :- "+subsetSum);
           alreadyPicked[index] = 1;
           System.out.println("Setting Already picked at index "+index+" to 1");
           partition.add(nums[index]);
           System.out.println("Calling helper, with index+1, picked up element, same Subset call: with params : helper("+(index+1)+","+Arrays.toString(nums)+","+(k)+","+(subsetNum)+","+subsetSum+","+reqSum+","+Arrays.toString(alreadyPicked)+")");
           option1 = helper(index, nums, k, subsetNum, subsetSum, reqSum, alreadyPicked, new ArrayList<>(partition), subSets);

           //Backtrack
           System.out.println("**************Backtracking*********");
           subsetSum-=nums[index];
           System.out.println("Decreased sunsetSum to :- "+subsetSum);
           alreadyPicked[index] = 0;
           System.out.println("Setting Already picked at index+"+index+" to 0");
           partition.remove(Integer.valueOf(nums[index]));
           System.out.println("**************Backtracking Ends*********");

           //skips the element
           System.out.println("_____Skipping the element_____");
           System.out.println("*Calling helper, with index+1, next element not picked up, same Subset call: with params : helper("+(index+1)+","+Arrays.toString(nums)+","+(k)+","+(subsetNum)+","+subsetSum+","+reqSum+","+Arrays.toString(alreadyPicked)+"*)");
           option2 = helper(index+1, nums, k, subsetNum, subsetSum, reqSum, alreadyPicked,  new ArrayList<>(partition), subSets);

           System.out.println("Returning the helper with either option 1 or option 2, if any is true, returns true");
           return (option1 || option2);
       }
    }
}
