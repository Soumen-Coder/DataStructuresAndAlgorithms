package recurrsion;

import java.util.ArrayList;
import java.util.List;

//Maze is a 2D Matrix of nXn size and n is the where the rat has to reach, ie the last of the maze (n-1, n-1)
//Return the List in a Lexicographically sorted manner
//0 is the prohibited path and 1 is the path which the rat can take
public class RatInAMaze {
    public static void main(String[] args) {
         int[][] maze = new int[][]{{1,0,0,0}, {1,1,0,1}, {1,1,0,0}, {0,1,1,1}};
         int n=4;
         List<List<String>> output = searchPath(maze,n);
         System.out.println(output);
    }
    public static List<List<String>> searchPath(int[][] maze, int n){
        List<List<String>> answer = new ArrayList<>();
        help(0,0,n,maze, new ArrayList<>(), answer);
        return answer;
    }

    public static void help(int i, int j, int n, int[][] maze, List<String> path, List<List<String>> answer){
        if(i<0 || j<0 || i==n || j==n || maze[i][j]==0)return;

        else if(i==n-1 && j==n-1){
            answer.add(path);
            return;
        }

        else {
            //set value of cell to 0, so that we don't revisit the cell again, and we don't go in a loop
            maze[i][j] = 0;

            path.add("D");
            help(i + 1, j, n, maze, new ArrayList(path), answer);
            //Backtracking
            path.remove(path.size()-1); //Always use the remove(index), if you use the remove(object), the answer will not be lexicographic and will result in wrong answer

            path.add("L");
            help(i, j - 1, n, maze, new ArrayList(path), answer);
            //Backtracking
            path.remove(path.size()-1);

            path.add("R");
            help(i, j + 1, n, maze, new ArrayList(path), answer);
            //Backtracking
            path.remove(path.size()-1);

            path.add("U");
            help(i - 1, j, n, maze, new ArrayList(path), answer);
            //Backtracking
            path.remove(path.size()-1);

            //Backtracking
            maze[i][j] = 1;
        }
    }
}
