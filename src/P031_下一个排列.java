import java.util.Arrays;

public class P031_下一个排列 {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if(nums[i-1] < nums[i]) {
                int minnum = Integer.MAX_VALUE;
                int index = i;
                for (int j = i; j < nums.length; j++) {
                    if(nums[i-1] < nums[j] && nums[j] < minnum) {
                        index = j;
                        minnum = nums[j];
                    }
                }
                int tmp = nums[i-1];
                nums[i-1] = nums[index];
                nums[index] = tmp;
                Arrays.sort(nums, i, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
        return;
    }
}
