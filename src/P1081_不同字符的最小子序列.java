import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class P1081_不同字符的最小子序列 {
    public String smallestSubsequence(String text) {
        boolean[] map = new boolean[26];
        Arrays.fill(map,false);
        if(text.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(!map[c-'a']) {
                while (!stack.isEmpty()) {
                    char pre = stack.peek();
                    if(pre < c) break;
                    int pos = text.indexOf(pre,i);
                    if(pos < 0) break;
                    else{
                        stack.pop();
                        map[pre-'a'] = false;
                    }
                }
                stack.push(c);
                map[c-'a'] = true;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(smallestSubsequence("bdaccdbddc"));
    }
}
