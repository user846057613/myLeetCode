import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P212_单词搜索Ⅱ {
    class Trie{
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insertWord(String str) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(!node.hasWord(c)) {
                    node.addWord(c);
                }
                node = node.nextNode(c);
            }
            node.setWord(true);
        }

        public TrieNode getSuffix(String str) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(node.hasWord(c)) {
                    node = node.nextNode(c);
                    continue;
                }else {
                    return null;
                }
            }
            return node;
        }

        public boolean isSuffix(String str) {
            TrieNode node = getSuffix(str);
            return node != null;
        }

        public boolean containWord(String str) {
            TrieNode node = getSuffix(str);
            return node == null ? false : node.isWord;
        }

        class TrieNode{
            private TrieNode[] text;
            private boolean isWord;
            static final int LENGTH = 26;

            public TrieNode() {
                text = new TrieNode[LENGTH];
                isWord = false;
            }

            public boolean isWord() {
                return isWord;
            }
            public void setWord(boolean isWord) {
                this.isWord = isWord;
            }

            public TrieNode nextNode(char c) {
                return text[c-'a'];
            }

            public boolean hasWord(char c) {
                return text[c-'a'] != null;
            }
            public void addWord(char c) {
                text[c-'a'] = new TrieNode();
            }
        }
    }

    int m;
    int n;
    int[][] dxy = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        if(board.length == 0 || board[0].length == 0) {
            return ans;
        }
        Trie trie = new Trie();
        constructTree(trie, words);
        this.m = board.length;
        this.n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(trie.isSuffix(board[i][j] + "")) {
                    dfs(board,trie,visit,i,j,ans,"");
                }
            }
        }
        HashSet<String> hs = new HashSet<>(ans);
        ans.clear();
        ans.addAll(hs);
        return ans;
    }

    private void dfs(char[][] board, Trie trie, boolean[][] visit, int i, int j, ArrayList<String> ans,String s) {
        String word = s + board[i][j];
        if(trie.containWord(word)) {
            ans.add(word);
        }
        visit[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dxy[k][0];
            int y = j + dxy[k][1];
            if(isValid(x,y) && !visit[x][y] && trie.isSuffix(word)) {
                dfs(board, trie, visit, x, y, ans, word);
            }
        }
        visit[i][j] = false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y< n;
    }

    private void constructTree(Trie trie, String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            trie.insertWord(word);
        }
    }
}
