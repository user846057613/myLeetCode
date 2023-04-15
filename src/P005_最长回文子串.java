public class P005_最长回文子串 {
    public String longestPalindrome1(String s) {
        int maxLength = 0;
        if(s.equals("") || s == null) {
            return "";
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if(j - i + 1 <= maxLength) {
                    break;
                }
                int index = (j - i + 1) / 2;
                boolean flag = true;
                for (int k = 0; k <= index; k++) {
                    if(s.charAt(i+k) != s.charAt(j - k)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    if(j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        result = s.substring(i, j+1);
                    }
                }
            }
        }
        return result;
    }

    public String longestPalindrome(String s) {
        int maxLength = 0;
        if(s == null || s.length() == 0) return "";
        String result = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int length = 0;
            int offset = 0;
            while (i-offset >= 0 && i + offset < n) {
                if(s.charAt(i-offset) == s.charAt(i+offset)) {
                    length = offset == 0 ? length + 1 : length + 2;
                    offset++;
                }else {
                    break;
                }
            }
            if(length > maxLength) {
                maxLength = length;
                result = s.substring(i-offset+1, i+offset);
            }
            int l = i, r = i + 1;
            offset = 0;
            length = 0;
            while (l-offset >= 0 && r+offset < n) {
                if(s.charAt(l-offset) == s.charAt(r+offset)) {
                    length += 2;
                    offset++;
                }else{
                    break;
                }
            }
            if(length > maxLength) {
                maxLength = length;
                result = s.substring(i-offset+1, i+1+offset);
            }
        }
        return result;
    }
}
