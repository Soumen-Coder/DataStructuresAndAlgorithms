package dynamicProgramming;

public class CoinChangeProblemInfiniteSupplyPossibleOrNot {
    public static void main(String[] args) {
        int result = change(4, new int[]{1,2,3});
        System.out.println("Possible to make a given sum from the given denomination having infinite supply of coins, huh? " +result);
    }

    public static int change(int target, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][target +1]; //dp[coins.length+1][targetSum+1], to accommodate the base condition

        //Using form 1 of Dp : Dp(level, sum_left) = is it possible to make a sum m from [level....n]
        for (int level = n; level>=0 ; level--) {
            for (int sum_left = 0; sum_left<=target; sum_left++) {
                //BASE CONDITION
                if (level == n) { // if all the denominations has been traversed and no coins left
                    if (sum_left == 0) { // if sum_left=0
                        dp[level][sum_left] = 1; // possible to make a sum "m" from coins[level]
                    } else {
                        dp[level][sum_left] = 0; // else, not possible to make a sum "m" from coins[level]
                    }
                } else {
                    //GENERAL COMPUTATION
                    //Two choices : or rather two transitions : don't take, sum_left remains same and move to next level - level+1
                    //                                        : take, sine we can take it multiple times, we remain in same level and decrease the sum_left = sum_left - coins[level]
                    //don't take
                    if (dp[level + 1][sum_left] == 1) { // if possible to make a sum m
                        dp[level][sum_left] = 1; //mark the dp array used for memoization as possible
                    }
                    //take
                    //check if sum_left is greater otherwise a sum_left of 1 cannot be made from [5,6,7] for example
                    if (sum_left >= coins[level] && dp[level][sum_left - coins[level]] == 1) { // if possible to make a sum m
                        dp[level][sum_left] = 1; //mark the dp array used for memoization as possible
                    }
                }
            }
        }
        //Printing the final dp array which was used for memoization
        for (int i = n; i>=0; i--) {
            for (int j = 0; j<=target; j++) {
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        return dp[0][target]; // returns, if it is possible to make a sum or not
    }
}
