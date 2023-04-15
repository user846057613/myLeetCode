import java.util.Arrays;
import java.util.HashMap;

public class P454_四数相加Ⅱ {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        int n = A.length;
        HashMap<Integer,Integer> sum1 = new HashMap<>();
        HashMap<Integer,Integer> sum2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum1.put(A[i]+B[j], sum1.getOrDefault(A[i]+B[j],0)+1);
                sum2.put(C[i]+D[j], sum2.getOrDefault(C[i]+D[j],0)+1);
            }
        }
        for(Integer e : sum1.keySet()) {
            int a = -e;
            if(sum2.containsKey(a)) {
                ans += sum1.get(e) * sum2.get(a);
            }
        }
        return ans;
    }
}
