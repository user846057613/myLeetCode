import org.junit.Test;

public class P887_鸡蛋掉落 {
//    public int superEggDrop(int K, int N) {
//        return helper(K,N);
//    }
//
//    private int helper(int k, int n) {
//        if(n <= 0) {
//            return 0;
//        }
//        if(k == 1 || n == 1) {
//            return n;
//        }
//        int mid = (n + 1) / 2;
//        int num1 = helper(k-1, mid-1);
//        int num2 = helper(k,n-mid);
//        return Math.max(num1, num2) + 1;
//    }

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        for (int i = 0; i <= N; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                int left = 1;
                int right = j;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if(dp[i-1][mid-1] < dp[i][j-mid]) {
                        left = mid + 1;
                    }else if(dp[i-1][mid-1] > dp[i][j-mid]) {
                        right = mid - 1;
                    }else{
                       left = mid;
                       break;
                    }
                }
                int index = left - 1;
                int minNum;
                if(index >= 1) {
                    minNum = 1 + Math.min(Math.max(dp[i-1][left-1],dp[i][j-left]),
                            Math.max(dp[i-1][index-1], dp[i][j-index]));
                }else{
                    minNum = 1 + Math.max(dp[i-1][left-1],dp[i][j-left]);
                }
                dp[i][j] = minNum;
            }
        }
        return dp[K][N];
    }

    @Test
    public void test() {
        superEggDrop(3,14);
    }

    public int superEggDrop1(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        for (int i = 0; i <= N; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                int minNum = N*N;
                for (int k = 1; k <= j; k++) {
                    minNum = Math.min(minNum, 1 + Math.max(dp[i][j-k], dp[i-1][k-1]));
                }
                dp[i][j] = minNum;
            }
        }

        return dp[K][N];
    }
}
