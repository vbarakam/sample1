package com.yahoo.util;

import java.util.*;

public class WordSearchII {
	public static void main(String args[]) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String words[] = { "oath", "pea", "eat", "rain" };
		//		char [][] board = {{'a'}};
		//		String words [] = {"a"};
		TrieNode root = buildTrie2(words);
		List<String> results = new ArrayList<>();
				findWords2(board, words);
		
		System.out.println(results);
	}

	private static void find(char[][] board, int i, int j, TrieNode node, List<String> results) {


		if (i < 0 || j < 0  || i >= board.length || j >= board[0].length ) {
			if (node.word != null) {
				results.add(node.word);
				node.word = null;
			}
			return;
		}
		
		char ch = board[i][j];
		if (ch == '#' || node.nodes[ch - 'a'] == null) {
			if (node.word != null) {
				results.add(node.word);
				node.word = null;
			}
			return;
		}
		TrieNode next = node.nodes[ch - 'a'];

		board[i][j] = '#';

		//if (i - 1 >= 0) {
			find(board, i - 1, j, next, results);
		//}

		//if (i + 1 < board.length) {
			find(board, i + 1, j, next, results);
		//}

		//if (j - 1 >= 0) {
			find(board, i, j - 1, next, results);
		//}

		//if (j + 1 < board[0].length) {
			find(board, i, j + 1, next, results);
		//}

		board[i][j] = ch;
	}

	public static List<String> findWords2(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> results = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
            	if (root.nodes[board[i][j] - 'a'] != null) {
                    findWords(board, root, i, j, results);
                }
            }
        }
        
        return results;
    }
	
	private static void findWords(char[][] board, TrieNode trie, int i, int j, List<String> results) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length  || board[i][j] == '#') {
            if (trie != null && trie.word != null) {
                results.add(trie.word);
                trie.word = null;
            }
            return;
        }
        
        if (trie.nodes[board[i][j] - 'a'] != null) {   
            char ch = board[i][j];
            board[i][j] = '#';
            findWords(board, trie.nodes[ch - 'a'], i+1, j, results);
            findWords(board, trie.nodes[ch - 'a'], i-1, j, results);
            findWords(board, trie.nodes[ch - 'a'], i, j+1, results);
            findWords(board, trie.nodes[ch - 'a'], i, j-1, results);
            board[i][j] = ch;
        }
    }
	
	private static void check2(char[][] board, int i, int j, TrieNode root, List<String> results) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || root == null) {
            if (root != null && root.word != null) {
                results.add(root.word);
                root.word = null;
            }
            return;
        }
        
        char c = board[i][j];
        if (board[i][j] == '#' || root.nodes[c-'a'] == null) {
            if (root.word != null) {
                results.add(root.word);
                root.word = null;
            }
            return;
        }
        
        board[i][j] = '#';
        check2(board, i+1, j, root.nodes[c-'a'], results);
        check2(board, i-1, j, root.nodes[c-'a'], results);
        check2(board, i, j+1, root.nodes[c-'a'], results);
        check2(board, i, j-1, root.nodes[c-'a'], results);
        board[i][j] = c;
    }
	
	private static TrieNode buildTrie2(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.nodes[c-'a'] ==  null) {
                    node.nodes[c-'a'] = new TrieNode();
                }
                node = node.nodes[c-'a'];
            }
            node.word = word;
        }
        return root;
    }
	
	private static TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			TrieNode node = root;
			for (char c : words[i].toCharArray()) {
				if (node.nodes[c - 'a'] == null) {
					node.nodes[c - 'a'] = new TrieNode();
				}
				node = node.nodes[c - 'a'];
			}
			node.word = words[i];
		}
		return root;
	}
}

class TrieNode {
	TrieNode nodes[] = new TrieNode[26];
	String word;

	public TrieNode() {
	}
}
