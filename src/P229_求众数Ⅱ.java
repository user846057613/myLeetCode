import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P229_求众数Ⅱ {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 0) return new ArrayList<Integer>();
        int candidate1 = nums[0], count1 = 0;
        int candidate2 = nums[0], count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if(candidate1 == nums[i]) {
                count1++;
                continue;
            }

            if(candidate2 == nums[i]) {
                count2++;
                continue;
            }

            if(count1 == 0) {
                candidate1 = nums[i];
                count1++;
                continue;
            }

            if(count2 == 0) {
                candidate2 = nums[i];
                count2++;
                continue;
            }

            count1--;
            count2--;
        }
        HashSet<Integer> res = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == candidate1) count1++;
            if(nums[i] == candidate2) count2++;
        }
        if(count1 > nums.length / 3) res.add(candidate1);
        if(count2 > nums.length / 3) res.add(candidate2);
        ans.addAll(res);
        return ans;
    }
}
