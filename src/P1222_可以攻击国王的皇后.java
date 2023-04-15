import java.util.ArrayList;
import java.util.List;

public class P1222_可以攻击国王的皇后 {
    public int[][] dxy = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
    public int[][] graph;
    int m,n;
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int xMax = king[0];
        int yMax = king[1];
        for (int i = 0; i < queens.length; i++) {
            xMax = Math.max(xMax, queens[i][0]);
            yMax = Math.max(yMax, queens[i][1]);
        }
        this.m = xMax + 1;
        this.n = yMax + 1;
        graph = new int[m][n];
        for (int i = 0; i < queens.length; i++) {
            graph[queens[i][0]][queens[i][1]] = 1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ArrayList<Integer> res = search(king[0],king[1],dxy[i]);
            if(!res.isEmpty()) ans.add(res);
        }
        return ans;
    }

    private ArrayList<Integer> search(int x, int y, int[] ints) {
        int dx = ints[0];
        int dy = ints[1];
        ArrayList<Integer> res = new ArrayList<>();
        while (0 <= x + dx && x + dx < m && 0 <= y + dy && y + dy < n) {
            x += dx;
            y += dy;
            if(graph[x][y] == 1) {
                res.add(x);
                res.add(y);
                break;
            }
        }
        return res;
    }
}
