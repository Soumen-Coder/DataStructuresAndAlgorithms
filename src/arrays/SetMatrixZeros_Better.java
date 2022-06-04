package arrays;

import java.util.Arrays;

public class SetMatrixZeros_Better {
    public static void main(String[] args) {
        int[][] a = {{1,1,1}, {1,0,1}, {1,1,1}};
        int[][] output = setMatrixZeros(a);
        System.out.println(Arrays.deepToString(output));
    }

    private static int[][] setMatrixZeros(int[][] a) {
        int[] rowArray = new int[a.length];
        int[] colArray = new int[a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    rowArray[i] = -1;
                    colArray[j] = -1;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (rowArray[i] == -1 || colArray[j] == -1) {
                    a[i][j] = 0;
                }
            }
        }
        return a;
    }
}
