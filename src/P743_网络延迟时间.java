import java.util.Arrays;

public class P743_网络延迟时间 {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dis = new int[N+1];
        boolean[] visit = new boolean[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K] = 0;
        for (int i = 1; i <= N; i++) {
            int mark = -1;
            int minDis = Integer.MAX_VALUE;
            for (int j = 1; j <= N; j++) {
                if(!visit[j] && dis[j] <= minDis) {
                    mark = j;
                    minDis = dis[j];
                }
            }
           visit[mark] = true;
            for (int j = 0; j < times.length; j++) {
                if(times[j][0] == mark && !visit[times[j][1]]) {
                    dis[times[j][1]] = Math.min(dis[times[j][1]],
                            dis[times[j][0]] + times[j][2]);
                }
            }
        }
        int minTime = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            minTime = Math.max(dis[i], minTime);
        }
        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }
}
