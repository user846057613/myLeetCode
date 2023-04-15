import java.util.Stack;

public class P150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<>();
        if(tokens.length == 0) {
            return 0;
        }else{
            int result = 0;
            for (int i = 0; i < tokens.length; i++) {
                if(tokens[i].equals("+") || tokens[i].equals("-")
                ||tokens[i].equals("*") || tokens[i].equals("/")) {
                    if(num.size() > 1) {
                        int op2 = num.pop();
                        int op1 = num.pop();
                        dealOperation(num,op1,op2,tokens[i]);
                    }else{
                        break;
                    }
                }else{
                    num.push(Integer.parseInt(tokens[i]));
                }
            }
            result = num.pop();
            return result;
        }
    }

    public void dealOperation(Stack<Integer> stack ,int op1,int op2, String op){
        if(op.equals("+")) {
            stack.push(op1 + op2);
        }else if(op.equals("-")) {
            stack.push(op1 - op2);
        }else if(op.equals("*")) {
            stack.push(op1 * op2);
        }else if(op.equals("/")) {
            stack.push(op1 / op2);
        }
        return;
    }
}
