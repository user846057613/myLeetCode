import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class P990_等式方程的可满足性 {
    int[] parent = new int[26];
    int[] level = new int[26];

    public boolean equationsPossible(String[] equations) {
        if(equations.length == 0) return true;
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            level[i] = 1;
        }

        for (int i = 0; i < equations.length; i++) {
            String equ = equations[i];
            char op = equ.charAt(1);
            if(op == '=') {
                char left = equ.charAt(0);
                char right = equ.charAt(3);
                union(left-'a', right-'a');
            }
        }

        for (int i = 0; i < equations.length; i++) {
            String equ = equations[i];
            char op = equ.charAt(1);
            if(op == '!') {
                char left = equ.charAt(0);
                char right = equ.charAt(3);
                if(find(left-'a') == find(right-'a')) return false;
            }
        }
        return true;
    }

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa != pb) {
            if(level[pa] >= level[pb]) {
                parent[pb] = pa;
                level[pa] += level[pb];
            }else{
                parent[pa] = pb;
                level[pb] += level[pa];
            }
        }
    }

    private int find(int a) {
        if(parent[a] != a) {
            int p = parent[a];
            parent[a] = find(p);
            return parent[a];
        }else{
            return a;
        }
    }

    @Test
    public void test() {
        String[] s = {"a==b","b!=a"};
        System.out.println(equationsPossible(s));
    }
}
