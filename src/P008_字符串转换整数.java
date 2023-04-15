public class P008_字符串转换整数 {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        if( !(str.charAt(0)=='+' || str.charAt(0) == '-'
                || (str.charAt(0) >='0' && str.charAt(0)<='9')) ) {
            return 0;
        }else {
            int ans = 0;
            int left = 0;
            boolean flag = false;
            while (left < str.length()) {
                if(str.charAt(left) == '-' && left == 0) {
                    flag = true;
                    left++;
                }else if(str.charAt(left) == '+' && left == 0) {
                    left++;
                    continue;
                }else if(str.charAt(left) >= '0' && str.charAt(left) <= '9') {
                    if(!flag && (ans + (str.charAt(left) - '0') / 10.0) > Integer.MAX_VALUE / 10.0) {
                        ans = Integer.MAX_VALUE;
                        break;
                    }else if(flag && (ans - (str.charAt(left) - '0') / 10.0) < Integer.MIN_VALUE / 10.0) {
                        ans = Integer.MIN_VALUE;
                        break;
                    }else {
                        if(flag) {
                            ans = ans * 10 - (str.charAt(left) - '0');
                        }else {
                            ans = ans * 10 + (str.charAt(left) - '0');
                        }
                        left++;
                        continue;
                    }
                }else {
                    break;
                }
            }
            return ans;
        }
    }
}
