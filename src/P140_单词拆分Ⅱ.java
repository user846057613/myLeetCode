import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P140_单词拆分Ⅱ {
    HashMap<Integer,List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || wordDict.size() == 0) {
            return new ArrayList<String>();
        }
        return solve(s,wordDict,0);
    }

    private List<String> solve(String s, List<String> wordDict, int start) {
        if(map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if(start == s.length()) {
            res.add("");
        }else {
            for (int i = start + 1; i <= s.length(); i++) {
                if(wordDict.contains(s.substring(start, i))) {
                    List<String> list = solve(s,wordDict,i);
                    for (String s1 : list) {
                        res.add(s.substring(start,i) + (s1.equals("") ? "" : " ") + s1);
                    }
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
