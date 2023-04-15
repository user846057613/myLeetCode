import java.util.HashMap;
import java.util.HashSet;

public class P395_至少有k个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        int[] times = new int[26];
        for (int i = 0; i < s.length(); i++) {
            times[s.charAt(i)-'a']++;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < times.length; i++) {
            if(times[i] > 0 && times[i] < k) {
                set.add(i);
            }
        }
        if(set.size() == 0) {
            return s.length();
        }else {
            int maxLength = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if(times[s.charAt(i)-'a'] > 0 && times[s.charAt(i)-'a'] < k) {
                    maxLength = Math.max(maxLength,
                            longestSubstring(s.substring(left, i),k));
                    left = i + 1;
                }
            }
            if(left < s.length()) {
                maxLength = Math.max(maxLength,
                        longestSubstring(s.substring(left),k));
            }
            return maxLength;
        }
    }
}
