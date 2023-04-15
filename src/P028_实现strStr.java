public class P028_实现strStr {
    String pat;
    int[] next;

    public int strStr(String haystack, String needle) {
        this.pat = needle;
        this.next = new int[needle.length()];
        if(needle.length() == 0) {
            return 0;
        }
        getNext();
        int j = 0,i = 0;
        while (i < haystack.length() && j < needle.length()) {
            if( j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    public void getNext() {
        next[0] = -1;
        int k = -1;
        int i = 0;
        while (i < pat.length() - 1) {
            if(k == -1 || pat.charAt(i) == pat.charAt(k)) {
                if(pat.charAt(++i) == pat.charAt(++k)) {
                    next[i] = next[k];
                }else {
                    next[i] = k;
                }
            }else {
                k = next[k];
            }
        }
    }
}
