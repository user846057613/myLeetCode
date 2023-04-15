import java.util.*;

public class P315_计算右侧小于当前元素的个数 {

    List<Integer> ans;
    int[] nums;
    int[] tmp;
    public List<Integer> countSmaller(int[] nums) {
        this.nums = nums;
        ans = new ArrayList<>();
        if(nums.length == 0) {
            return ans;
        }else{
            int[] indexes = new int[nums.length];
            tmp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                indexes[i] = i;
                ans.add(0);
            }
            merge(indexes,0,nums.length-1);
            return ans;
        }
    }

    private void merge(int[] indexes, int left, int right) {
        if(left == right) {
            return;
        }else{
            int mid = left + (right - left) / 2;
            merge(indexes, left, mid);
            merge(indexes, mid + 1, right);
            int i = left;
            int j = mid + 1;
            int index = left;
            while (i <= mid && j <= right) {
                if(nums[indexes[i]] <= nums[indexes[j]]) {
                    ans.set(indexes[i], ans.get(indexes[i]) + j - mid - 1);
                    tmp[index++] = indexes[i++];
                }else{
                    tmp[index++] = indexes[j++];
                }
            }
            while (i <= mid) {
                ans.set(indexes[i], ans.get(indexes[i]) + right - mid);
                tmp[index++] = indexes[i++];
            }
            while (j <= right) {
                tmp[index++] = indexes[j++];
            }
            System.arraycopy(tmp,left,indexes,left,right - left + 1);
            return;
        }
    }


    public List<Integer> countSmaller2(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        if(nums.length == 0) {
            return ans;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = 0;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                if(entry.getKey() < nums[i]) {
                    num += entry.getValue();
                }else{
                    break;
                }
            }
            ans.add(num);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Collections.reverse(ans);
        return ans;
    }
}
