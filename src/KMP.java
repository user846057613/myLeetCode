public class KMP {
    String pat;
    int[] next;

    public KMP(String pat) {
        this.pat = pat;
        next = new int[pat.length()];
    }

    public void getNext() {
        next[0] = -1;
        int k = -1;
        int i = 0;
        while (i < pat.length()) {
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
