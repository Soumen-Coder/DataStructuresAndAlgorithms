package recurrsion;

public class RemoveAlla {
    public static void main(String[] args) {
        String word="baacdafr";
        String result = removeA(word);
        System.out.println(result);
        removeaAnothermethod("", word);
    }

    public static String removeA(String word){
        String processed=null;
        if(word.isEmpty()){
            return "";
        }

        char ch = word.charAt(0);

        if(ch == 'a'){
            processed = removeA(word.substring(1));
        }
        else
            processed = ch + removeA(word.substring(1));

        return processed;
    }

    public static void removeaAnothermethod(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if(ch=='a'){
            removeaAnothermethod(p, up.substring(1));
        }else{
            removeaAnothermethod(p+ch, up.substring(1));
        }
    }

}
