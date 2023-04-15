public class P面试题39_数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == num) times++;
            else times--;
            if(times == -1) {
                num = nums[i];
                times = 1;
            }
        }
        return num;
    }
}
