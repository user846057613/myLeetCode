import java.util.ArrayList;
import java.util.Random;

public class P384_打乱数组 {
    int[] init;
    int[] nums;

    public P384_打乱数组(int[] nums) {
        this.init = nums.clone();
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return init;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length - i) + i;
            int tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
        }
        return nums;
    }

}
