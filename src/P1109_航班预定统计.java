public class P1109_航班预定统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            ans[bookings[i][0] - 1] += bookings[i][2];
            if(bookings[i][1] < n) {
                ans[bookings[i][1]] -= bookings[i][2];
            }
        }

        for (int i = 1; i < n; i++) {
            ans[i] += ans[i-1];
        }
        return ans;
    }
}
