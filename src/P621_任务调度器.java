import org.junit.Test;

import java.util.*;

public class P621_任务调度器 {
    class Task implements Comparable<Task>{
        char taskName;
        int taskNum;
        int waitTime;

        public Task(char taskName, int taskNum, int waitTime) {
            this.taskName = taskName;
            this.taskNum = taskNum;
            this.waitTime = waitTime;
        }

        @Override
        public int compareTo(Task o) {
            if(this.waitTime == o.waitTime) {
                return o.taskNum < this.taskNum ? -1 : (o.taskNum == this.taskNum ? 0 : 1);
            }else {
                return this.waitTime < o.waitTime ? -1 : 1;
            }
        }
    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            taskMap.put(tasks[i], taskMap.getOrDefault(tasks[i], 0) + 1);
        }
        ArrayList<Task> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : taskMap.entrySet()) {
            Task t = new Task(entry.getKey(), entry.getValue(), 0);
            list.add(t);
        }

        int time = 0;
        while (!list.isEmpty()) {
            Collections.sort(list);
            Task task = list.get(0);
            int wait = task.waitTime;
            if(task.taskNum == 0) {
                list.remove(0);
                continue;
            }else {
                time++;
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).waitTime > 0) {
                        list.get(i).waitTime--;
                    }
                }
                if(wait == 0) {
                    list.get(0).waitTime = n;
                    list.get(0).taskNum--;
                }
            }
        }
        return time;
    }

    @Test
    public void test() {
        char[] t = {'A','A','A','B','B','B'};
        int m = leastInterval(t,2);
        System.out.println(m);
    }
}
