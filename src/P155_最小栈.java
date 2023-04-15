import java.util.LinkedList;

public class P155_最小栈 {
    /** initialize your data structure here. */
    LinkedList<Integer> stack;
    LinkedList<Integer> min;
    public P155_最小栈() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty()) {
            min.push(x);
        }else {
            min.push(x < min.peek() ? x :min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
