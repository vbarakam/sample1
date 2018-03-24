package com.yahoo.mediam;

public class ImplementTrie {
	public static void main(String args[]) {
		Trie trie = new Trie();
		trie.insert("app");
		trie.insert("apple");
		trie.insert("beer");
		trie.insert("add");
		trie.insert("jam");
		trie.insert("rental");
		System.out.println(trie.startsWith("apps"));
		
	}
}

class Trie {
	private TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.nodes[c - 'a'] == null) {
				node.nodes[c - 'a'] = new TrieNode();
			}
			node = node.nodes[c - 'a'];
		}
		node.word = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.nodes[c - 'a'] == null) {
				return false;
			}
			node = root.nodes[c - 'a'];
		}
		return node.word;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		int index = 0;
		for (char c : prefix.toCharArray()) {
			if (node.nodes[c - 'a'] != null) {
				node = node.nodes[c - 'a'];
				index++;
			}
		}
		 if (node.word) {
	            return node.word;
	        }
		 
		if (index > 0 && node != null) {
			for (TrieNode node2 : node.nodes) {
				if (node2 != null) {
					return true;
				}
			}
		}
		return false;
	}
}

class TrieNode {
	boolean word = false;
	TrieNode nodes[] = new TrieNode[26];
}