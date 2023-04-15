import org.junit.Test;
import sun.security.util.Length;

import java.util.Stack;

public class P085_最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int x = matrix[0].length;
        int y = matrix.length;
        int[][] num = new int[y + 1][x + 1];
        for (int i = 0; i < matrix[0].length ; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if(matrix[j][i] == '1') {
                    num[j][i] = num[j+1][i] + 1;
                }else {
                    num[j][i] = 0;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            int area = getArea(num[i]);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int getArea(int[] ints) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < ints.length; i++) {
            while (stack.peek() != -1 && ints[stack.peek()] >= ints[i]) {
                maxArea = Math.max(ints[stack.pop()] * (i - 1 - stack.peek()) , maxArea);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, ints[stack.pop()] * (ints.length - 1 - stack.peek()));
        }
        return maxArea;
    }

    @Test
    public void test() {
        char[][] num = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        maximalRectangle(num);
    }
}
