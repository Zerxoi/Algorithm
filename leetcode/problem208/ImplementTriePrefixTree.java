package leetcode.problem208;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

class Trie {
    Trie[] children;
    boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie tmp = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (tmp.children[c - 'a'] == null) {
                tmp.children[c - 'a'] = new Trie();
            }
            tmp = tmp.children[c - 'a'];
        }
        tmp.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie tmp = searchPrefix(word);
        return tmp != null && tmp.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie tmp = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (tmp.children[c - 'a'] == null) {
                return null;
            }
            tmp = tmp.children[c - 'a'];
        }
        return tmp;
    }
}