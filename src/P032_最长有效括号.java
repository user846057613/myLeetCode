import java.util.LinkedList;
import java.util.Stack;

public class P032_最长有效括号 {

    public int longestValidParentheses3(String s) {
        int maxLength = 0;
        if(s.equals("") || s == null) {
            return 0;
        }
        int[] dp = new int[s.length()];
        for (int i = 1; i < dp.length; i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = i -2 >= 0 ? dp[i-2] + 2 : 2;
                }else if(i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
                        dp[i] = dp[i-1] + ((i - dp[i-1]) >= 2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }


    public int longestValidParentheses(String s) {
        int maxLength = 0;
        if(s.equals("") || s == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }else{
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    public int longestValidParentheses2(String s) {
        int maxLength = 0;
        if(s.equals("") || s == null) {
            return 0;
        }

        LinkedList<Character> deque = new LinkedList<>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                deque.push(c);
            }else if(c == ')') {
                if(!deque.isEmpty()) {
                    deque.pop();
                    length++;
                }
            }
            if(deque.isEmpty()){
                maxLength = Math.max(length, maxLength);
                length = 0;
            }
        }
        maxLength = Math.max(length, maxLength);
        return maxLength*2;
    }
}
