import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P046_全排列 {

    List<List<Integer>> ans = new ArrayList<>();
    int length = 0;
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) {
            return ans;
        }
        this.length = nums.length;
        Arrays.sort(nums);
        ArrayList<Integer> result = new ArrayList<>();
        nextPermutation(nums,result,0);
        return ans;
    }

    private void nextPermutation(int[] nums, ArrayList<Integer> result,int i) {
        if(i == length) {
            ans.add(result);
            return;
        }else {
            for (int j = 0; j < nums.length; j++) {
                if(!result.contains(nums[j])) {
                    result.add(nums[j]);
                    nextPermutation(nums, new ArrayList<>(result), i + 1);
                    result.remove(result.size() - 1);
                }
            }
        }
    }
}
