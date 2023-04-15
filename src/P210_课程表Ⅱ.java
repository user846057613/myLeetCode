import java.util.LinkedList;

public class P210_课程表Ⅱ {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] edgeNum = new int[numCourses];
        if(numCourses == 0) {
            return new int[0];
        }
        for (int i = 0; i < prerequisites.length; i++) {
            edgeNum[prerequisites[i][0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < edgeNum.length; i++) {
            if(edgeNum[i] == 0) {
                queue.add(i);
                edgeNum[i] = -1;
            }
        }
        if(queue.isEmpty()) {
            return new int[0];
        }
        int num = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            ans[num++] = now;
            for (int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == now) {
                    edgeNum[prerequisites[i][0]]--;
                }
            }
            for (int i = 0; i < numCourses; i++) {
                if(edgeNum[i] == 0) {
                    queue.add(i);
                    edgeNum[i] = -1;
                }
            }
        }
        if(num < numCourses) {
            return new int[0];
        }else{
            return ans;
        }
    }
}
