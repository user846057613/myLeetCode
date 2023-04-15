import java.util.HashMap;
import java.util.TreeMap;

public class P327_区间和的个数 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length == 0) return 0;
        long[] preSum = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        return mergeSort(preSum,0,nums.length-1,lower,upper);
    }

    private int mergeSort(long[] preSum, int left, int right, int lower, int upper) {
        if(left > right) return 0;
        if(left == right) {
            if(lower <= preSum[left] && preSum[right] <= upper) return 1;
            else return 0;
        }
        int mid = left + ( right - left) / 2;
        int count = mergeSort(preSum,left,mid,lower,upper) +
                mergeSort(preSum, mid + 1, right, lower, upper);
        int lowerBound = mid + 1;
        int upperBound = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (lowerBound <= right && preSum[lowerBound] - preSum[i] < lower)
                lowerBound++;
            while (upperBound <= right && preSum[upperBound] - preSum[i] <= upper)
                upperBound++;
            count += upperBound - lowerBound;
        }

        long[] merge = new long[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if(preSum[l] <= preSum[r]) merge[index++] = preSum[l++];
            else merge[index++] = preSum[r++];
        }
        while (l <= mid) merge[index++] = preSum[l++];
        while (r <= right) merge[index++] = preSum[r++];

        System.arraycopy(merge,0, preSum, left, index);
        return count;
    }

    public int countRangeSum1(int[] nums, int lower, int upper) {
        TreeMap<Long,Integer> map = new TreeMap<>();
        long sum = 0;
        int counter = 0;
        map.put(0L,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            for(int cnt : map.subMap(sum-upper,true,sum-lower,true).values()) {
                counter += cnt;
            }
            map.put((long) sum, map.getOrDefault(sum,0) + 1);
        }
        return counter;
    }
}
