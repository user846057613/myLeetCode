import java.util.HashSet;
import java.util.List;

public class P139_单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet<String>(wordDict), 0 , new Boolean[s.length()]);
    }

    private boolean word_Break(String s, HashSet<String> strings, int start, Boolean[] booleans) {
        if(start == s.length()) {
            return true;
        }
        if(booleans[start] != null) {
            return booleans[start];
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if(strings.contains(s.substring(start, i)) &&
            word_Break(s, strings, i, booleans)) {
                return booleans[start] = true;
            }
        }
        return booleans[start] = false;
    }

}
