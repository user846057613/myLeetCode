public class P172_阶乘后的零 {
    public int trailingZeroes(int n) {
        int ans = 0;
        if(n < 5) {
            return ans;
        }
        int num = n;
        while ( num >= 5) {
            ans += num / 5;
            num /= 5;
        }
        return ans;
    }
}
