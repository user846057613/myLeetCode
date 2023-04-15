import java.io.FileReader;

public class P1248_统计优美子数组 {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        if(nums.length == 0) {
            return ans;
        }
        int left = 0;
        int right = 0;
        int oddNum = 0;
        int nowAns = 0;
        while (right < nums.length) {
            if(nums[right] % 2 == 1) oddNum++;
            if(oddNum == k) {
                nowAns++;
                while (nums[left] % 2 == 0) {
                    left++;
                    nowAns++;
                }
                int tmp = right;
                while (++right < nums.length && nums[right] % 2 == 0);
                nowAns = nowAns + nowAns * (right - 1 - tmp);
                if(right < nums.length && nums[right] % 2 == 1) {
                    left++;
                    oddNum--;
                }
                ans += nowAns;
                nowAns = 0;
            }else{
                right++;
            }
        }
        return ans;
    }
}
