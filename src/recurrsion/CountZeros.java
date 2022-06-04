package recurrsion;

public class CountZeros {

    public static void main(String[] args) {
        int result = countZeros(301201);
        System.out.println("Count of Zeros =: "+result);
    }

    public static int countZeros(int number){
        return helper(number, 0);
    }

    public static int helper(int number, int count){
        if(number == 0){
            return count;
        }
        int rem = number % 10;
        if(rem == 0){
            return helper(number/10, count+1);
        }
        return helper(number/10, count);
    }
}
