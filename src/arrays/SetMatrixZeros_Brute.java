package arrays;

import java.util.Arrays;

public class SetMatrixZeros_Brute {
    public static void main(String[] args) {
        //int[][] a = {{1,1,1}, {1,0,1}, {1,1,1}};
        int[][] a = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("-----------BEFORE-------------");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        int[][] convertedToNegative1 = setMatrixNegative1(a);
        System.out.println("----------CONVERTED TO NEGATIVE------------");
        for (int i = 0; i < convertedToNegative1.length; i++) {
            for (int j = 0; j < convertedToNegative1[0].length; j++) {
                System.out.print(convertedToNegative1[i][j]+" ");
            }
            System.out.println();
        }


        int[][] output = setMatrixZeros(convertedToNegative1);
        System.out.println("------------AFTER----------------");
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }

        //System.out.println(Arrays.deepToString(output));
    }

    private static int[][] setMatrixZeros(int[][] convertedToNegative1) {
        for (int i = 0; i < convertedToNegative1.length; i++) {
            for (int j = 0; j < convertedToNegative1[0].length; j++) {
                if (convertedToNegative1[i][j] <= 0) {
                    convertedToNegative1[i][j] = 0;
                }
            }
        }
        return convertedToNegative1;
    }

    private static int[][] setMatrixNegative1(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(a[i][j] == 0){
                    int ind = i-1;
                    while(ind>=0){
                        if(a[ind][j]!=0) {
                            a[ind][j] = -1;
                        }
                        ind--; // always increment outside if condition, otherwise chances of going in infinite loop
                    }
                    //making columns as -1 other than the first one which remains 0
                    ind = i+1;
                    while(ind<a.length) {
                        if(a[ind][j]!=0) {
                            a[ind][j] = -1;
                        }
                        ind++;
                    }
                    ind = j-1;
                    while(ind>=0) {
                        if(a[i][ind]!=0) {
                            a[i][ind] = -1;
                        }
                        ind--;
                    }
                    ind = j+1;
                    while(ind<a[0].length) {
                        if(a[i][ind]!=0) {
                            a[i][ind] = -1;
                        }
                        ind++;
                    }
                }
            }

        }
        return a;
    }
}
