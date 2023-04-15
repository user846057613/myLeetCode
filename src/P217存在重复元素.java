import java.util.HashMap;
import java.util.Map;

public class P217存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        if(nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                return true;
            }else{
                mp.put(nums[i],1);
            }
        }
        return false;
    }
}
