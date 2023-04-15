import java.util.TreeMap;

public class P1170_比较字符串最小字母出现频次 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            int res = f(words[i]);
            map.putIfAbsent(res,0);
            map.put(res, map.get(res) + 1);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int res = f(queries[i]);
            for (Integer key : map.tailMap(res,false).keySet()) {
                System.out.println(key);
                ans[i] += map.get(key);
            }
        }
        return ans;
    }

    public int f(String s) {
        int times = 0;
        char min = 'z';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c < min) {
                min = c;
                times = 1;
            }else if( c == min) {
                times++;
            }
        }
        return times;
    }
}
