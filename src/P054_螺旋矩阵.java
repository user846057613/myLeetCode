import java.util.ArrayList;
import java.util.List;

public class P054_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return ans;
        }
        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (left < right && top < bottom) {
            int i = left, j = top;
            while (i < right) {
                ans.add(matrix[top][i++]);
            }
            while (j < bottom) {
                ans.add(matrix[j++][right]);
            }
            while (i > left) {
                ans.add(matrix[bottom][i--]);
            }
            while (j > top) {
                ans.add(matrix[j--][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if(left == right && top == bottom) {
            ans.add(matrix[top][left]);
        }else if(left == right && top < bottom) {
            for (int i = top; i <= bottom ; i++) {
                ans.add(matrix[i][left]);
            }
        }else if(left < right && top == bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
        }
        return ans;
    }
}
