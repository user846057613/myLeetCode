public class P026_删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }else {
            int left = 0;
            int right = 0;
            int ans = 1;
            while(right < nums.length){
                if(nums[right] != nums[left]) {
                    nums[ans++] = nums[right];
                    left = right;
                }
                right++;
            }
            return ans;
        }
    }
}
