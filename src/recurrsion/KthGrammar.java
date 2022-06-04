package recurrsion;

public class KthGrammar {
    public static void main(String[] args) {
        int n=4, k=6;
        int value = grammar(n,k);
        System.out.println("The Value at 4th row and 5th column is :- "+value);
    }

    public static int grammar(int n, int k){
        if(n==1 && k==1){
            return 0;
        }

        int length = (int)Math.pow(2, n-1);
        int mid = length/2;

        if(k<=mid){
            return grammar(n-1,k);
        }else{
            return (grammar(n-1,k-mid))^1;
        }
    }

    public static int findComplement(int number){
        int originalNumber = number;

        long i = 1;

        while(i<=originalNumber){
            number ^= i;
            i <<=1;
        }
        return number;
    }
}
