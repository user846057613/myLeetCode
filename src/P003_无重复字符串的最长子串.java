import org.junit.Test;

public class P003_无重复字符串的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if(s.equals("") || s == null) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            int length = 1;
            for (int j = i+1; j < s.length(); j++) {
                String sub = s.substring(i,j);
                if(sub.contains(s.charAt(j) + "")) {
                    break;
                }
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }


    public int lengthOfLongestSubstring2(String s) {
        int maxLength = 1;
        if(s.equals("") || s == null) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int length = 1;
        while (right < s.length()) {
            String sub = s.substring(left, right);
            if(!sub.contains(s.charAt(right) + "")) {
                right++;
                length++;
            }else {
                while (left < right) {
                    left++;
                    sub = s.substring(left, right);
                    length--;
                    if(sub.contains(s.charAt(right) + "")){
                        continue;
                    }else{
                        right++;
                        length++;
                        break;
                    }
                }
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }
}
