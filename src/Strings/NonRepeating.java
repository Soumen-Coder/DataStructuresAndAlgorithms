package Strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeating {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        System.out.println(nonRepeating("abcab")); // should return 'c'
        System.out.println(nonRepeating("abab")); // should return null
        System.out.println(nonRepeating("aabbbc")); // should return 'c'
        System.out.println(nonRepeating("aabbdbc")); // should return 'd'
    }

    // Implement your solution below.
    public static Character nonRepeating(String s) {
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        for(char c : s.toCharArray()){
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c)+1);
            }else{
                hm.put(c,1);
            }
        }
        System.out.println(hm);
        //If you don't want to use LinkedHashMap, iterate over the string to get the first occurance
        /*for (char c : s.toCharArray()) {
            if (hm.get(c) == 1) return c;
        }*/
        for(Map.Entry<Character, Integer> map : hm.entrySet()){
            if(map.getValue()==1){
                return map.getKey();
            }
        }
        return null;
    }
}