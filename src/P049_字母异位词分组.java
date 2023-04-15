import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P049_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if(strs.length == 0) {
            return ans;
        }
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].equals("")) {
                List<String> part = new ArrayList<>();
                part.add("");
                for (int j = i + 1; j < strs.length; j++) {
                    if(strs[j].equals("")) {
                        part.add("");
                        strs[j] = "999";
                    }
                }
                ans.add(part);
            } else if(!strs[i].equals("999")) {
                List<String> part = new ArrayList<>();
                part.add(strs[i]);
                HashMap<Character, Integer> needs = new HashMap<>();
                for (int j = 0; j < strs[i].length(); j++) {
                    needs.put(strs[i].charAt(j), needs.getOrDefault(strs[i].charAt(j),0)+1);
                }
                matches(part, strs, strs[i], i, needs);
                ans.add(part);
            }
        }
        return ans;
    }

    private void matches(List<String> part, String[] strs, String str, int i, HashMap<Character, Integer> needs) {
        HashMap<Character, Integer> windows = new HashMap<>();
        for (int j = i + 1; j < strs.length; j++) {
            if(!strs[j].equals("999")) {String t = strs[j];
                windows.clear();
                if(t.length() != str.length()) {
                    continue;
                }else {
                    int right = 0;
                    int match = 0;
                    while (right < t.length()) {
                        char c = t.charAt(right);
                        if(needs.containsKey(c)) {
                            windows.put(c, windows.getOrDefault(c,0) + 1);
                            if(needs.get(c).equals(windows.get(c))) {
                                match++;
                            }
                            if(match == needs.size()) {
                                part.add(strs[j]);
                                strs[j] = "999";
                                break;
                            }
                        }else{
                            break;
                        }
                        right++;
                    }
                }
            }
        }
    }

    @Test
    public void test() {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(s);
        System.out.println(result);
    }
}
