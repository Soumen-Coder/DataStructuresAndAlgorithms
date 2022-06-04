package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;

public class LetterCaseWithDigits {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        String ip = "a1B2";
        String op = "";

        solve(ip, op, list);

        System.out.println(list);

    }

    public static void solve(String ip, String op, ArrayList<String> list){
        if(ip.length()==0){
            list.add(op);
            return;
        }

        if(Character.isAlphabetic(ip.charAt(0))){
            String op1 = op;
            String op2 = op;

            op1 = (op1 + ip.charAt(0)).toLowerCase();
            op2 = (op2 + ip.charAt(0)).toUpperCase();

            ip = ip.substring(1);

            solve(ip, op1, list);
            solve(ip, op2, list);
        }else if(Character.isDigit(ip.charAt(0))){
            String op1 = op;
            op1 = op1 + ip.charAt(0);

            ip = ip.substring(1);

            solve(ip, op1, list);
        }
    }

}
