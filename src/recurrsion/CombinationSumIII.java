package recurrsion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum3(3, 9);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 1, sumTillNow = 0;

        return findCombination3(index, k, n, sumTillNow, output, ans);
    }


    public static List<List<Integer>> findCombination3(int index, int k, int target, int sumTillNow, List<Integer> output, List<List<Integer>> ans) {

        if (sumTillNow == target && k == 0) {
            ans.add(output);
            System.out.println(ans);
            return ans;
        }

        if (index == 10) {
            return ans;
        }

        //with the index
        sumTillNow += index;
        output.add(index);
        findCombination3(index + 1, k - 1, target, sumTillNow, new ArrayList<>(output), ans);

        //Backtracking
        sumTillNow -= index;
        output.remove(Integer.valueOf(index));

        //without the index
        findCombination3(index + 1, k, target, sumTillNow, new ArrayList<>(output), ans);

        return ans;
    }

}
