public class P041_缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] > n || nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if(num != Integer.MAX_VALUE && nums[num-1] > 0) {
                    nums[num-1] *= -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }
        return n+1;
    }
}
