import org.junit.Test;

import java.util.LinkedList;

public class P912_排序数组 {
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        int pos = partition(nums,left,right);
        if(left <= pos - 1) {
            sort(nums,left,pos-1);
        }
        if(right >= pos+1) {
            sort(nums,pos+1,right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        if(left == right) {
            return left;
        }
        int temp = nums[right];
        int leftPos = left;
        int rightPos = right;
        right--;
        while (leftPos < rightPos) {
            if(nums[right] > temp) {
                nums[rightPos--] = nums[right--];
            }else{
                int tmp = nums[right];
                nums[right] = nums[leftPos];
                nums[leftPos] = tmp;
                leftPos++;
            }
        }
        nums[leftPos] = temp;
        return leftPos;
    }

    public int[] sort(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();
            if(left >= right) continue;
            int pos = partition1(nums,left,right);
            queue.offer(left);
            queue.offer(pos-1);
            queue.offer(pos+1);
            queue.offer(right);
        }
        return nums;
    }

    private int partition1(int[] nums, int left, int right) {
        int tmp = nums[right];
        int pos = left-1;
        for (int i = left; i < right; i++) {
            if(nums[i] <= tmp) {
                swap(nums,++pos,i);
            }
        }
        swap(nums,++pos,right);
        return pos;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    @Test
    public void test() {
        int[] num = {5,4,3,2,1};
        sort(num);
    }

}
