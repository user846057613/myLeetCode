import org.junit.Test;

public class P079_单词搜索 {
    boolean[][] isVisit;
    int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
    int lengthX, lengthY;
    String match;
    boolean result = false;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            if(word.equals("")) {
                return true;
            }
            return false;
        }
        if(word.equals("")) {
            return true;
        }
        match = word;
        lengthX = board.length;
        lengthY = board[0].length;
        isVisit = new boolean[lengthX][lengthY];

        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                if(!isVisit[i][j] && board[i][j] == word.charAt(0)) {
                    if(!result) {
                        dfs(board,i,j,0);
                    }else {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, int pos) {
        if(i < 0 || i >= lengthX || j < 0 || j >= lengthY) {
            return;
        }
        if(!isVisit[i][j] && !result) {
            isVisit[i][j] = true;
            if(board[i][j] == match.charAt(pos)) {
                if(pos == match.length() - 1) {
                    result = true;
                    return;
                }
                for (int k = 0; k < dxy.length; k++) {
                    int x = i + dxy[k][0];
                    int y = j + dxy[k][1];
                    dfs(board, x, y, pos+1);
                }
            }
            isVisit[i][j] = false;
        }
    }
    @Test
    public void test() {
        char[][] m = {{'a','b'},{'c','d'}};
        String s = "cdba";
        System.out.println(exist(m, s));
    }
}
