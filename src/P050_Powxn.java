import org.junit.Test;

public class P050_Powxn {
    public double myPow(double x, int n) {
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x,n);
    }

    private double fastPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        double half = fastPow(x, n/2);
        if(n % 2 == 0) {
            return half * half;
        }else{
            return half * half * x;
        }
    }

    @Test
    public void test() {
        myPow(0.00001, 2147483647);
    }
}
