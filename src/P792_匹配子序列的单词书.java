import java.util.ArrayList;
import java.util.Map;

public class P792_匹配子序列的单词书 {
    public int numMatchingSubseq(String S, String[] words) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            char c = s.charAt(0);
            list.get(c-'a').add(s);
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            ArrayList<String> strings = list.get(c-'a');
            ArrayList<String> tmp = new ArrayList<>();
            for (int j = 0; j < strings.size(); j++) {
                String s = strings.get(j);
                if(s.length() == 1) count++;
                else{
                    String sub = s.substring(1);
                    if(sub.charAt(0) == c) tmp.add(sub);
                    else list.get(sub.charAt(0)-'a').add(sub);
                }
            }
            strings.clear();
            strings.addAll(tmp);
        }
        return count;
    }



    public int numMatchingSubseq1(String S, String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int beginIndex = 0;
            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                int newIndex = -1;
                if(beginIndex < S.length()) {
                    newIndex = S.indexOf(c,beginIndex);
                }
                if(newIndex < 0) {
                    flag = false;
                    break;
                }else{
                    beginIndex = newIndex + 1;
                }
            }
            if(flag) count++;
        }
        return count;
    }
}
