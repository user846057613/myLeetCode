import java.util.ArrayList;

public class P007_整数反转 {
    public int reverse(int x) {
        if(x == 0) {
            return 0;
        }
        long ans = 0;
        boolean isNagative = false;
        if(x < 0) {
            isNagative = true;
        }
        x = Math.abs(x);
        ArrayList<Integer> num = new ArrayList<>();
        int copy = x;
        while (copy != 0) {
            num.add(copy%10);
            copy /= 10;
        }
        for (int i = 0; i < num.size()-1; i++) {
            ans = (ans + num.get(i)) * 10;
        }
        ans += num.get(num.size()-1);
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }else {
            return isNagative ? -(int)ans : (int)ans;
        }
    }
}
