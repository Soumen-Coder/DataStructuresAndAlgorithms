package arrays;

public class SudokoSolver {

    public static void main(String[] args) {
        /*int[][] board = {
                {7,0,2,0,5,0,6,0,0},
                {0,0,0,0,0,3,0,0,0},
                {1,0,0,0,0,9,5,0,0},
                {8,0,0,0,0,0,0,9,0},
                {0,4,3,0,0,0,7,5,0},
                {0,9,0,0,0,0,0,0,8},
                {0,0,9,7,0,0,0,0,5},
                {0,0,0,2,0,0,0,0,0},
                {0,0,7,0,4,0,2,0,3},
        };*/

        int[][] board = {
                {4,3,0,0},
                {1,2,3,0},
                {0,0,2,0},
                {2,1,0,0},
        };

        if(solver(board)){
            System.out.println("Solved Successfully!!!!");
        }else{
            System.out.println("Unsolvable");
        }

        printBoard(board);
    }

    private static void printBoard(int[][] board) {
        int sqrt = (int)Math.sqrt(board.length);
        for (int i = 0; i < board.length; i++) {
            if(i%sqrt==0 && i!=0){
                System.out.println("------------");
            }
            for (int j = 0; j < board.length; j++) {
                if(j%sqrt==0 && j!=0){
                    System.out.print("|");
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isNumberInRow(int[][] board, int number, int row){
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberInColumn(int[][] board, int number, int column){
        for (int i = 0; i < board.length; i++) {
            if(board[i][column] == number){
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberInBox(int[][] board, int number, int row, int column){
        int sqrt = (int)Math.sqrt(board.length);
        int lastBoxRow = row - row%sqrt;
        int lastBoxColumn = column - column%sqrt;
        for (int i = lastBoxRow; i < lastBoxRow + sqrt; i++) {
            for (int j = lastBoxColumn; j < lastBoxColumn + sqrt; j++) {
                if(board[i][j] == number){
                    return true;
                }
            }
        }
      return false;
    }

    public static boolean isValidPlacement(int[][] board, int number, int row, int column){
        return !isNumberInRow(board, number, row) &&
                 !isNumberInColumn(board, number, column) &&
                   !isNumberInBox(board, number, row, column);
    }

    public static boolean solver(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    for (int numberToTry = 1; numberToTry <= board.length; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, i, j)) {
                            board[i][j] = numberToTry;

                            if (solver(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}
