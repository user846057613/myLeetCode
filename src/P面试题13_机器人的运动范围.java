import java.util.LinkedList;

public class P面试题13_机器人的运动范围 {
    int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
    public int movingCount(int m, int n, int k) {
        LinkedList<MyPair> queue = new LinkedList<>();
        queue.offer(new MyPair(0,0));
        int num = 0;
        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        while (!queue.isEmpty()) {
            MyPair pos = queue.poll();
            num++;
            for (int i = 0; i < dxy.length; i++) {
                int dx = pos.x + dxy[i][0];
                int dy = pos.y + dxy[i][1];
                if(inBound(dx,dy,m,n) && (getSum(dx,dy) <= k) && !visit[dx][dy]) {
                    visit[dx][dy] = true;
                    queue.offer(new MyPair(dx, dy));
                }
            }
        }
        return num;
    }

    private int getSum(int dx, int dy) {
        int sum = 0;
        String s = "" + dx + dy;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return sum;
    }

    private boolean inBound(int dx, int dy, int m, int n) {
        return dx >= 0 && dx < m && dy >= 0 && dy < n;
    }


}

class MyPair{
    int x , y;
    MyPair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
