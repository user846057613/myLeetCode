import org.junit.Test;

import java.util.HashMap;
import java.util.TreeSet;

public class P974_和可被k整除的子数组的个数 {
    public int subarraysDivByK(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        long[] sum = new long[n];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i-1] + A[i];
        }
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int num = (int)(sum[i] % K);
            num = num < 0 ? K + num : num;
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for (Integer integer : map.keySet()) {
            int num = map.get(integer);
            if(integer.equals(0)) {
                ans += (num * (num+1)) / 2;
            }else{
                ans += (num * (num-1)) / 2;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] a = {4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(a,5));
    }
}
