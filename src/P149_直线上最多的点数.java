import java.math.BigInteger;

public class P149_直线上最多的点数 {
    public int maxPoints(int[][] points) {
        if(points.length < 3) {
            return points.length;
        }
        int i = 0;
        for (; i < points.length-1; i++) {
            if(points[i][0] != points[i+1][0] || points[i][1] != points[i+1][1]) {
                break;
            }
        }
        if(i == points.length - 1) {
            return points.length;
        }
        int maxnum = 0;
        for (i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if(points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
                    continue;
                }
                int num = 2;
                for (int k = 0; k < points.length; k++) {
                    if(k == i || k == j) {
                        continue;
                    }
                    if(test(points[i][0],points[i][1],points[j][0],
                            points[j][1],points[k][0],points[k][1])) {
                        num++;
                    }
                }
                maxnum = Math.max(maxnum,num);
            }
        }
        return maxnum;
    }

    int gcd(int x, int y) {
        if( y == 0) return x;
        return gcd(y, x %y);
    }

    private boolean test(int x1, int y1, int x2 ,int y2, int x, int y) {
        int g1 = gcd(y2-y1, x2-x1);
        if( y == y2 && x == x2) {
            return true;
        }
        int g2 = gcd(y-y2, x-x2);
        return (y2-y1) / g1 == (y-y2) / g2 && (x2-x1) / g1 == (x-x2) / g2;
    }

//    private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
//        BigInteger x11 = new BigInteger(String.valueOf(x1));
//        BigInteger y11 = new BigInteger(String.valueOf(y1));
//        BigInteger x22 = new BigInteger(String.valueOf(x2));
//        BigInteger y22 = new BigInteger(String.valueOf(y2));
//        BigInteger x33 = new BigInteger(String.valueOf(x));
//        BigInteger y33 = new BigInteger(String.valueOf(y));
//        return y22.subtract(y11).multiply(x33.subtract(x22)).equals(
//                y33.subtract(y22).multiply(x22.subtract(x11))
//        );
//    }
}
