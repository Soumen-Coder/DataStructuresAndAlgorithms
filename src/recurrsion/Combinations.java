package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC = 2^n and SC = o(n) - recursion space + height of tree
public class Combinations {

    public static void main(String[] args) {
      List<List<Integer>> answer = combine(4,4);
        System.out.println(answer);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            input.add(i);
        }
        return findCombinations(0, n, k, input, new ArrayList<>(), result);
    }

    public static List<List<Integer>> findCombinations(int index, int n, int k, List<Integer> input, List<Integer> output, List<List<Integer>> result) {
        //base condition
        if (k == 0) {
            System.out.println("Size is restricted to 2, with help of this, output added to result");
            result.add(output);
            return result;
        }
        if (index == n) {
            System.out.println("When index has reached the size of the input array");
            return result;
        }
        if (k == (n - index + 1)) { // (n-index+1) are remaining elements
            System.out.println("when k > n-index+1 :- "+k+" > "+(n-index+1)+"for index "+index);
            return result;
        }

        //with the index
        System.out.println("output.add "+input.get(index));
        output.add(input.get(index));
        System.out.println("Calling findCombinations, with index added to output array : with params : findCombinations("+(index + 1)+","+n+","+(k - 1)+","+input+","+new ArrayList<>(output)+","+result+")");
        findCombinations(index + 1, n, k - 1, input, new ArrayList<>(output), result);

        System.out.println("---------BACKTRACKING---------");
        //without the index
        System.out.println("output.remove "+input.get(index));
        output.remove(input.get(index));
        System.out.println("Calling findCombinations, with index added to output array : with params : findCombinations("+(index + 1)+","+n+","+k+","+input+","+new ArrayList<>(output)+","+result+")");
        findCombinations(index + 1, n, k, input, new ArrayList<>(output), result);
        return result;
    }
}
