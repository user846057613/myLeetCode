import java.util.*;

public class P015_三数之和 {

    /**标签：数组遍历
     首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum判断是否满足为 0，满足则添加进结果集
     如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
     如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
     当 sum == 0 时，nums[L] == nums[L+1] 否则会导致结果重复，应该跳过，L++
     当 sum == 0 时，nums[R] == nums[R-1] 否则会导致结果重复，应该跳过，R--
     时间复杂度：O(n^2)
     */
    public static void main(String[] args) {
       int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0,0,0};
       print(threeSum(nums));
    }

    private static void print(List<List<Integer>> threeSum) {
        for (int i = 0; i < threeSum.size(); i++) {
            List<Integer> list = threeSum.get(i);
            for (int j = 0; j < list.size(); j++) {
                if(j == 0) {
                    System.out.print(list.get(j));
                }else {
                    System.out.print(" " + list.get(j));
                }
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if( nums == null || nums.length < 3) return ans;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0) return ans;
            if( i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = len - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    while(l < r && nums[r] == nums[r - 1]) r--;

                    l++;
                    r--;
                }else if( sum > 0){
                    r--;
                }else if( sum < 0) {
                    l++;
                }
            }
        }
        return ans;
    }
}
