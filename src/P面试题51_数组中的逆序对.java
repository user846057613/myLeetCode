import org.junit.Test;

public class P面试题51_数组中的逆序对 {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] copy = new int[nums.length];
        for (int i = 1; i <= nums.length; i *= 2) {
            int now = 0;
            int index = 0;
            for (int j = 0; j < nums.length; j += 2*i) {
                int left = j;
                int right = j+2*i - 1 < nums.length ? j+2*i - 1 : nums.length - 1;
                int mid = j + i - 1 < nums.length ? j+ i - 1 : nums.length - 1;
                int midBound = mid + 1 < nums.length ? mid + 1 : nums.length;
                while (left <= mid && midBound <= right) {
                    if(nums[left] <= nums[midBound]) {
                        copy[index++] = nums[left++];
                    }else{
                        copy[index++] = nums[midBound++];
                        now += (mid - left + 1);
                    }
                }
                while (left <= mid) {
                    copy[index++] = nums[left++];
                }
                while (midBound <= right) {
                    copy[index++] = nums[midBound++];
                }
            }
            ans += now;
            System.arraycopy(copy,0,nums,0,nums.length);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] num = {1,2,3,5,4};
        System.out.println(reversePairs(num));
    }
}
