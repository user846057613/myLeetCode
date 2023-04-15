import org.junit.Test;

public class P151_翻转字符串里的单词 {
    public String reverseWords(String s) {
        int left = s.length() - 1, right = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (left >= 0 && right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ') {
                right--;
            }
            left = right;
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            if(sb.length() > 0 && right >= 0) {
                sb.append(" ");
            }
            if(right >= 0) {
                sb.append(s, left+1, right+1);
            }
            right = left;
        }
        return sb.toString();
    }

    @Test
    public void test() {
        reverseWords("a");
    }
}
