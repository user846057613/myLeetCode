public class P680_验证回文字符串Ⅱ {
    public boolean validPalindrome(String s) {
        return helper(s,true);
    }

    private boolean helper(String s, boolean flag) {
        if(s == null || s.length() == 0) return true;
        int n = s.length() / 2;
        int l = 0;
        int r = s.length()-1;
        for (int i = 0; i < n; i++) {
            if(s.charAt(l+i) != s.charAt(r-i)) {
                if(flag) {
                    return helper(s.substring(0,l+i) + s.substring(l+i+1), false) ||
                            helper(s.substring(0,r-i)+s.substring(r-i+1), false);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
