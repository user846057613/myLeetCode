import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 面试题046_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        ans.add(list);
        while (true) {
            int index = 0;
            for (int i = nums.length-1; i > 0; i--) {
                if(nums[i] > nums[i-1]) {
                    index = i;
                    for (int j = nums.length-1; j >= i; j--) {
                        if(nums[j] > nums[i-1]) {
                            index = j;
                            break;
                        }
                    }
                    int temp = nums[i-1];
                    nums[i-1] = nums[index];
                    nums[index] = temp;
                    Arrays.sort(nums,i,nums.length);
                    ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                    break;
                }
            }
            if(index == 0){
                break;
            }
        }
        return ans;
    }
}
