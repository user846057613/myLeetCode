public class P1111_有效括号的嵌套深度 {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        if(n == 0) {
            return new int[0];
        }
        int[] ans = new int[n];
        int index = 0;
        for (int i = 0; i < seq.length(); i++) {
            ans[index++] = seq.charAt(i) == '(' ? index & 1 : (index + 1) & 1;
        }
        return ans;
    }
}
