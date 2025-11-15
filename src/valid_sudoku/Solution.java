package valid_sudoku;

public class Solution {

    public static boolean isValidSudoku(char[][] board) {
        // Check rows and columns contains no duplicate digits
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[10];
            boolean[] col = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    int rowElem = Integer.parseInt(String.valueOf(board[i][j]));
                    if (row[rowElem]) {
                        return false;
                    } else {
                        row[rowElem] = true;
                    }
                }

                if (Character.isDigit(board[j][i])) {
                    int colElem = Integer.parseInt(String.valueOf(board[j][i]));
                    if (col[colElem]) {
                        return false;
                    } else {
                        col[colElem] = true;
                    }
                }
            }
        }

        // Check 3x3 sub-boxes contains no duplicate digits
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] cell = new boolean[10];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (Character.isDigit(board[i * 3 + k][j * 3 + l])) {
                            int num = Integer.parseInt(String.valueOf(board[i * 3 + k][j * 3 + l]));
                            if (cell[num]) {
                                return false;
                            } else {
                                cell[num] = true;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    static void main() {
        char[][] board = new char[][]{
            new char[]{'5','3','.','.','7','.','.','.','.'},
            new char[]{'6','.','.','1','9','5','.','.','.'},
            new char[]{'.','9','8','.','.','.','.','6','.'},
            new char[]{'8','.','.','.','6','.','.','.','3'},
            new char[]{'4','.','.','8','.','3','.','.','1'},
            new char[]{'7','.','.','.','2','.','.','.','6'},
            new char[]{'.','6','.','.','.','.','2','8','.'},
            new char[]{'.','.','.','4','1','9','.','.','5'},
            new char[]{'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));

        char[][] board2 = new char[][]{
            new char[]{'8','3','.','.','7','.','.','.','.'},
            new char[]{'6','.','.','1','9','5','.','.','.'},
            new char[]{'.','9','8','.','.','.','.','6','.'},
            new char[]{'8','.','.','.','6','.','.','.','3'},
            new char[]{'4','.','.','8','.','3','.','.','1'},
            new char[]{'7','.','.','.','2','.','.','.','6'},
            new char[]{'.','6','.','.','.','.','2','8','.'},
            new char[]{'.','.','.','4','1','9','.','.','5'},
            new char[]{'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board2));

        char[][] board3 = new char[][]{
            new char[]{'.','.','.','9','.','.','.','.','.'},
            new char[]{'.','.','.','.','.','.','.','.','.'},
            new char[]{'.','.','3','.','.','.','.','.','1'},
            new char[]{'.','.','.','.','.','.','.','.','.'},
            new char[]{'1','.','.','.','.','.','3','.','.'},
            new char[]{'.','.','.','.','2','.','6','.','.'},
            new char[]{'.','9','.','.','.','.','.','7','.'},
            new char[]{'.','.','.','.','.','.','.','.','.'},
            new char[]{'8','.','.','8','.','.','.','.','.'}
        };
        System.out.println(isValidSudoku(board3));
    }

}
