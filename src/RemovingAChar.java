public class RemovingAChar {
    public static void main(String[] args) {
        System.out.println(function("aaabbacaccadaa",0));
    }

    static String function(String str, int i){
        String str1="";
        StringBuilder sb = new StringBuilder();
        if(i==str.length()){
            return str1;
        }

        char ch = str.charAt(i);
        if(ch=='a'){
            str1 = function(str,i+1);
        }else{
            str1=String.valueOf(ch)+function(str,i+1);
        }
        sb.append(str1);
        return sb.toString();
    }
}
