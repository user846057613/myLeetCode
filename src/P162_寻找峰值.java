public class P162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long leftNum = mid - 1 >= 0 ? nums[mid - 1] : Long.MIN_VALUE;
            long rightNum = mid + 1 < nums.length ? nums[mid + 1] : Long.MIN_VALUE;
            if(nums[mid] > leftNum && nums[mid] > rightNum) {
                left = mid;
                break;
            }else if(nums[mid] > leftNum) {
                left = mid + 1;
            }else if(nums[mid] <= leftNum) {
                right = mid - 1;
            }
        }
        return left;
    }

}
