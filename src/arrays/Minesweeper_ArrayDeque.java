package arrays;

import java.util.ArrayDeque;

public class Minesweeper_ArrayDeque {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] field1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, -1, 1, 0}};

        // click(field1, 3, 5, 2, 2) should return:
        // [[0, 0, 0, 0, 0],
        //  [0, 1, 1, 1, 0],
        //  [0, 1, -1, 1, 0]]

        // click(field1, 3, 5, 1, 4) should return:
        // [[-2, -2, -2, -2, -2],
        //  [-2, 1, 1, 1, -2],
        //  [-2, 1, -1, 1, -2]]


        int[][] field2 = {{-1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, -1}};

        // click(field2, 4, 4, 0, 1) should return:
        // [[-1, 1, 0, 0],
        //  [1, 1, 0, 0],
        //  [0, 0, 1, 1],
        //  [0, 0, 1, -1]]

        // click(field2, 4, 4, 1, 3) should return:
        // [[-1, 1, -2, -2],
        //  [1, 1, -2, -2],
        //  [-2, -2, 1, 1],
        //  [-2, -2, 1, -1]]
    }

    // Implement your solution below.
    public static int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ) {
        ArrayDeque<int[]> deque = new ArrayDeque<int[]>();
        if(field[givenI][givenJ] == 0){
            field[givenI][givenJ] = -2;
            int[] coordinates = new int[]{givenI,givenJ};
            deque.add(coordinates);
        }else{
            return field;
        }


        while(!deque.isEmpty()){
            int[] coordinates = deque.remove();
            int current_i=coordinates[0];
            int current_j=coordinates[1];

            for(int i=current_i-1; i<current_i+2; i++){
                for(int j=current_j-1; j<current_j+2; j++){
                    if(i>=0 && i<numRows &&
                            j>=0 && j<numCols &&
                            field[i][j]==0){
                        field[i][j] =-2;
                        int[] newCoordinates = new int[]{i,j};
                        deque.add(newCoordinates);
                    }
                }
            }
        }
        return field;
    }
}
