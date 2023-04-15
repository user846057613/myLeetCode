import java.util.HashSet;

public class P202_快乐数 {
    public boolean isHappy(int n) {
        HashSet<Long> hs = new HashSet<>();
        long sum = n;
        hs.add(sum);
        while (sum != 1) {
            String num = sum + "";
            sum = 0;
            for (int i = 0; i < num.length(); i++) {
                int x = num.charAt(i) - '0';
                sum += x*x;
            }
            if(hs.contains(sum)) {
                return false;
            }
            hs.add(sum);
        }
        return true;
    }
}
