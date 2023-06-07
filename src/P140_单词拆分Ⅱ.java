import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 *
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 *
 *
 *
 * 示例 1：
 *
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 * 示例 2：
 *
 * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * 输出:[]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中所有字符串都 不同
 */

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

    public List<String> wordBreak2(String s, List<String> wordDict) {
        return helper(s, 0, new HashSet<>(wordDict), new HashMap<Integer, List<String>>());
    }

    public List<String> helper(String s, int index, Set<String> dict, Map<Integer, List<String>> cache) {
        if(index == s.length()) {
            return new ArrayList<String>(){{add("");}};
        }

        if(cache.containsKey(index)) {
            return cache.get(index);
        }

        List<String> result = new ArrayList<String>();

        for(int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if(dict.contains(sub)) {
                List<String> next = helper(s, i, dict, cache);
                if(next.size() > 0) {
                    for(int j = 0; j < next.size(); j++) {
                        String nextStr = next.get(j);
                        if(nextStr.equals("")) {
                            result.add(sub);
                        }else {
                            result.add(sub + " " + nextStr);
                        }
                    }
                }
            }
        }
        cache.put(index, result);
        return cache.get(index);
    }
}
