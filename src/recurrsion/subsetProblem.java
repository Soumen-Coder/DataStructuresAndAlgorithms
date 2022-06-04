package recurrsion;

public class subsetProblem {
    public static void main(String[] args) {
        String word = "abc";
        subsetOf("", word);

    }

    public static void subsetOf(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subsetOf(p, up.substring(1));
        subsetOf(p+ch, up.substring(1));

    }
}
