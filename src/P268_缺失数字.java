public class P268_缺失数字 {
    public int missingNumber(int[] nums) {
        int more = 0;
        int ans = 0;
        for (int i = 0; i < nums.length;) {
            if(nums[i] == nums.length) {
                more = nums[i];
                i++;
                continue;
            }else if(nums[i] == i) {
                i++;
                continue;
            }else{
                if(nums[nums[i]] != nums[i]) {
                    int tmp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = tmp;
                }else {
                    i++;
                    continue;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(i != nums[i]) {
                ans = i;
            }
        }
        return more == nums.length ? ans : nums.length;
    }
}
