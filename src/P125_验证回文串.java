public class P125_验证回文串 {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        boolean ans = true;
        s = s.toLowerCase();
        while (left <= right) {
            if(!((s.charAt(left) >= 'a' && s.charAt(left) <= 'z')
                    || (s.charAt(left) >= '0' && s.charAt(left) <='9'))) {
                left++;
                continue;
            }
            if(!((s.charAt(right) >= 'a' && s.charAt(right) <= 'z')
                    || (s.charAt(right) >= '0' && s.charAt(right) <='9'))) {
                right--;
                continue;
            }
            if(s.charAt(left) != s.charAt(right)) {
                ans = false;
                break;
            }else {
                left++;
                right--;
            }
        }
        return ans;
    }
}
