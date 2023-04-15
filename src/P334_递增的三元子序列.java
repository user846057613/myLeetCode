public class P334_递增的三元子序列 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return  false;
        }
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(nums[i] <= firstNum) {
                firstNum = nums[i];
            }else if(nums[i] <= secondNum) {
                secondNum = nums[i];
            }else {
                return true;
            }
        }
        return false;
    }
}
