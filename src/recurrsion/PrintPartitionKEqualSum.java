package recurrsion;

import java.util.Arrays;
import java.util.stream.IntStream;

class PrintPartitionKEqualSum
{
    // Function to check if all subsets are filled or not
    private static boolean checkSum(int[] sumLeft, int k)
    {
        boolean r = true;
        for (int i = 0; i < k; i++)
        {
            if (sumLeft[i] != 0) {
                r = false;
            }
        }

        return r;
    }

    // Helper function for solving `k` partition problem.
    // It returns true if there exist `k` subsets with the given sum
    private static boolean subsetSum(int[] arr, int n, int[] sumLeft, int[] visited, int k)
    {
        // return true if a subset is found, means subsets are filled hence true
        if (checkSum(sumLeft, k)) {
            return true;
        }

        // base case: no items left, done searching, no combo found
        if (n < 0) {
            return false;
        }

        boolean result = false;

        // consider current item `arr[n]` and explore all possibilities
        // using backtracking
        for (int i = 0; i < k; i++)
        {
            if (!result && (sumLeft[i] - arr[n]) >= 0)
            {
                // mark the current element subset, whether visited
                visited[n] = i + 1;

                // add the current item to the i'th subset
                sumLeft[i] = sumLeft[i] - arr[n];

                // recur for remaining items
                result = subsetSum(arr, n - 1, sumLeft, visited, k);

                // backtrack: remove the current item from the i'th subset
                sumLeft[i] = sumLeft[i] + arr[n];
            }
        }

        // return true if we get a solution
        return result;
    }

    // Function for solving k–partition problem. It prints the subsets if
    // set `S[0…n-1]` can be divided into `k` subsets with equal sum
    public static void partition(int[] arr, int k)
    {
        // get the total number of items in `arr`
        int n = arr.length;

        // base case
        if (n < k)
        {
            System.out.println("k-partition of set arr is not possible, can you partition a 4 element array to 5 parts, NO right");
            return;
        }

        // get the sum of all elements in the set
        int sum = IntStream.of(arr).sum();
        int[] visited = new int[n];

        // create an array of size `k` for each subset and initialize it
        // by their expected sum, i.e., `sum/k`
        int[] sumLeft = new int[k];
        Arrays.fill(sumLeft, sum/k);

        // return true if the sum is divisible by `k` and set `S` can
        // be divided into `k` subsets with equal sum
        boolean result = (sum % k) == 0 && subsetSum(arr, n - 1, sumLeft, visited, k);

        if (!result)
        {
            System.out.println("k-partition of set S is not possible");
            return;
        }

        // print all k–partitions
        for (int i = 0; i < k; i++)
        {
            System.out.print("Partition " + i + " is ");
            for (int j = 0; j < n; j++)
            {
                if (visited[j] == i + 1) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        // Input: a set of integers
        int[] arr = { 7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4 };
        int k = 5;

        partition(arr, k);
    }
}
