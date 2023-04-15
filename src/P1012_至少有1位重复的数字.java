import java.util.ArrayList;

public class P1012_至少有1位重复的数字 {
    public int numDupDigitsAtMostN(int N) {
        return N - dp(N);
    }

    public int dp(int n) {
        ArrayList<Integer> numList = new ArrayList<>();
        while (n > 0) {
            numList.add(n % 10);
            n /= 10;
        }

        int sz = numList.size();
        int total = 0;
        for (int i = 0 ; i < sz - 1; i++) {
            total += 9 * A(9,i);
        }
        int[] used = new int[10];
        for (int i = sz - 1; i >= 0; i--) {
            int num = numList.get(i);
            for (int j = i == sz - 1 ? 1 : 0; j < num; j++) {
                if(used[j] != 0) {
                    continue;
                }
                total += A((10-(sz-i)), i);
            }

            if(++used[num] > 1) {
                break;
            }
            if(i == 0) total++;
        }
        return total;
    }

    private int A(int m, int n) {
        return fact(m) / fact(m-n);
    }

    private int fact(int m) {
        if(m == 1 || m == 0) {
            return 1;
        }
        return m * fact(m-1);
    }
}
