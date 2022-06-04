package recurrsion;

public class ReverseANumber {

    public static void main(String[] args) {
        int result = reverse(30201, 5);
        System.out.println(result);
    }

    private static int reverse(int number, int noOfDigits) {

        if(number == 0){
            return 0;
        }

        int rem = number % 10;
        return (int)((rem * Math.pow(10, noOfDigits-1)) + reverse(number/10, noOfDigits-1));

    }

}
