import java.util.HashMap;
import java.util.HashSet;

public class P036_有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] >= '1' && board[i][j] <= '9') {
                    if(!set.contains(board[i][j])) {
                        set.add(board[i][j]);
                    }else {
                        return false;
                    }
                }
                if(board[j][i] >= '1' && board[j][i] <= '9' ) {
                    if(!colSet.contains(board[j][i])) {
                        colSet.add(board[j][i]);
                    }else {
                        return false;
                    }
                }
            }
            set.clear();
            colSet.clear();
        }

        for (int i = 0; i < 3; i++) {
            set.clear();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (board[3 * i + j][k] >= '1' && board[3 * i + j][k] <= '9') {
                        if (!set.contains(board[3 * i + j][k])) {
                            set.add(board[3 * i + j][k]);
                        } else {
                            return false;
                        }
                    }
                }
            }
            set.clear();
            for (int j = 0; j < 3; j++) {
                for (int k = 3; k < 6; k++) {
                    if (board[3 * i + j][k] >= '1' && board[3 * i + j][k] <= '9') {
                        if (!set.contains(board[3 * i + j][k])) {
                            set.add(board[3 * i + j][k]);
                        } else {
                            return false;
                        }
                    }
                }
            }
            set.clear();
            for (int j = 0; j < 3; j++) {
                for (int k = 6; k < 9; k++) {
                    if (board[3 * i + j][k] >= '1' && board[3 * i + j][k] <= '9') {
                        if (!set.contains(board[3 * i + j][k])) {
                            set.add(board[3 * i + j][k]);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
