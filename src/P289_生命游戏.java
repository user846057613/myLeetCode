public class P289_生命游戏 {
    int[][] dxy = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    int x, y;
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) {
            return;
        }
        x = board.length;
        y = board[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int dx = i + dxy[k][0];
                    int dy = j + dxy[k][1];
                    if(test(dx,dy)) {
                        if(Math.abs(board[dx][dy]) == 1) {
                            count++;
                        }
                    }
                }
                if(board[i][j] == 1 &&(count < 2 || count>3)) {
                    board[i][j] = -1;
                }else if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(board[i][j] == -1) {
                    board[i][j] = 0;
                }else if(board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
        return;
    }

    private boolean test(int dx, int dy) {
        if(dx < 0 || dx >= x || dy < 0 || dy >= y) {
            return false;
        }
        return true;
    }
}
