package arrays;

import java.util.Arrays;

public class Minesweeper_easy {

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] bombs1 = {{0, 2}, {2, 0}};
        System.out.println(Arrays.deepToString(mineSweeper(bombs1, 3, 3)));// should return:
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        System.out.println(Arrays.deepToString(mineSweeper(bombs2, 3, 4))); // should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        System.out.println(Arrays.deepToString(mineSweeper(bombs3, 5, 5)));// should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
    }

    public static int[][] mineSweeper(int[][] bombs, int rows, int columns){
        int[][] field = new int[rows][columns];
        int row = 0;
        int column = 0;
        for(int[] bomb: bombs) {
            row = bomb[0];
            column = bomb[1];
            field[row][column] = -1;

            for (int i = row - 1; i < row + 2; i++) {
                for (int j = column - 1; j < column + 2; j++) {
                    if (i >= 0 && i < rows &&
                            j >= 0 && j < columns &&
                            field[i][j] != -1) {
                        field[i][j] += 1;
                    }
                }
            }
        }
        return field;
    }
}
