package arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        List<List<Character>> ans = new ArrayList<>();
        char[] nums = {'A','B','C'};
        recurrPermute(0, nums, ans);
        System.out.println(ans);
    }

    private static void recurrPermute(int index, char[] nums, List<List<Character>> ans) {
        if(index==nums.length){
            List<Character> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurrPermute(index+1,nums, ans);
            swap(i, index, nums);
        }

    }

    private static void swap(int i, int j, char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
