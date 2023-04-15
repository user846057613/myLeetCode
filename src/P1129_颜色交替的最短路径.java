import java.util.ArrayList;

public class P1129_颜色交替的最短路径 {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        ArrayList<ArrayList<Integer>> red = new ArrayList<>();
        ArrayList<ArrayList<Integer>> blue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            red.add(new ArrayList<Integer>());
            blue.add(new ArrayList<>());
        }
        for (int i = 0; i < red_edges.length; i++) {
            red.get(red_edges[i][0]).add(red_edges[i][1]);
        }

        for (int i = 0; i < blue_edges.length; i++) {
            blue.get(blue_edges[i][0]).add(blue_edges[i][1]);
        }

        int[][] ans = new int[n][2]; //0为红色， 1 为蓝色
        for (int i = 0; i < n; i++) {
            ans[i][0] = Integer.MAX_VALUE;
            ans[i][1] = Integer.MAX_VALUE;
        }
        ans[0][0] = 0;
        ans[0][1] = 0;

        dfs(0,0,red,blue,ans);
        dfs(0,1,red,blue,ans);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.min(ans[i][0], ans[i][1]);
            if(res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }

    private void dfs(int start, int color, ArrayList<ArrayList<Integer>> red, ArrayList<ArrayList<Integer>> blue, int[][] ans) {
        ArrayList<ArrayList<Integer>> graph = color == 0 ? red : blue;
        for(Integer end : graph.get(start)) {
            if(ans[start][color] + 1 < ans[end][Math.abs(color-1)]) {
                ans[end][Math.abs(color-1)] = ans[start][color] + 1;
                dfs(end, Math.abs(color-1), red, blue, ans);
            }
        }
    }
}
