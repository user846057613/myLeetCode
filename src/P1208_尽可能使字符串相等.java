import org.junit.Test;

public class P1208_尽可能使字符串相等 {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] cost = new int[length];
        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }

        int ans = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (left < length && right < length) {
            sum += cost[right];
            if(sum > maxCost) {
                while (sum > maxCost) {
                    sum -= cost[left++];
                }
            }else{
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(equalSubstring("krrgw","zjxss",19));
    }
}
