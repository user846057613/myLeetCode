import org.junit.Test;

import java.util.Arrays;

public class P902_最大为N的数字组合 {
    public int atMostNGivenDigitSet(String[] D, int N) {
        String s = N + "";
        int length = s.length();
        int ans = 0;
        long[] multiply = new long[20];
        Arrays.fill(multiply,1);
        for (int i = 1; i <= length - 1; i++) {
            multiply[i] = multiply[i-1]*D.length;
            ans += multiply[i];
        }

        for (int i = 0; i < s.length(); i++) {
            String s1 = s.charAt(i) + "";
            boolean flag = false;
            for (int j = 0; j < D.length; j++) {
                if(s1.compareTo(D[j]) > 0) {
                    ans += multiply[s.length()-(i+1)];
                }else if(s1.compareTo(D[j]) == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag) break;
            if(i == s.length() - 1) ans += 1;
        }
        return ans;
    }

    @Test
    public void test() {
        String[] s = {"1","3","5","7"};
        atMostNGivenDigitSet(s,100);
    }
}
