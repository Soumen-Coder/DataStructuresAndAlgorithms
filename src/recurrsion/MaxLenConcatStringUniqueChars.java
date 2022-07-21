package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

        Return the maximum possible length of s.

        A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

        Input: arr = ["un","iq","ue"]
        Output: 4
        Explanation: All the valid concatenations are:
        - ""
        - "un"
        - "iq"
        - "ue"
        - "uniq" ("un" + "iq")
        - "ique" ("iq" + "ue")
        Maximum length is 4.*/

public class MaxLenConcatStringUniqueChars {

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.addAll(Arrays.asList("abcdefghijklmnopqrstuvwxyz"));
        int maxPossibleLength = maxLength(arr);
        System.out.println(maxPossibleLength);
    }

    public static boolean compare(int[] selected, String str){
        //SelfCheck
        int[] selfCheck = new int[26];
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(selfCheck[ch - 'a'] == 1)return false;
            selfCheck[ch - 'a'] = 1;
        }

        //Past Check with the selected array
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(selected[ch - 'a'] == 1)return false;
        }
        return true;
    }

    public static int maxLength(List<String> arr) {
        int[] selected = new int[26];
        return helper(0, selected, arr, 0);
    }

    public static int helper(int index, int[] selected, List<String> arr, int length){
        if(index >= arr.size()){
            return length;
        }

        if(compare(selected, arr.get(index)) == false){
            //We only have option to skip
            return helper(index+1, selected, arr, length);
        }else{
            //take
            length = length + arr.get(index).length();
            for(char ch : arr.get(index).toCharArray()){
                selected[ch - 'a'] = 1;
            }
            int lengthAfterTaking = helper(index, selected, arr, length);

            //backtrack
            length-= arr.get(index).length();
            for(char ch : arr.get(index).toCharArray()){
                selected[ch - 'a'] = 0;
            }
            //skip
            int lengthAfterSkipping =  helper(index+1, selected, arr, length);

            return Math.max(lengthAfterTaking, lengthAfterSkipping);
        }
    }
}
