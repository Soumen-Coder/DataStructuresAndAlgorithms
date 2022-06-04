package recurrsion;

public class SubsetAnotherWay {
    public static void main(String[] args) {
        subsetOf("abc", "");
    }

    public static void subsetOf(String ip, String op){
        if(ip.length()==0){
            System.out.println(op);
            return;
        }

        String op1 = op;
        String op2 = op;

        op2 = op2 + ip.charAt(0);

        ip = ip.substring(1);

        subsetOf(ip, op1);
        subsetOf(ip, op2);
    }

}
