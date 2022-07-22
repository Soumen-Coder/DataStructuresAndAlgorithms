package recurrsion;

//An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
//
//You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
//
//To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
//
//Return the modified image after performing the flood fill.
public class FloodFillAlgo {
    public static void main(String[] args) {
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int[][] result = floodFill(image, sr, sc, color);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return flood(sr, sc, image, image[sr][sc], color, image.length, image[0].length);
    }

    public static int[][] flood(int x, int y, int[][]image, int oldColor, int newColor, int m, int n){
        if(oldColor == newColor) return image;
        if(x<0 || y<0 || x==m || y==n || image[x][y]!= oldColor) return image;

        image[x][y] = newColor;
        flood(x+1, y, image, oldColor, newColor, m, n);
        flood(x-1, y, image, oldColor, newColor, m, n);
        flood(x, y+1, image, oldColor, newColor, m, n);
        flood(x, y-1, image, oldColor, newColor, m, n);

        return image;
    }
}
