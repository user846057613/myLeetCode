import java.util.HashMap;

public class P1300_转变数组后最接近目标值的数组和 {
    public int findBestValue(int[] arr, int target) {
        int left = 1;
        int right = target;
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = calc(map,mid);
            if(sum > target) {
                right = mid - 1;
            }else if(sum < target) {
                left = mid + 1;
            }else if(sum == target) {
                return mid;
            }
        }
        int sub1 = Math.abs(calc(map,left)-target);
        int sub2 = Math.abs(calc(map,left-1)-target);
        if(sub1 < sub2) return left;
        else return left - 1;
    }

    private int calc(HashMap<Integer, Integer> map, int mid) {
        int sum = 0;
        for (Integer integer : map.keySet()) {
            int i = integer;
            if(i <= mid) sum += i*map.get(i);
            else{
                sum += mid * map.get(i);
            }
        }
        return sum;
    }
}
