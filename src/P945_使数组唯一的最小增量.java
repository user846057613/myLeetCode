import java.util.HashSet;
import java.util.TreeMap;

public class P945_使数组唯一的最小增量 {
    public int minIncrementForUnique(int[] A) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        HashSet<Integer> integers = new HashSet<>();
        if(A.length == 0) {
            return 0;
        }
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i],0) + 1);
            integers.add(A[i]);
        }
        int ans = 0;
        int point = map.firstKey();
        for(Integer i : map.keySet()) {
            if(map.get(i) > 1) {
                int times = map.get(i) - 1;
                int num = Math.max(point,i);
                point = num;
                while (times > 0) {
                    num++;
                    if(!integers.contains(num)) {
                        times--;
                        integers.add(num);
                        ans += num - i;
                        point = num;
                    }
                }
            }
        }
        return ans;
    }
}
