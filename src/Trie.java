public class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

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

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.getEnd();
    }

    public boolean startsWith(String word) {
        return searchPrefix(word) != null;
    }

    public void delete(String word) {
        TrieNode node = searchPrefix(word);
        if(node != null && node.getEnd()) {
            node.setEnd(false);
        }
    }

    class TrieNode{
        private final int R = 26;
        TrieNode[] links;
        boolean isEnd;

        TrieNode() {
            links = new TrieNode[R];
        }

        public boolean getEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            this.isEnd = end;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public void delete(char c) {
            links[c - 'a'] = null;
        }
    }
}
