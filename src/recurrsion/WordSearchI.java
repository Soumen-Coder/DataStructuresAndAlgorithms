package recurrsion;

public class WordSearchI {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        boolean result = exist(board, word);
        System.out.println(result);
    }
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0))
                    if(search(i, j, board, board.length, board[0].length, word, 0))
                        return true;
            }
        }
        return false;
    }

    public static boolean search(int x, int y, char[][]board, int m, int n, String word, int k){
        boolean option1, option2, option3, option4;
        if(k >= word.length())return true;

        if(x<0 || y<0 || x==m || y==n || board[x][y]!=word.charAt(k)) return false;

        char ch = board[x][y];
        board[x][y] = '#';

        option1 = search(x+1, y, board, m, n, word, k+1);
        option2 = search(x-1, y, board, m, n, word, k+1);
        option3 = search(x, y+1, board, m, n, word, k+1);
        option4 = search(x, y-1, board, m, n, word, k+1);

        board[x][y] = ch;

        return option1||option2||option3||option4;
    }
}
