package leetcode.trie;

import java.io.PrintWriter;
import java.util.Optional;

//Problem 208
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //вставка ключа (слова) в дерево
    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    //поиск ключа (слова) в дереве
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    //проверка префикса
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    //поиск префикса, метод-помощник для search и startWith
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currLetter = word.charAt(i);
            if (node.containsKey(currLetter)) {
                node = node.get(currLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    //поиск длиннейшего префикса
    public String searchLongestPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter) && node.getLinks() == 1 && !node.isEnd()) {
                prefix.append(curLetter);
                node = node.get(curLetter);
            } else {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }
}
