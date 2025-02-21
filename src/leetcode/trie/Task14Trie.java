package leetcode.trie;

import java.util.Objects;

public class Task14Trie {
    public static final String EMPTY_STRING = "empty";

    public String longestCommonPrefixTrie(String query, String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return EMPTY_STRING;
        }

        if (strs.length == 1) {
            return strs[0];
        }

        Trie trie = new Trie();
        for (int i = 1; i < strs.length; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(query);
    }
}

class Test14Trie {
    public static void main(String[] args) {
        Task14Trie t = new Task14Trie();
        String[] strs = {"flower", "flow", "float", "fly"};
        System.out.println(t.longestCommonPrefixTrie("flush", strs));
        System.out.println("---------------------------------------------");

        Trie trie = new Trie();
        for (int i = 1; i < strs.length; i++) {
            trie.insert(strs[i]);
        }

        System.out.println(trie.search("float"));
        System.out.println(trie.search("flops"));
        System.out.println(trie.startsWith("fly"));
    }
}