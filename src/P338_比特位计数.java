import java.util.ArrayList;

public class P338_比特位计数 {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 0; i <= num; i++) {
            char[] s = Integer.toBinaryString(i).toCharArray();
            int ans = 0;
            for (int j = 0; j < s.length; j++) {
                if(s[j] == '1') {
                    ans++;
                }
            }
            result[i] = ans;
        }
        return result;
    }

    public int[] countBits2(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            if(i %2 == 0) {
                result[i] = result[i/2];
            }else {
                result[i] = result[i-1] + 1;
            }
        }
        return result;
    }
}
