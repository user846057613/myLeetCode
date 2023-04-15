import java.util.Arrays;

public class P739_每日温度 {


    public int[] dailyTemperaturesNew(int[] T) {
        int[] ans = new int[T.length];
        Arrays.fill(ans, 0);
        for (int i = T.length-2; i >= 0; i--) {
            if(T[i] >= T[i+1]) {
                int index = i + 1;
                while (index < T.length) {
                    if(ans[index] == 0) {
                        break;
                    }
                    int nextIndex = index + ans[index];
                    if(T[i] >= T[nextIndex]) {
                        index = nextIndex;
                        continue;
                    }else {
                        ans[i] = nextIndex - i;
                        break;
                    }
                }

            }else {
                ans[i] = 1;
            }
        }
        return ans;
    }


    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Arrays.fill(ans, 0);
        for (int i = 0; i < T.length; i++) {
            for (int j = i+1; j < T.length; j++) {
                if(T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}
