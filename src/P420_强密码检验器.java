public class P420_强密码检验器 {
    public int strongPasswordChecker(String s) {
        boolean isBig = false;
        boolean isSmall = false;
        boolean isNum = false;
        int pos = 0;
        int[] cnt = new int[3]; //0:3n, 1:3n+1, 2:3n+2;
        int ans = 0;
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if(c >= 'a' && c <= 'z') isSmall = true;
            if(c >= 'A' && c <= 'Z') isBig = true;
            if(c >= '0' && c <= '9') isNum = true;

            int i = pos;
            while (++i < s.length() && s.charAt(i) == c);
            int length = i - pos;
            if(length >= 3) {
                cnt[length % 3]++;
                ans += length / 3;
            }
            pos = i;
        }
        int absent = 0;
        if(!isSmall) absent++;
        if(!isNum) absent++;
        if(!isBig) absent++;
        if(s.length() < 6) return Math.max(absent, 6-s.length());
        if(s.length() <= 20) return Math.max(absent, ans);
        int remove = s.length() - 20;
        if(remove < cnt[0]) {
            return Math.max(absent, ans - remove) + s.length() - 20;
        }
        remove -= cnt[0];
        ans -= cnt[0];
        if(remove < cnt[1] * 2) {
            return Math.max(absent, ans - remove / 2) + s.length() - 20;
        }
        remove -= cnt[1] * 2;
        ans -= cnt[1];
        return Math.max(absent, ans - remove / 3) + s.length() - 20;
    }
}
