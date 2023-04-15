import java.util.Stack;

public class P020_有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                if(!stack.isEmpty()) {
                    char top = stack.pop();
                    if((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top =='{')) {
                        continue;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
