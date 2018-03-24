package com.yahoo.util;

public class Word1Dictionary {
	public static void main(String args[]) {
		WordDictionary word = new WordDictionary();
		word.addWord("bad");
		word.search("b..");
	}
}

class WordDictionary {
    private TrieNode2 root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode2();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieNode2 node = root;
        for (char ch : word.toCharArray()) {
            if (node.nodes[ch-'a'] == null) {
                node.nodes[ch-'a'] = new TrieNode2();
            }
            node = node.nodes[ch-'a'];
        }
        node.word = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root, 0);
    }
    
    public boolean search(String word, TrieNode2 node, int index) {
        if (index == word.length()) {
            return node != null ? node.word : false;
        } 
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (int j = 0; j < node.nodes.length; j++) {
                    if (node.nodes[j] != null) {
                        boolean status = search(word, node.nodes[j], i+1);
                        if (status) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                if (node.nodes[ch-'a'] == null) {
                    return false;
                }
                node = node.nodes[ch-'a'];
            }
        }
        return node != null ? node.word : false;
    }
}

class TrieNode2 {
    boolean word;
    TrieNode2 nodes[] = new TrieNode2[26];
}