import org.junit.Test;

import java.util.*;

public class P975_奇偶跳 {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        ArrayList<Pair> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(new Pair(i,A[i]));
        }
        array.sort((o1, o2) -> {
            if(o1.val == o2.val) return o1.index - o2.index;
            return o1.val - o2.val;
        });
        int[] maxPos = getArray(array,n);
        array.sort((o1,o2) -> {
            if(o1.val == o2.val) return o1.index - o2.index;
            return o2.val - o1.val;
        });
        int[] minPos = getArray(array,n);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int begin = i;
            int step = 1;
            while (begin != n-1 && begin != -1) {
                if(step % 2 == 1) {
                    begin = maxPos[begin];
                }else{
                    begin = minPos[begin];
                }
                step++;
            }
            if(begin == n-1) ans++;
        }
        return ans;
    }

    private int[] getArray(ArrayList<Pair> array, int n) {
        Stack<Pair> stack = new Stack<>();
        stack.push(array.get(0));
        int[] num = new int[n];
        Arrays.fill(num,-1);
        for (int i = 1; i < array.size(); i++) {
            Pair p = array.get(i);
            while (!stack.isEmpty() && stack.peek().index < p.index) {
                num[stack.pop().index] = p.index;
            }
            stack.push(p);
        }
        return num;
    }


    @Test
    public void test() {
        int[] num = {10,13,12,14,15};
        System.out.println(oddEvenJumps(num));
    }
    class Pair{
        int index;
        int val;
        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}
