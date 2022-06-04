package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;

public class subsetProblemReturningArrayList {

    public static void main(String[] args) {
        System.out.println((subsetOf("", "abc").toString()));
    }

    public static ArrayList<String> subsetOf(String p, String up){
        ArrayList<String> list = new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        //reverse the calls to print in reverse order
        ArrayList<String> left = subsetOf(p, up.substring(1));
        ArrayList<String> right = subsetOf(p+ch, up.substring(1));

        list.addAll(right);
        list.addAll(left);

        return list;
    }
}
