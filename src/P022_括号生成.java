import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P022_括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> s = new ArrayList<>();
        if(n==0) {
            return s;
        }
        if(n==1) {
            s.add("()");
            return s;
        }
        List<String> old = generateParenthesis(n-1);
        for (int i = 0; i < old.size(); i++) {
            String m = old.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m.length(); j++) {
                sb.append(m, 0, j+1);
                sb.append("()");
                if(j+1 != m.length()) {
                    sb.append(m,j+1,m.length());
                }
                s.add(sb.toString());
                sb.delete(0,sb.length());
            }
        }
        HashSet<String> hs = new HashSet<>();
        hs.addAll(s);
        s.clear();
        s.addAll(hs);
        return s;
    }

    @Test
    public void test() {
        List<String> s = generateParenthesis(3);
        System.out.println(s);
    }
}
