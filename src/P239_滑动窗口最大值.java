import org.junit.Test;

import java.util.ArrayDeque;

public class P239_滑动窗口最大值 {
    int[] nums;
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k==0) {
            return new int[0];
        }
        if( k == 1) {
            return nums;
        }
        this.nums = nums;
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            deal(i,k);
            deque.addLast(i);
            if(nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[maxIndex];
        for (int i = k; i < nums.length; i++) {
            deal(i,k);
            deque.addLast(i);
            ans[i - k + 1] = nums[deque.getFirst()];
        }
        return ans;
    }

    private void deal(int i, int k) {
        if(!deque.isEmpty() && deque.getFirst() == i - k) deque.removeFirst();

        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) deque.removeLast();
    }

    @Test
    public void test() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums, 3);
    }
}
