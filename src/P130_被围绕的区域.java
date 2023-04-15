import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;

public class P130_被围绕的区域 {
    public int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) {
            return;
        }
        boolean[][] visit = new boolean[board.length][board[0].length];
        LinkedList<Pair<Integer,Integer>> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') {
                queue.add(new Pair<>(i,0));
            }
            if(board[i][board[0].length - 1] == 'O'){
                queue.add(new Pair<>(i, board[0].length - 1));
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if(board[0][i] == 'O') {
                queue.add(new Pair<>(0,i));
            }
            if(board[board.length - 1][i] == 'O'){
                queue.add(new Pair<>(board.length - 1, i));
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer,Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();
            if(!visit[x][y]) {
                visit[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    int dx = x + dxy[i][0];
                    int dy = y + dxy[i][1];
                    if(!(dx<0 || dy<0 || dx >=board.length || dy>= board[0].length)
                            && board[dx][dy] == 'O' && !visit[dx][dy]) {
                        queue.add(new Pair<>(dx,dy));
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O' && !visit[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    @Test
    public void test() {
        char[][] a = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(a);
    }
}
