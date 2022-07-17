package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UniquePermutations {
    private static HashSet<Integer> hashSet = new HashSet<>();
    public static void main(String[] args) {
        List<String> answer = new ArrayList<>();
        findPermutations("abb");
    }

    public static List<String> getPermutations(int pos, char[] ch, List<String> ans){
        System.out.println("************GETPERMUTATIONS CALLED**********");
        if(pos>=ch.length){
            System.out.println("Base Condition met, returning answer");
            ans.add(String.valueOf(ch));
            System.out.println("Answer List of Base Cond. :- "+ans);
            return ans;
        }

        for (int i = pos; i < ch.length; i++) {
            System.out.println("Checking if we can swap between "+pos+" and "+i);
            boolean check = shouldSwap(ch, pos, i);
            System.out.println("Should we swap ? "+check);
            if(check) {
                System.out.println("Swapping characters");
                swap(ch, i, pos);
                System.out.println("Characters swapped :- " + Arrays.toString(ch) + " between " + i + " and " + pos + ".");
                System.out.println("-----Calling getPermutations----- getPermutations(" + (pos + 1) + "," + Arrays.toString(ch) + "," + ans + ")");
                getPermutations(pos + 1, ch, ans);
                System.out.println("Returning getPermutations");
                System.out.println("Swapping the characters back again, after function returned");
                swap(ch, i, pos);
                System.out.println("Characters swapped :- " + Arrays.toString(ch) + " between " + i + " and " + pos + ".");
            }
        }

        System.out.println("Returning the answer from getPermutations method :- "+ans);
        return ans;
    }

    public static void findPermutations(String str) {
        // base case
        if (str == null || str.length() == 0) {
            return;
        }

        List<String> permutations = getPermutations(0, str.toCharArray(), new ArrayList<>());
        System.out.println(permutations);
    }

    //swapping two characters of a string
    private static void swap(char[] c, int i, int pos) {
        char temp = c[i];
        c[i] = c[pos];
        c[pos] = temp;
    }

    static boolean shouldSwap(char str[], int start, int curr) {
        for (int i = start; i < curr; i++) {
            System.out.println("If str[i] == str[curr] then don't swap where str[i]= "+str[i]+" and str[curr]= "+str[curr]);
            if (str[i] == str[curr]) {
                return false;
            }
        }
        return true;
    }
}
