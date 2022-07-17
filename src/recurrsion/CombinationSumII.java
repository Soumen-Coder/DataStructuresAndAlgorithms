package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum2(new int[]{1,2,3,1}, 5);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int sumTillNow = 0, index = 0;
        Arrays.sort(candidates);
        return findCombinationSum(index, target, sumTillNow, candidates, new ArrayList<>(), ans);
    }

    public static List<List<Integer>> findCombinationSum(int index, int target, int sumTillNow, int[] candidates, List<Integer> output, List<List<Integer>> ans) {

        if (target == sumTillNow) {
            ans.add(output);
            return ans;
        }
        if (sumTillNow > target) {
            return ans;
        }
        if (index == candidates.length) {
            return ans;
        }

        //take the element
        sumTillNow += candidates[index];
        output.add(candidates[index]);
        findCombinationSum(index + 1, target, sumTillNow, candidates, new ArrayList<>(output), ans);

        //backtracking
        sumTillNow -= candidates[index];
        output.remove(Integer.valueOf(candidates[index]));

        //check if both the adjacent elements are same or not, if yes, index++, restricting future consideration of the element
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) index++;

        //don't take the element
        findCombinationSum(index + 1, target, sumTillNow, candidates, new ArrayList<>(output), ans);

        return ans;
    }
}
