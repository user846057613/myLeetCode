public class P1278_分割回文串Ⅲ {
    public int palindromePartition(String s, int k) {
        if(s.length() == 0 || k == 0) {
            return 0;
        }
        int m = s.length();
        int[][] part = new int[m+1][m+1];
        for (int i = s.length(); i >= 1; i--) {
            for (int j = i; j <= s.length(); j++) {
                if(j - i >= 2) {
                    part[i][j] = part[i+1][j-1];
                }
                if(s.charAt(i-1) != s.charAt(j-1)) {
                    part[i][j]++;
                }
            }
        }
        int[][] dp = new int[k+1][m+1];
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= m; j++) {
                if(i == 1) {
                    dp[i][j] = part[i][j];
                }else{
                    dp[i][j] = dp[i-1][i-1] + part[i][j];
                    for (int l = i; l < j; l++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][l]+part[l+1][j]);
                    }
                }
            }
        }
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= k; j++) {
//                if(j == 1) {
//                    dp[j][i] = part[j][i];
//                }else{
//                    int minNum = dp[j-1][j-1] + part[j][i];
////                    dp[j][i] = dp[j-1][i-1] + part[i][]
//                    for (int l = 1; l < i; l++) {
//                        minNum = Math.min(minNum, dp[j-1][l] + part[l+1][i]);
//                    }
//                    dp[j][i] = minNum;
//                }
//            }
//        }
        return dp[k][m];
    }
}
