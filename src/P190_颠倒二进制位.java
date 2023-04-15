import org.junit.Test;

public class P190_颠倒二进制位 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 31; i >= 0 && n != 0; i--, n = n >>> 1) {
                ans += (n&1) << i;
        }
        return ans;
    }

    @Test
    public void test() {

    }
}
