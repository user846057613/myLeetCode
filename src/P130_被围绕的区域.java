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

    public void solve2(char[][] board) {
        if(board.length == 0) return;
        int y = board.length;
        int x = board[0].length;

        boolean[][] isVisit = new boolean[y][x];
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if(board[i][j] == 'O' && (i == 0 || i == y-1 || j == 0|| j == x-1) && !isVisit[i][j]) {
                    isVisit[i][j] = true;
                    dfs(y, x ,i , j, isVisit, board);
                }
            }
        }

        fillX(isVisit, board);
    }

    public void dfs(int maxY, int maxX, int y, int x, boolean[][] isVisit, char[][] board) {

        for(int i = 0; i < dxy.length; i++) {
            int dy = y + dxy[i][0];
            int dx = x + dxy[i][1];

            if(dy < 0 || dy >= maxY || dx < 0 || dx >= maxX) {
                continue;
            }

            if(isVisit[dy][dx]) {
                continue;
            }

            if(board[dy][dx] == 'O' && !isVisit[dy][dx]) {
                isVisit[dy][dx] = true;
                dfs(maxY, maxX, dy, dx, isVisit, board);
            }
        }
    }

    public void fillX(boolean[][] isVisit , char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O' && !isVisit[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
