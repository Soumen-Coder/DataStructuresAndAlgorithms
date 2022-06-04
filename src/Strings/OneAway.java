package Strings;

public class OneAway {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        System.out.println(isOneAway("abcde", "abcd"));  // should return true
        System.out.println(isOneAway("abde", "abcde"));  // should return true
        System.out.println(isOneAway("a", "a"));  // should return true
        System.out.println(isOneAway("abcdef", "abqdef"));  // should return true
        System.out.println(isOneAway("abcdef", "abccef"));  // should return true
        System.out.println(isOneAway("abcdef", "abcde"));  // should return true
        System.out.println(isOneAway("aaa", "abc"));  // should return false
        System.out.println(isOneAway("abcde", "abc"));  // should return false
        System.out.println(isOneAway("abc", "abcde"));  // should return false
        System.out.println(isOneAway("abc", "bcc"));  // should return false
    }

    // Implement your solution below.
    public static Boolean isOneAway(String s1, String s2) {
        if(s1.length() - s2.length()>=2 || s2.length() - s1.length()>=2){
            return false;
        }
        if(s1.length()==s2.length()) {
            return samelength(s1, s2);
        }
        if(s1.length()>s2.length()) {
            return oneCharMoreinS1(s1, s2); // One character more in s1
        }else{
            return oneCharMoreinS1(s2, s1); // One character more in s2
        }
    }

    private static Boolean oneCharMoreinS1(String s1, String s2) {
        int count_diff=0;
        int i=0;
        while(i<s2.length()){
            if(s1.charAt(i+count_diff)==s2.charAt(i)){
                i++;
            }else{
                count_diff+=1;
                if(count_diff>1){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean samelength(String s1, String s2) {
        int count_diff=0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.toCharArray()[i]!=s2.toCharArray()[i]){
                count_diff+=1;
            }
        }
        if(count_diff>1){
            return false;
        }
        return true;
    }
}
