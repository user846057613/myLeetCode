public class P461_汉明距离 {
    public int hammingDistance(int x, int y) {
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);
        int maxLength = Math.max(s1.length(), s2.length());
        int sub1 = maxLength - s1.length();
        int sub2 = maxLength - s2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sub1; i++) {
            sb.append("0");
        }
        s1 = sb.append(s1).toString();
        sb.delete(0, sb.length());
        for (int i = 0; i < sub2; i++) {
            sb.append("0");
        }
        s2 = sb.append(s2).toString();
        int result = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                result++;
            }
        }
        return result;
    }
}
