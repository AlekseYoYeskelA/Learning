package leetcode.trie;

import java.util.Arrays;

//Problem 208
public class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private int size; //число дочерних эл-тов ненулевой ссылки
    private boolean isEnd;


    public TrieNode() {
        links = new TrieNode[R]; //массив из 26 эл-тов (указатели на дочерние эл-ты)
    }

    // (int)'a' = 97 ... (int)'z' = 122
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public int getLinks() {
        return size;
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
        size++;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "links=" + Arrays.toString(links) +
                '}';
    }
}
