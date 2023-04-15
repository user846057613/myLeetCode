public class P013_罗马数字转整数 {
    public int romanToInt(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int ans = 0;
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == 'I') {
                if(i+1 < s.length() && s.charAt(i+1) == 'V') {
                    ans += 4;
                    i++;
                }else if(i+1 < s.length() && s.charAt(i+1) == 'X') {
                    ans += 9;
                    i++;
                }else {
                    ans += 1;
                }
            }else if(s.charAt(i) == 'V'){
                ans += 5;
            }else if(s.charAt(i) == 'X') {
                if(i+1 < s.length() && s.charAt(i+1) == 'L') {
                    ans += 40;
                    i++;
                }else if(i+1 < s.length() && s.charAt(i+1) == 'C') {
                    ans += 90;
                    i++;
                }else {
                    ans += 10;
                }
            }else if(s.charAt(i) == 'L') {
                ans += 50;
            }else if(s.charAt(i) == 'C') {
                if(i+1 < s.length() && s.charAt(i+1) == 'D') {
                    ans += 400;
                    i++;
                }else if(i+1 < s.length() && s.charAt(i+1) == 'M') {
                    ans += 900;
                    i++;
                }else {
                    ans += 100;
                }
            }else if(s.charAt(i) == 'D') {
                ans += 500;
            }else if(s.charAt(i) == 'M') {
                ans += 1000;
            }
            i++;
        }
        return ans;
    }
}
