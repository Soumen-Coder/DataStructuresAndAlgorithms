package recurrsion;

public class Palindrome {

    public static void main(String[] args) {
        String str = "ABCCBA";
        boolean result = palindrome(str, 0, str.length()-1);
        System.out.println(result);
    }

    public static boolean palindrome(String str, int start, int end) {
        //Base condition
        if(start>=end){
            return true;
        }

        //Check for quality
        if(str.charAt(start) != str.charAt(end)){
            return false;
        }

        //recursion
        return palindrome(str, ++start, --end);
    }
}
