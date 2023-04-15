import java.util.Arrays;

public class P324_摆动排序 {
    public void wiggleSort(int[] nums) {
        quickSelect(nums,0,nums.length,nums.length/2);
        int mid = nums[nums.length/2];
        int i = 0, j = nums.length-1, start = 0;
        while (start < nums.length) {
            if(nums[start] < mid) {
                int tmp = nums[start];
                nums[start] = nums[i];
                nums[i] = tmp;
                i++;
                start++;
            }else if(nums[start] > mid) {
                int tmp = nums[start];
                nums[start] = nums[j];
                nums[j] = tmp;
                j--;
                start++;
            }else {
                start++;
            }
        }
        int midPos = nums.length % 2 == 0 ? nums.length / 2 + 1: nums.length / 2;
        int[] num1 = Arrays.copyOfRange(nums,0, midPos);
        int[] num2 = Arrays.copyOfRange(nums, midPos, nums.length);
        for (int k = 0; k < num1.length; k++) {
            nums[2*k] = num1[num1.length - 1 - k];
        }
        for (int k = 0; k < num2.length; k++) {
            nums[2*k+1] = num2[num2.length - 1 - k];
        }
    }

    public void quickSelect(int[] nums, int begin, int end, int n) {
        int i = begin, j = begin;
        int t = nums[end - 1];
        while (j < end) {
            if(nums[j] <= t) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j++;
            }else {
                j++;
            }
        }
        if(i - 1 > n) {
            quickSelect(nums,begin, i-1, n);
        }else if(i<= n){
            quickSelect(nums, i , end, n);
        }
    }
}
