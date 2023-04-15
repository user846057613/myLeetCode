import java.util.LinkedList;

public class P207_课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            degrees[prerequisite[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(degrees[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;
            for (int[] prerequisite : prerequisites) {
                if(prerequisite[1] == course) {
                    degrees[prerequisite[0]]--;
                    if(degrees[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }
        if(numCourses == 0) {
            return true;
        }else {
            return false;
        }
    }
}
