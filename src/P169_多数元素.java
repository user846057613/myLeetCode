import java.util.HashMap;
import java.util.Map;

public class P169_多数元素 {
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            mp.put(now, mp.getOrDefault(now, 0 ) + 1);
            if(mp.get(now) > n) {
                ans = now;
                break;
            }
        }
        return ans;
    }
}
