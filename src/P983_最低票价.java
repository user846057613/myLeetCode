public class P983_最低票价 {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length - 1;
        int maxDay = days[n];
        int minDay = days[0];
        int[] dp = new int[maxDay+31];
        for (int day = maxDay, i = n; day >= minDay; day--) {
            if(day == days[i]) {
                dp[day] = Math.min(dp[day+1] + costs[0] , dp[day+7] + costs[1]);
                dp[day] = Math.min(dp[day+30]+costs[2], dp[day]);
                i--;
            }else{
                dp[day] = dp[day+1];
            }
        }
        return dp[minDay];
    }
}
