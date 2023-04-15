import org.junit.Test;

import java.util.HashMap;

public class P面试题48_最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int length = 0;
        while (right < s.length()) {
            int times = map.getOrDefault(s.charAt(right), 0);
            if(times == 0) {
                map.put(s.charAt(right), 1);
                right++;
                length++;
                maxLength = Math.max(length,maxLength);
            }else{
                map.put(s.charAt(right), map.get(s.charAt(left))-1);
                length--;
                left++;
            }
        }
        return maxLength;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
