import org.junit.Test;

import java.util.*;

public class P039_组合总和 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        if(length == 0) {
            return result;
        }
        Arrays.sort(candidates);

        LinkedList<Integer> stack = new LinkedList<>();
        findAll(candidates,target, stack, 0);
        return result;
    }

    private void findAll(int[] candidates, int target, LinkedList<Integer> stack, int index) {
        if(target == 0) {
            result.add(new LinkedList<>(stack));
            return ;
        }

        for (int i = index; i < candidates.length; i++) {
            if(target - candidates[i] >= 0) {
                stack.addLast(candidates[i]);
                findAll(candidates, target-candidates[i], stack, i);
                stack.removeLast();
            }else {
                return;
            }
        }
    }

    @Test
    public void test() {
        int[] num = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(num, target));

    }
}
