import java.util.LinkedList;

public class P面试题59Ⅱ_队列的最大值 {
    LinkedList<Integer> queue;
    LinkedList<Integer> maxValue;
    public P面试题59Ⅱ_队列的最大值() {
        queue = new LinkedList<>();
        maxValue = new LinkedList<>();
    }

    public int max_value() {
        return maxValue.isEmpty() ? -1 : maxValue.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxValue.isEmpty() && maxValue.peekLast() < value) maxValue.pollLast();
        maxValue.offer(value);
    }

    public int pop_front() {
        int val = queue.isEmpty() ? -1 : queue.poll();
        if(!maxValue.isEmpty() && maxValue.peekFirst() == val) maxValue.poll();
        return val;
    }
}
