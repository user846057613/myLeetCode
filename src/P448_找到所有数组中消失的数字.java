import java.util.ArrayList;
import java.util.List;

public class P448_找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if( nums[Math.abs(nums[i])-1] > 0) {
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
}
