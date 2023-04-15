import org.junit.Test;

import java.util.*;

public class P179_最大数 {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = nums[i] + "";
        }
        ArrayList<String> queue = new ArrayList<>();
        queue.addAll(Arrays.asList(str));
        Collections.sort(queue, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String sum1 = o1+o2;
                String sum2 = o2+o1;
                return sum2.compareTo(sum1);
            }
        });
        if(queue.get(0).equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : queue) {
            sb.append(s);
        }
        return sb.toString();
    }

    @Test
    public void mytest() {
        int[] num = {3,30,34,5,9};
        largestNumber(num);
    }
}
