import java.util.HashSet;

public class P365_水壶问题 {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z > x + y) {
            return false;
        }
        if(x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x,y) == 0;
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
