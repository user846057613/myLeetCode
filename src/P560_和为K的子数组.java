import java.util.HashMap;

public class P560_和为K的子数组 {

    public int subarraySum2(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hs = new HashMap<>();
        int sum = 0;
        hs.put(0,1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(hs.containsKey(sum - k)) {
                ans += hs.get(sum-k);
            }
            hs.put(sum, hs.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0) {
                sum[i] = nums[i];
            }else {
                sum[i] = sum[i-1] + nums[i];
            }
            if(sum[i] == k) {
                ans++;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(sum[i] - sum[j] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
