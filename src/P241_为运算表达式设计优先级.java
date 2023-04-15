import org.junit.Test;

import java.util.*;

public class P241_为运算表达式设计优先级 {
    public List<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(input.length() == 0) return ans;
        HashMap<String, ArrayList<Integer>> dp = new HashMap<>();
        dp.put("",new ArrayList<Integer>(){{add(0);}});
        ans.addAll(helper(input, dp));
        Collections.sort(ans);
        return ans;
    }

    private ArrayList<Integer> helper(String input, HashMap<String, ArrayList<Integer>> dp) {
        if(dp.containsKey(input)){
            return dp.get(input);
        }
        if(!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            dp.put(input, new ArrayList<Integer>(){{add(Integer.parseInt(input));}});
            return dp.get(input);
        }
        String first = "";
        int pos = 0;
        ArrayList<Integer> r = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char op = input.charAt(i);
            if(op == '+' || op == '-' || op == '*') {
                first = input.substring(pos,i);
                String second = input.substring(i+1);
                ArrayList<Integer> r1 = helper(first, dp);
                ArrayList<Integer> r2 = helper(second, dp);
                for (Integer op1 : r1) {
                    for (Integer op2 : r2) {
                        if(op == '+') {
                            r.add(op1 + op2);
                        }else if(op == '-') {
                            r.add(op1 - op2);
                        }else if(op == '*') {
                            r.add(op1*op2);
                        }
                    }
                }
            }
        }
        dp.put(input, r);
        return r;
    }

    @Test
    public void test() {
        diffWaysToCompute("2*3-4*5");
    }
}
