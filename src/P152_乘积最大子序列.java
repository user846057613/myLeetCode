import java.time.temporal.Temporal;
import java.util.Arrays;

public class P152_乘积最大子序列 {

    public int maxProduct(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        int maxProduct = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            maxProduct = Math.max(imax, maxProduct);
        }
        return maxProduct;
    }

    public int maxProduct1(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int mul = 1;
            for (int j = i; j < nums.length; j++) {
                mul = mul * nums[j];
                maxProduct = Math.max(maxProduct, mul);
            }
        }
        return maxProduct;
    }
}
