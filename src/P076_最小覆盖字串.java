import java.util.HashMap;

public class P076_最小覆盖字串 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        String res = "";
        int matches = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            if(needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if(needs.get(c).equals(windows.get(c))) {
                    matches++;
                }
                while(left <= right && matches == needs.size()) {
                    String now = s.substring(left, right + 1);
                    if("".equals(res) || now.length() < res.length()) {
                        res = now;
                    }
                    char l = s.charAt(left);
                    if(needs.containsKey(l)) {
                        windows.put(l, windows.getOrDefault(l, 0) - 1);
                        if(windows.get(l) < needs.get(l)) {
                            matches--;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        return res;
    }
}
