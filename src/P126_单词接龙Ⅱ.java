import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class P126_单词接龙Ⅱ {

    @Test
    public void test() {
        String[] s = {"hot","dot","dog","lot","log","cog"};
//        int n = ladderLength("hit","cog", Arrays.asList(s));
//        System.out.println(n);
//        Set<String> dict = Arrays.asList(s).stream().collect(Collectors.toSet());
//        System.out.println(getEdge("hit", dict));
        List<List<String>> m = findLadders("hit", "cog", Arrays.asList(s));
        System.out.println(m);

    }



        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            if(!wordList.contains(endWord)) {
                return new ArrayList<>();
            }

            Map<String, Integer> levelMap = new HashMap<>();
            int level = 0;
            levelMap.put(beginWord, level);

            ArrayDeque<String> queue = new ArrayDeque<>();
            queue.offer(beginWord);
            Set<String> dict = wordList.stream().collect(Collectors.toSet());
            dict.remove(beginWord);
            Map<String, List<String>> from = new HashMap<>();
            boolean found = false;


            while(!queue.isEmpty()) {
                int sz = queue.size();
                level++;
                for(int i = 0; i < sz; i++) {
                    String curWord = queue.poll();
                    dict.remove(curWord);

                    List<String> edges = getEdge(curWord, dict);

                    for(String nextWord : edges) {

                        if(levelMap.containsKey(nextWord) && level == levelMap.get(nextWord)) {
                            List<String> pre = from.getOrDefault(nextWord, new ArrayList<String>());
                            pre.add(curWord);
                            from.put(nextWord, pre);
                            continue;
                        }

                        if(!levelMap.containsKey(nextWord)) {
                            levelMap.put(nextWord, level);
                            from.putIfAbsent(nextWord, new ArrayList<String>());
                            from.get(nextWord).add(curWord);
                            queue.offer(nextWord);
                        }

                        if(nextWord.equals(endWord)) {
                            found = true;
                            break;
                        }

                    }
                }
                if(found) {
                    break;
                }

            }
            List<List<String>> ans = new ArrayList<>();
            if(found) {
                traceBack(beginWord, endWord, ans, from, new ArrayDeque<String>(){{add(endWord);}});
            }

            return ans;
        }

        public void traceBack(String beginWord, String endWord, List<List<String>> ans, Map<String,List<String>> from,
                              ArrayDeque<String> aPath) {
            if(beginWord.equals(endWord)) {
                List<String> oneAns = aPath.stream().collect(Collectors.toList());
                ans.add(oneAns);
                return;
            }
            List<String> preNodeList = from.getOrDefault(endWord, new ArrayList<>());
            for(String preNode : preNodeList) {
                aPath.addFirst(preNode);
                traceBack(beginWord, preNode, ans, from, aPath);
                aPath.removeFirst();
            }
        }




        public List<String> getEdge(String word, Set<String> dict) {
            List<String> result = new ArrayList<>();
            char[] wordArr = word.toCharArray();
            for(int i = 0; i < wordArr.length; i++) {
                char m = wordArr[i];

                for(char c = 'a'; c <= 'z'; c++) {
                    if(m != c) {
                        wordArr[i] = c;
                        String newWord = new String(wordArr);
                        if(dict.contains(newWord)){
                            result.add(newWord);
                        }
                        wordArr[i] = m;

                    }
                }
            }
            return result;
        }
}
