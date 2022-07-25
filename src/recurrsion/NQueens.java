package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle.
*/
public class NQueens {
    public static void main(String[] args) {
        List<List<String>> output = solveNQueens(4);
        System.out.println("***********OUTPUT************");
        System.out.println(output); //[[0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0], [0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0]]
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        int[] col = new int[n];
        int[] rightDiagonal = new int[2*n]; //Mark diagonals with 2*n elements
        int[] leftDiagonal = new int[2*n];  //Mark diagonals with 2*n elements
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < chessBoard[0].length; k++) {
                chessBoard[j][k] = '.';
            }
        }
        return helper(0, n, chessBoard, new ArrayList<>(), col, rightDiagonal, leftDiagonal);
    }

    public static List<List<String>> helper(int i, int n, char[][] chessBoard, List<List<String>> answer, int[]col, int[]leftDiagonal, int[]rightDiagonal){
        if(i == n){
            List<String> solution = new ArrayList<>();
            String str = "";
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < chessBoard[0].length; k++) {
                    str+=String.valueOf(chessBoard[j][k]);
                }
                solution.add(str);
                str="";
            }
            answer.add(solution);
            return answer;
        }

        for (int j = 0; j < n ; j++) {
            //if(isSafe(i, j, chessBoard, n)){  ==> Less optimized using isSafe
            if(col[j]==0 && leftDiagonal[(i-j)+(n-1)]==0 && rightDiagonal[i+j]==0){ //More optimized with tracker arrays
                chessBoard[i][j] = 'Q';
                col[j]=leftDiagonal[(i-j)+(n-1)]=rightDiagonal[i+j]=1;
                helper(i+1, n, chessBoard, answer, col, rightDiagonal, leftDiagonal); // increment value of i, place queen in next row if safe
                //Backtracking
                chessBoard[i][j] = '.';
                col[j]=leftDiagonal[(i-j)+(n-1)]=rightDiagonal[i+j]=0;
            }
        }
        return answer;
    }

    private static boolean isSafe(int i, int j, char[][] chessBoard, int n) {
        int tempI, tempJ;

        //Remember to reset tempI and tempJ in every checking
        //Check in UP direction
        tempI = i;
        while(tempI>=0){
            if(chessBoard[tempI][j]=='Q') return false;
            tempI--;
        }

        //Check in TOP RIGHT Direction
        tempI = i;
        tempJ = j;
        while(tempI>=0 && tempJ<=n-1){
            if(chessBoard[tempI][tempJ]=='Q') return false;
            tempI--;
            tempJ++;
        }

        //Check im TOP LEFT Direction
        tempI = i;
        tempJ = j;
        while(tempI>=0 && tempJ>=0){
            if(chessBoard[tempI][tempJ]=='Q') return false;
            tempI--;
            tempJ--;
        }

        return true;
    }
}
