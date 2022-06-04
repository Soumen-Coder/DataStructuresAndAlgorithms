package recurrsion;

public class FiboWithMemoizatrion {
    public static long[] fibonacciCache;

    public static void main(String[] args) {
        int n = 6; //0,1,1,2,3,5,8
        fibonacciCache = new long[n+1]; // because 3rd fibonacci number is 4th and 4th is 5 because of the zeroth position
        System.out.println(fibonacci(n));
    }

    private static long fibonacci(int n) {

        if(n<=1){
            return n;
        }

        if(fibonacciCache[n] != 0){
            // stop going to the function to calculate again
            return fibonacciCache[n];
        }

        fibonacciCache[n] = fibonacci(n-1) + fibonacci(n-2);
        return fibonacciCache[n];

    }

}
