import java.util.ArrayList;
import java.util.List;

public class P301_删除无效的括号 {
    ArrayList<String> ans = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        if(s.length() == 0) {
            ans.add("");
            return ans;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            }else if(s.charAt(i) == ')') {
                if(left > 0) left--;
                else { right++; }
            }
        }
        dfs(s,left,right,0);
        return ans;
    }

    public void dfs(String s, int left, int right, int pos) {
        if(left == 0 && right == 0) {
            if(check(s)) {
                ans.add(s);
            }
        }else {
            for (int i = pos; i < s.length(); i++) {
                if(i - 1 >= pos && s.charAt(i-1) == s.charAt(i)) continue;
                if(left > 0 && s.charAt(i) == '(') {
                    dfs(s.substring(0, i) + s.substring(i+1, s.length()),left - 1,
                            right, i);
                }
                if(right > 0 && s.charAt(i) == ')') {
                    dfs(s.substring(0,i) + s.substring(i+1, s.length()),
                            left, right-1, i);
                }
            }
        }
    }

    private boolean check(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            }else if(s.charAt(i) == ')') {
                if(left > 0) left--;
                else return false;
            }
        }
        return left == 0;
    }
}
