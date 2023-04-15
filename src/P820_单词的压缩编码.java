import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P820_单词的压缩编码 {
    public int minimumLengthEncoding(String[] words) {
        StringBuilder sb = new StringBuilder();
        if(words == null || words.length == 0) {
            return 0;
        }
        int n = words.length;
        Arrays.sort(words, (o1,o2) -> o2.length() - o1.length());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if(!set.contains(i)) {
                sb.append(words[i] + "#");
                set.add(i);
                for (int j = i+1; j < words.length; j++) {
                    if(!set.contains(j) && words[i].endsWith(words[j])) {
                        set.add(j);
                    }
                }
            }
        }
        System.out.println(sb.toString());
        return sb.length();
    }

    @Test
    public void test() {
        String[] words = {"time","me","bell"};
        minimumLengthEncoding(words);
    }
}
