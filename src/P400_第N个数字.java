import org.junit.Test;

public class P400_第N个数字 {
    public int findNthDigit(int n) {
        long base = 9;
        long num = 1;
        long begin = 1;
        while (n >= base*num) {
            if(n == base*num) return 9;
            n = (int) (n - base*num);
            base *= 10;
            num++;
            begin = begin * 10;
        }
        long add = n / num;
        int left = (int) (n % num);
        String s = "";
        if(left == 0) begin = begin + (add > 1 ? add -1 : 0);
        else begin = begin + add;
        s = String.valueOf(begin);
        return (left == 0 ? s.charAt(s.length()-1) : s.charAt(left-1)) - '0';
    }

    @Test
    public void test() {
        System.out.println(findNthDigit(1000000000));
    }
}
