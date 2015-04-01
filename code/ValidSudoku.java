package code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created: 2/3/15 2:53 PM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9)
            return false;
        if (board[0].length != 9)
            return false;

        if (!checkLine(true, board))
            return false;

       if (!checkLine(false, board))
           return false;

        for (int i=0; i < 9; i+=3) {
            for (int j=0; j<9; j+=3) {
                if (!checkSquare(board, i, j))
                    return false;
            }
        }

        return true;
    }

    private boolean checkLine(boolean horizontal, char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < 9; j++) {

                char c;
                if (horizontal) {
                    c = board[i][j];
                }  else {
                    c = board[j][i];
                }

                if (c != '.') {
                    int val = Character.getNumericValue(c);

                    if (val < 1 || val > 9 || set.contains(val)) {
                        return false;
                    } else {
                        set.add(val);
                    }
                }
            }
        }
        return true;
    }

    private boolean checkSquare(char[][] board, int x, int y) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] != '.') {
                    int val = Character.getNumericValue(board[i][j]);
                    if (val < 1 || val > 9 || set.contains(val)) {
                        return false;
                    } else {
                        set.add(val);
                    }
                }
            }
        }
        return true;
    }




    public static void main(String[] args) {
        char[][] board = new char[9][9];

        String str = "..4...63.";
        board[0] = str.toCharArray();

        str = ".........";
        board[1] = str.toCharArray();

        str = "5......9.";
        board[2] = str.toCharArray();

        str = "...56....";
        board[3] = str.toCharArray();

        str = "4.3.....1";
        board[4] = str.toCharArray();

        str = "...7.....";
        board[5] = str.toCharArray();

        str = "...5.....";
        board[6] = str.toCharArray();

        str = ".........";
        board[7] = str.toCharArray();

        str = ".........";
        board[8] = str.toCharArray();

        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(board));

    }
}
