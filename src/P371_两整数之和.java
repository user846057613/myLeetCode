import org.junit.Test;

public class P371_两整数之和 {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a^b, (a&b) << 1);
    }

    @Test
    public void test() {
        getSum(4,5);
    }
}
