package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetProblemWithoutSortedOrder {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    static ArrayList<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        ArrayList<Integer> aList = new ArrayList<>(list);
        System.out.println(subsets(aList));
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> list) {
        return helper(list, 0);
    }

    public static ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> list, int i) {

            if(i>=list.size()){
                return new ArrayList<>();
            }

            ArrayList<ArrayList<Integer>> partialAns = helper(list, i+1);

            for(ArrayList<Integer> pa : partialAns){
                ans.add(pa);
            }

            for(ArrayList<Integer> pa : partialAns){
                temp.add(list.get(i));
                for (int y : pa) {
                    temp.add(y);
                }
                ans.add(temp);
            }

            return ans;
        }

}
