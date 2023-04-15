import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class P205_同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> visitTo = new HashSet<>();
        HashSet<Character> visitFrom = new HashSet<>();
        if(s.length() == 0 && t.length() == 0) return true;
        for (int i = 0; i < s.length(); i++) {
            char from = s.charAt(i);
            char to = t.charAt(i);
            if(!visitTo.contains(to)) {
                if(!visitFrom.contains(from)) {
                    visitTo.add(to);
                    visitFrom.add(from);
                    map.put(from,to);
                }else {
                    return false;
                }
            }else{
                if(!map.getOrDefault(from, '\0').equals(to)) return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        isIsomorphic("foo", "bar");

    }
}
