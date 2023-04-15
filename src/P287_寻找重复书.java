import org.junit.Test;

public class P287_寻找重复书 {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            int counter = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] <= mid) {
                    counter++;
                }
            }
            if(counter > mid){
                right = mid - 1;
            }else if(counter <= mid) {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int[] num = {2,2,2,2,2};
        int x = findDuplicate(num);
        System.out.println(x);
    }
}
