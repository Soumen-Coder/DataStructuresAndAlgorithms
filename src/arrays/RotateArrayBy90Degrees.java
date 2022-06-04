package arrays;

import java.util.Arrays;
class RotateArrayBy90Degrees {
  public static void main(String[] args) {
      // NOTE: The following input values will be used for testing your solution.
      int matrix1[][] = {{1, 2, 3},
              {4, 5, 6},
              {7, 8, 9}};
      // rotate(a1, 3) should return:
      // [[7, 4, 1],
      //  [8, 5, 2],
      //  [9, 6, 3]]

      int matrix2[][] = {{1, 2, 3, 4},
              {5, 6, 7, 8},
              {9, 10, 11, 12},
              {13, 14, 15, 16}};
      // rotate(a2, 4) should return:
      // [[13, 9, 5, 1],
      //  [14, 10, 6, 2],
      //  [15, 11, 7, 3],
      //  [16, 12, 8, 4]]
    RotateArrayBy90Degrees mn = new RotateArrayBy90Degrees();
    int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
    mn.rotateMatrix(matrix1);
      mn.rotateMatrix(matrix2);
    System.out.println(Arrays.deepToString(matrix1)); //output = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
      System.out.println("============================================================================");
      System.out.println("============================================================================");
      System.out.println("============================================================================");
      System.out.println(Arrays.deepToString(matrix2));


  }

  public boolean rotateMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
    int n = matrix.length;

    //Transpose of a matrix but not twice , hence col starts from row
    for (int row = 0; row < matrix.length; row++) {
      for(int col = row; col < matrix[0].length; col++){
        int temp=matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
      }
    }

    //Reversing the 1st column with 3rd in 3x3 matrix so the last column tends to proceed towards center, the center column though remains untouched
    //Hence col<n/2

    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n/2; col++) {
        int temp=matrix[row][col];
        matrix[row][col] = matrix[row][n-1-col];
        matrix[row][n-1-col] = temp;
      }

    }

    return true;

  }


}
