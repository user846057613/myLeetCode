public class P1266_访问所有点的最小时间 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        if(points.length == 0 || points.length == 1) return 0;
        int x = points[0][0],y = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int dx = points[i][0];
            int dy = points[i][1];
            int max = Math.max(Math.abs(dx-x), Math.abs(dy-y));
            ans += max;
            x = dx;
            y = dy;
        }
        return ans;
    }
}
