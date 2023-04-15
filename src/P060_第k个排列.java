import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class P060_第k个排列 {
    String ans = "";
    int leftNum;
    public String getPermutation(int n, int k) {
        leftNum = k;
        dfs(new HashSet<>(), new LinkedList<>(), 0, n);
        return ans;
    }

    private void dfs(HashSet<Integer> set, LinkedList<String> oneAns, int counter, int n) {
        if(counter == n) {
            leftNum--;
            if(leftNum == 0) {
                StringBuilder sb = new StringBuilder();
                oneAns.forEach(string -> sb.append(string));
                ans = sb.toString();
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(set.contains(i)) continue;
            if(leftNum == 0) return;
            set.add(i);
            oneAns.add(i + "");
            dfs(set, oneAns, counter + 1, n);
            oneAns.removeLast();
            set.remove(i);
        }
    }

    @Test
    public void test() {
        System.out.println(getPermutation(3,3));
    }
}
