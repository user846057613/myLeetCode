import java.util.Arrays;

public class P033_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (nums.length > 1 && left != right - 1) {
            int mid = (left + right) / 2;
            if(nums[left] < nums[mid]) {
                left = mid;
            }else {
                right = mid;
            }
        }
        int index = Arrays.binarySearch(nums,0,left + 1,target);
        if(index >= 0) {
            return index;
        }
        index = Arrays.binarySearch(nums, left + 1, nums.length,target);
        if(index >= 0) {
            return index;
        }
        return -1;
    }
}
