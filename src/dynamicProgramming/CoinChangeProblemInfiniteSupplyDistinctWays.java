package dynamicProgramming;

public class CoinChangeProblemInfiniteSupplyDistinctWays {
    public static void main(String[] args) {
        int result = count( new int[]{1,2,3}, 4);
        System.out.println("The total number of ways to get the desired change is ? " +result);
    }

    public static int count(int[] coins, int target) {
        int n = coins.length;

        int[][] T = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            T[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (coins[i - 1] > j) {
                    //don't take it
                    T[i][j] = T[i - 1][j];
                } else {
                    //take it and add the previous result as well to get the distinct ways
                    T[i][j] = T[i - 1][j] + T[i][j - coins[i - 1]];
                }
            }
        }
        //Printing the final dp array which was used for memoization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }
        return T[n][target];
    }
}
