package recurrsion;

import java.util.*;

public class PhoneNumberLetterCombination {

    public static void main(String[] args) {
        String digits = "999";
        List<String> answer = letterCombinations(digits);
        System.out.println(answer);
    }

    public static List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        List<Character> temp = new ArrayList<>();

        return findLetterCombinations(0, digits.toCharArray(), temp,  map, ans);
    }

    private static List<String> findLetterCombinations(int index, char[] digits, List<Character> temp, Map<Character, String> map, List<String> answer) {

        if(index >= digits.length){
            StringBuilder str = new StringBuilder();
            for(Character c : temp) {
                 str.append(c);
            }
            answer.add(str.toString());
            return answer;
        }

        String correspondingAlphaOfDigits = map.get(digits[index]);

        for (int j = 0; j < correspondingAlphaOfDigits.length(); j++) {
            temp.add(correspondingAlphaOfDigits.toCharArray()[j]);
            findLetterCombinations(index+1, digits, temp, map, answer);
            temp.remove(temp.size()-1);
        }

        return answer;
    }
}
