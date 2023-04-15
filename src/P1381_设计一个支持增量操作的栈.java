import java.util.*;

public class P1381_设计一个支持增量操作的栈 {
    Stack<Integer> stack;
    int[] inc;
    int capacity;
    public P1381_设计一个支持增量操作的栈(int maxSize) {
        stack = new Stack<>();
        inc = new int[1000];
        Arrays.fill(inc,0);
        this.capacity = maxSize;
    }

    public void push(int x) {
        if(stack.size() < capacity){
            stack.push(x);
        }
    }

    public int pop() {
        if(stack.isEmpty()) return -1;
        int n = stack.size();
        int val = inc[n-1];
        if(n - 2 >= 0) inc[n-2] += inc[n-1];
        inc[n-1] = 0;
        return stack.pop() + val;
    }

    public void increment(int k, int val) {
        int min = Math.min(stack.size(), k);
        if(min == 0) return;
        inc[min-1] += val;
    }
}
