import org.junit.Test;

public class P208_实现trie前缀树 {

    private TrieNode root;
    class TrieNode {
        private final int R = 26;
        private TrieNode[] links;
        private boolean isEnd = false;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public void setEnd(boolean end) {
            this.isEnd = end;
        }

        public boolean getEnd() {
            return this.isEnd;
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }
    }
        /** Initialize your data structure here. */
        public P208_实现trie前缀树() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!node.containsKey(c)) {
                    node.put(c, new TrieNode());

                }
                node = node.get(c);
            }
            node.setEnd(true);
        }

        public TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!node.containsKey(c)) {
                    return null;
                }
                node = node.get(c);
            }
            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.getEnd() == true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
        @Test
    public void test() {
            P208_实现trie前缀树 trie = new P208_实现trie前缀树();
            trie.insert("apple");
            System.out.println(trie.search("apple"));   // 返回 true
            System.out.println(trie.search("app"));    // 返回 false
            System.out.println(trie.startsWith("app")); // 返回 true
            trie.insert("app");
            System.out.println(trie.search("app"));     // 返回 true
        }
}
