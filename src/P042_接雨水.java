import java.util.LinkedList;

public class P042_接雨水 {
    public int trap(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        if(height.length == 0) {
            return 0;
        }
        stack.push(0);
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            int peek = stack.peek();
            if(height[i] < height[peek]) {
                stack.push(i);
                continue;
            }else if(height[i] > height[peek]){
                if(stack.size() > 1) {
                       int low = stack.pop();
                       int high = stack.peek();
                       while (!stack.isEmpty() && height[high] <= height[i]) {
                           stack.pop();
                           ans += (height[high] - height[low]) * (i - high - 1);
                           low = high;
                           if(!stack.isEmpty()) {
                               high = stack.peek();
                           }
                       }
                       if(height != null && height[high] > height[i]) {
                           ans += (height[i] - height[low]) * (i-high-1);
                       }
                        stack.push(i);
                }else {
                    stack.clear();
                    stack.push(i);
                    continue;
                }
            }else {
                if(peek == i - 1) {
                    stack.pop();
                    stack.push(i);
                    continue;
                }
            }
        }
        return ans;
    }
}
