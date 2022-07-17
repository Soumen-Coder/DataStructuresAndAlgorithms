package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSumI {
   static int[] arr = new int[]{2,3,5};

    public static void main(String[] args) {
        int target = 8;
        List<List<Integer>> result = combinationSum(arr, target);
        System.out.println(result);
    }

        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);

            List<List<Integer>> ans = new ArrayList<>();
            int sumTillNow = 0;
            int index=0;

            return findCombinationSum(index, target, sumTillNow, Arrays.stream(candidates).boxed().collect(Collectors.toList()), new ArrayList<>(), ans);
        }

        public static List<List<Integer>> findCombinationSum(int index, int target, int sumTillNow, List<Integer> candidates, List<Integer> output, List<List<Integer>> ans){
            System.out.println("findCombinationSum Called");
            if(target==sumTillNow){
                System.out.println("When target and sumTillNow matches");
                ans.add(output);
                System.out.println("Result added from Output : "+ans);
                return ans;
            }
            if(index == candidates.size()){
                System.out.println("when index has finished traversing the candidates array");
                System.out.println("Returning result : "+ans);
                return ans;
            }
            if(sumTillNow>target){
                System.out.println("when sumTillNow exceeds the target, then no need of proceeding");
                System.out.println("Returning result : "+ans);
                return ans;
            }

            //adding of the same number
            sumTillNow+=candidates.get(index);
            System.out.println("Adding of the number, can be used many times");
            output.add(candidates.get(index));
            System.out.println("Sum Till Now :- "+sumTillNow+" and Output till now : "+output);
            System.out.println("Calling findCombinationSum, with index being kept same : with params : findCombinationSum("+(index)+","+target+","+(sumTillNow)+","+candidates+","+new ArrayList<>(output)+","+ans+")");
            findCombinationSum(index, target, sumTillNow, candidates, new ArrayList<>(output), ans);

            System.out.println("**********************BACKTRACKING*******************************");
            //not taking the index number in consideration
            sumTillNow-=candidates.get(index);
            System.out.println("Not taking the number, increase the index, to visit the next element");
            output.remove(candidates.get(index)); //this removes takes in object and return boolean
            //output.remove(arr[index]); Remember, remove is overloaded in arrayList, so this remove takes int as args and returns the type of the removed element
            System.out.println("Sum Till Now :- "+sumTillNow+" and removing previous element from output : "+output);
            System.out.println("Calling findCombinationSum, with index being kept same : with params : findCombinationSum("+(index+1)+","+target+","+(sumTillNow)+","+candidates+","+new ArrayList<>(output)+","+ans+")");
            findCombinationSum(index+1, target, sumTillNow, candidates, new ArrayList<>(output), ans);

            return ans;
        }
}
