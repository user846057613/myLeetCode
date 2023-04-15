public class P191_位1的个数 {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }
}
