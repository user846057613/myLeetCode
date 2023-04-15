import org.junit.Test;

import java.util.Stack;

public class P227_基本计算器Ⅱ {
    public int calculate(String s) {
        int ans = 0;
        if(s.length()==0 || s.equals("")) {
            return ans;
        }
        Stack<String> stack = new Stack<>();
        boolean flag = false;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if(!flag) {
                    begin = i;
                    flag = true;
                }
                end = i+1;
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-') {
                if(flag) {
                    stack.push(s.substring(begin,end));
                    flag = false;
                }
                stack.push(s.charAt(i) + "");
            }else if(s.charAt(i) == '*' || s.charAt(i) == '/') {
                if(flag) {
                    stack.push(s.substring(begin,end));
                    flag = false;
                }
                stack.push(s.charAt(i) + "");
                int index = 0;
                i++;
                while (i < s.length() && s.charAt(i) == ' ') i++;
                for (int j = i; j < s.length(); j++) {
                    if(!(s.charAt(j) >= '0' && s.charAt(j) <= '9')) {
                        index = j-1;
                        break;
                    }
                }
                index = index == 0 ? s.length() - 1 : index;
                int op2 = Integer.parseInt(s.substring(i, index+1));
                String op = stack.pop();
                int op1 = Integer.parseInt(stack.pop());
                int result = 0;
                if(op.equals("*")) {
                    result = op1 * op2;
                }else if(op.equals("/")) {
                    result = op1 / op2;
                }
                stack.push(result+"");
                i = index;
            }else{
                if(flag) {
                    stack.push(s.substring(begin,end));
                    flag = false;
                }
                continue;
            }
        }
        if(flag) {
            stack.push(s.substring(begin,end));
        }
        Stack<String> stack2 = new Stack<>();
        while (!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        while (stack2.size() >= 3){
            int op2 = Integer.parseInt(stack2.pop());
            String op = stack2.pop();
            int op1 = Integer.parseInt(stack2.pop());
            int result = 0;
            if(op.equals("+")) {
                result = op1 + op2;
            }else if(op.equals("-")) {
                result = op1 - op2;
            }
            stack2.push(result+"");
        }
        ans = Integer.parseInt(stack2.pop());
        return ans;
    }

    @Test
    public void test() {
        calculate("3 + 5 / 2 * 2");
    }
}
