public class P011_盛最多水的容器 {

    public int maxAreaUp(int[] height) {
        int length = height.length;
        if(length == 0) {
            return 0;
        }
        int left = 0;
        int right = length-1;
        int result = 0;
        while(left != right) {
            int x = right - left;
            int high = Math.min(height[left], height[right]);
            result = Math.max(result, x * high);
            if(height[left] > height[right]) {
                right--;
            }else {
                left++;
            }
        }
        return result;
    }



    public int maxArea(int[] height) {
        int length = height.length;
        if(length == 0) {
            return 0;
        }
        int[]dp = new int[length+1];
        for (int i = 0; i <= length; i++) {
            dp[i]= 0;
        }

        int result = 0;
        for (int i = 1; i <= length; i++) {
            dp[i] = 0;
            for (int j = i+1 ; j <= length ; j++) {
                int x = j - i;
                int y = Math.min(height[i-1], height[j-1]);
                int newV = x * y;
                dp[j] = Math.max(dp[j-1], newV);
                result = Math.max(dp[j], result);
            }
        }
        return result;
    }
}
