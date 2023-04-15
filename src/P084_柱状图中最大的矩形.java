import org.junit.Test;

public class P084_柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int area = (j - i + 1)* minHeight;
                result = Math.max(area, result);
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] num = {2,1,5,6,2,3};
        int result = largestRectangleArea(num);
        System.out.println(result);
    }
}
