import java.util.Stack;

public class P面试题09_用两个栈实现队列 {
    Stack<Integer> s1,s2;
    public P面试题09_用两个栈实现队列() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s2.push(value);
    }

    public int deleteHead() {
        if(!s1.isEmpty()) {
            return s1.pop();
        }else{
            while (!s2.isEmpty()) s1.push(s2.pop());
            if(s1.isEmpty()) return -1;
            else  return s1.pop();
        }
    }
}
