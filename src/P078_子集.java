import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P078_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        result = findResult(nums,nums.length-1);
        return result;
    }

    private List<List<Integer>> findResult(int[] nums, int i) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        if(i == 0) {
            one.add(nums[i]);
            result.add(one);
            result.add(new ArrayList<>());
            return result;
        }
        result = findResult(nums, i - 1);
        List<List<Integer>> newAns = new ArrayList<>();
        for (int j = 0; j < result.size(); j++) {
            ArrayList<Integer> temp = new ArrayList<>(result.get(j));
            temp.add(nums[i]);
            newAns.add(temp);
        }
        result.addAll(newAns);
        return result;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3};
        subsets(nums);
    }
}
