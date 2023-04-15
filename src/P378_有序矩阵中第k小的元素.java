import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P378_有序矩阵中第k小的元素 {
    int[][] num;
    boolean[][] visit;
    public int kthSmallest(int[][] matrix, int k) {
        this.num = matrix;
        int n = matrix.length;
        int col = 0, row = 0;
        visit = new boolean[n][n];
        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>(
                new Comparator<Pair<Integer, Integer>>() {
                    @Override
                    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                        int num1 = num[o1.getKey()][o1.getValue()];
                        int num2 = num[o2.getKey()][o2.getValue()];
                        return  num1 > num2 ? 1 : (num1 == num2 ? 0 : -1);
                    }
                }
        );
        queue.offer(new Pair<>(0,0));
        visit[0][0] = true;
        while (!queue.isEmpty() && k > 0) {
            Pair<Integer, Integer> pair = queue.poll();
            row = pair.getKey();
            col = pair.getValue();
            k--;
            if(row + 1 < n && !visit[row+1][col]) {
                queue.offer(new Pair<>(row+1, col));
                visit[row+1][col] = true;
            }
            if(col + 1 < n && !visit[row][col + 1]) {
                queue.offer(new Pair<>(row, col+1));
                visit[row][col + 1] = true;
            }
        }
        return matrix[row][col];
    }
}
