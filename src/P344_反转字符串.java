public class P344_反转字符串 {
    public void reverseString(char[] s) {
        if(s.length == 0) {
            return;
        }
        int left = 0 , right = s.length - 1;
        while (left < right) {
            char c = s[left];
            s[left++] = s[right];
            s[right--] = c;

        }
    }
}
