import javafx.util.Pair;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class P127_单词接龙 {
    HashMap<String, Integer> map = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String> > map = new HashMap<>();
        int length = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String generalMatch = word.substring(0,i) + "*" + word.substring(i+1, length);
                ArrayList<String> list = map.getOrDefault(generalMatch, new ArrayList<String>());
                list.add(word);
                map.put(generalMatch, list);
            }
        }

        LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
        HashMap<String, Boolean> visit = new HashMap<>();
        visit.put(beginWord, true);
        int level = 1;
        queue.offer(new Pair<>(beginWord, level));
        while (!queue.isEmpty()) {
            Pair<String,Integer> top = queue.poll();
            String key = top.getKey();
            level = top.getValue();

            for (int i = 0; i < length; i++) {
                String match = key.substring(0,i) + "*" + key.substring(i+1,length);
                ArrayList<String> list = map.getOrDefault(match,new ArrayList<>());
                for (int j = 0; j < list.size(); j++) {
                    String word = list.get(j);
                    if(word.equals(endWord)) {
                        return level+1;
                    }else if(!visit.getOrDefault(word,false)){
                        visit.put(word, true);
                        queue.offer(new Pair<>(word,level+1));
                    }
                }
            }
        }
        return 0;
    }


    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int ans = solve(beginWord, endWord, wordList);
        if(ans == -1) {
            return 0;
        }else {
            return ans + 1;
        }
    }

    private int solve(String beginWord, String endWord, List<String> wordList) {
        if(map.containsKey(beginWord)) {
            return map.get(beginWord);
        }
        if(beginWord.equals(endWord)) {
            map.put(beginWord, 0);
            return 0;
        }
        int MinnextStep = Integer.MAX_VALUE;
        for (int i = 0; i < wordList.size(); i++) {
            int start = 0, num = 0;
            String word = wordList.get(i);
            while (start < beginWord.length() && num <= 1 && !beginWord.equals(word)) {
                if(beginWord.charAt(start) != word.charAt(start)) {
                    num++;
                }
                start++;
            }
            if(num == 1) {
                ArrayList<String> list = new ArrayList<>(wordList);
                list.remove(i);
                int next = solve(word, endWord, list);
                if(next >= 0) {
                    MinnextStep = Math.min(MinnextStep, next + 1);
                }
            }
        }
        if(MinnextStep == Integer.MAX_VALUE) {
            map.put(beginWord, -1);
            return -1;
        }else {
            map.put(beginWord,MinnextStep);
            return MinnextStep;
        }
    }

    @Test
    public void test() {
        String[] s = {"hot","dot","dog","lot","log","cog"};
//        int n = ladderLength("hit","cog", Arrays.asList(s));
//        System.out.println(n);
//        Set<String> dict = Arrays.asList(s).stream().collect(Collectors.toSet());
//        System.out.println(getEdge("hit", dict));
        int m = ladderLength3("hit", "cog", Arrays.asList(s));
        System.out.println(m);
    }


    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }

        Map<String,Integer> levelMap = new HashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int level = 1;
        levelMap.put(beginWord, level);
        Set<String> dict = wordList.stream().collect(Collectors.toSet());
        dict.remove(beginWord);
        boolean found = false;

        while(!queue.isEmpty()) {
            level++;
            int sz = queue.size();
            for(int i = 0; i < sz; i++) {
                String curWord = queue.poll();
                dict.remove(curWord);
                List<String> edge = getEdge(curWord, dict);

                for(String nextWord: edge) {
                    if(levelMap.containsKey(nextWord) && levelMap.get(nextWord) <= level) {
                        continue;
                    }
                    levelMap.put(nextWord, level);
                    queue.offer(nextWord);
                    if(nextWord.equals(endWord)) {
                        found = true;
                        break;
                    }
                }

                if(found) {
                    break;
                }
            }
            if(found) {
                break;
            }
        }

        if(found) {
            return levelMap.get(endWord);
        }else{
            return 0;
        }


    }

    public List<String> getEdge(String word, Set<String> dict) {
        List<String> result = new ArrayList<>();
        char[] charArray = word.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            char now = charArray[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c != now) {
                    charArray[i] = c;
                    String nextWord = new String(charArray);
                    if(dict.contains(nextWord)) {
                        result.add(nextWord);
                    }
                    charArray[i] = now;
                }
            }
        }
        return result;
    }





}
