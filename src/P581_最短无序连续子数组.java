import java.util.Arrays;

public class P581_最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int[] nums_sort =  nums.clone();
        Arrays.sort(nums_sort);
        int start = nums.length , end = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums_sort[i]) {
                start = Math.min(start, i);
                end = Math.max(end,i);
            }
        }
        return ((end - start) >= 0 ? end - start : -1) + 1;
    }
}
