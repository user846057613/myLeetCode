import java.util.HashMap;

public class P532_数组中的Kdiff数对 {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        if(k < 0) return ans;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i],0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (Integer integer : map.keySet()) {
            if( k == 0) {
                if(map.get(integer) > 1) ans++;
            }else{
                if(map.containsKey(integer + k)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
