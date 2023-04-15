import java.util.HashSet;

public class P128_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int result = 0;
        for (Integer integer : numSet) {
            if(!numSet.contains(integer - 1)) {
                int current = integer + 1;
                int stack = 1;
                while(numSet.contains(current)) {
                    current++;
                    stack++;
                }
                result = Math.max(result, stack);
            }
        }
        return result;
    }
}
