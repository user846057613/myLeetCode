import org.junit.Test;

public class P029_两数相除 {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(divisor == 1) {
            return dividend;
        }else if(divisor == -1) {
            return -dividend;
        }else{
            boolean isNeg = false;
            long dived = dividend, div = divisor;
            if(dived < 0) {
                isNeg = !isNeg;
                dived = - dived;
            }
            if(div < 0) {
                isNeg = !isNeg;
                div = - div;
            }
            int sum = 0;
            long[] pre = new long[33];
            int[] times = new int[33];
            pre[0] = div;
            times[0] = 1;
            int index = 0;
            while (dived > 0) {
                if(dived >= pre[index]) {
                    dived -= pre[index];
                    sum += times[index];
                    long nextNum = pre[index] + pre[index];
                    int nextTimes = times[index] + times[index];
                    pre[++index] = nextNum;
                    times[index] = nextTimes;
                }else {
                    index--;
                }
                if(index == -1) {
                    break;
                }
            }
            return isNeg ? -sum : sum;
        }
    }
    @Test
    public void test() {
        divide(10,3);
    }
}
