public class P189_旋转数组 {
    public void rotate(int[] nums, int k) {
        while(k > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = temp;
            k--;
        }
    }
    public void rotate1(int[] nums, int k) {
        int step = 0;
        k = k % nums.length;
        for (int i = 0; step < nums.length; i++) {
            int index = i;
            int pre = nums[index];
            do {
                int temp = nums[(index + k) % nums.length];
                nums[(index + k) % nums.length] = pre;
                index = ( index + k ) % nums.length;
                pre = temp;
                step++;
            }while (index != i);
        }
    }
}
