import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P077_组合 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        solve(n,0,0,k,new LinkedList<>());
        return ans;
    }

    private void solve(int n,int num, int pos, int k, LinkedList<Integer> oneAns) {
        if(pos == k) {
            ans.add(new ArrayList<>(oneAns));
            return;
        }
        if(num + k - pos > n ) return;  //剪枝
        for (int i = num+1; i <= n; i++) {
            oneAns.add(i);
            solve(n, i,pos+1, k, oneAns);
            oneAns.removeLast();
        }
    }
}
