import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P面试题57_Ⅱ和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        int l = 1;
        int r = 1;
        int sum = 0;
        while (l <= target/2) {
            if(sum < target) {
                sum += r;
                r++;
            }else if(sum > target) {
                sum -= l;
                l++;
            }else if(sum == target) {
                int[] one = new int[r-l];
                for (int i = l; i < r; i++) {
                    one[i-l] = i;
                }
                ans.add(one);
                sum -= l;
                l++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    @Test
    public void  test() {
        findContinuousSequence(9);
    }
}
