public class P034_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] == target){
                index = mid;
                break;
            }else {
                right = mid - 1;
            }
        }
        int[] result = new int[2];
        if(index != -1) {
            int begin = index;
            int end = index;
            for (int i = index - 1; i >= 0; i--) {
                if(nums[i] == target) {
                    begin = i;
                }else {
                    break;
                }
            }
            for (int i = index + 1; i < nums.length; i++) {
                if(nums[i] == target) {
                    end = i;
                }else {
                    break;
                }
            }
            result[0] = begin;
            result[1] = end;
        }else {
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }
}
