public class P069_x的平方根 {
    public int mySqrt(int x) {
        int left = 1;
        int right = 50000;
        while (left < right) {
            int mid = (left + right) / 2;
            if(x / mid < mid) {
                right = mid;
            }else if( x / mid > mid) {
                left = mid + 1;
            }else if( x / mid == mid) {
                return mid;
            }
        }
        return left - 1;
    }
}
