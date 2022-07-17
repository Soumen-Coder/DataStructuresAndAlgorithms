package recurrsion;

public class PowerOfANumber {
    public static void main(String[] args) {
        int result = pow(3,5);
        System.out.println(result);
    }

    //will provide x^n
    public static int pow(int x, int n) {
        if(n==0){
            return 1;
        }

        int temp = pow(x, n/2);

        if(n%2==1){
            return temp * temp * x;
        }
        return temp * temp;
    }
}
