import java.util.*;

public class P040_组合综合 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        getAns(candidates, target, 0, 0, ans, new LinkedList<Integer>());
        return ans;
    }

    private void getAns(int[] candidates, int target, int sum,
                        int pos,  List<List<Integer>> lists , LinkedList<Integer> oneAns) {
        if(sum == target) {
            lists.add(new ArrayList<>(oneAns));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if(sum > target ) return;
            if(i > pos && candidates[i] == candidates[i-1]) continue;
            oneAns.add(candidates[i]);
            getAns(candidates, target, sum + candidates[i], i + 1,
                    lists, oneAns);
            oneAns.removeLast();
        }
    }
}
