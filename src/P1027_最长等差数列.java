import java.util.ArrayList;
import java.util.HashMap;

public class P1027_最长等差数列 {
    public int longestArithSeqLength(int[] A) {
        ArrayList<HashMap<Integer,Integer>> dp = new ArrayList<>();
        int maxNum = Integer.MIN_VALUE;
        dp.add(new HashMap<Integer, Integer>());
        for (int i = 1; i < A.length; i++) {
            HashMap<Integer,Integer> thisMap = new HashMap<>();
            for (int j = 0; j < i; j++) {
                HashMap<Integer,Integer> map = dp.get(j);
                int sub = A[i] - A[j];
                int times = 0;
                if(map.containsKey(sub)) {
                    times = map.get(sub) + 1;
                }else{
                    times = 2;
                }
                maxNum = Math.max(maxNum, times);
                thisMap.put(sub,times);
            }
            dp.add(thisMap);
        }
        return maxNum;
    }
}
