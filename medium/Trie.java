/*
  Implement a trie with insert, search, and startsWith methods.

  Example:

  Trie trie = new Trie();

  trie.insert("apple");
  trie.search("apple");   // returns true
  trie.search("app");     // returns false
  trie.startsWith("app"); // returns true
  trie.insert("app");   
  trie.search("app");     // returns true
  Note:

  You may assume that all inputs are consist of lowercase letters a-z.
  All inputs are guaranteed to be non-empty strings.*/

class Trie {
    private static class Node {
        private Map<Character, Node> children;
        private boolean isEntry;

        public Node() { children = new HashMap<Character, Node>(); }

        public void    setEntry(boolean entry) { isEntry = entry; }
        public boolean isEntry()               { return isEntry; }

        public boolean hasChild(char c) { return children.containsKey(c); }
        public void    addChild(char c) { children.put(c, new Node()); }
        public Node    getChild(char c) { return children.get(c); }
    }

    private Node root;

    private Node trieTraverse(String word, boolean insert) {
        Node cur = root;
        boolean notFound = false;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!cur.hasChild(c)) {
                if (insert) cur.addChild(c);
                else return null;
            }
            cur = cur.getChild(c);
        }
        return cur;
    }

    /** Initialize your data structure here. */
    public Trie() { root = new Node(); }


    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = trieTraverse(word, true);
        cur.setEntry(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = trieTraverse(word, false);
        return cur != null && cur.isEntry();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = trieTraverse(prefix, false);
        return cur != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
