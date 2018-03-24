package com.yahoo.util3;

import java.util.*;

public class ReplaceWords {
	public static void main(String args[]) {
		String strs[] = { "a", "aa", "aaa", "aaaa" };
		String str = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
		System.out.println(replaceWords(Arrays.asList(strs), str));;
		//"a a a a a a a a bbb baba a"
	}

	public static String replaceWords(List<String> dict, String sentence) {
		TrieNode root = buildTrie(dict);
		String splits[] = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String split : splits) {
			sb.append(generateWord(split, root));
		}
		return sb.toString().trim();
	}

	private static String generateWord(String split, final TrieNode root) {
		StringBuilder sb = new StringBuilder();
		TrieNode node = root;
		for (int i = 0; i < split.length() - 1; i++) {
			char ch = split.charAt(i);
			if (node.children[ch-'a'] != null && node.children[ch-'a'].word != null) {
                sb.append(node.children[ch-'a'].word).append(" ");
                break;
            } else if (node.children[ch-'a'] == null) {
            	if (node.word != null) {
            		sb.append(node.word).append(" ");
            	}
                break;
            }
			node = node.children[ch - 'a'];
		}
		if (sb.length() == 0) {
			sb.append(split).append(" ");
		}
		return sb.toString();
	}

	private static TrieNode buildTrie(List<String> dict) {
		TrieNode root = new TrieNode();
		for (String word : dict) {
			TrieNode node = root;
			for (char ch : word.toCharArray()) {
				if (node.children[ch - 'a'] == null) {
					node.children[ch - 'a'] = new TrieNode();
				}
				node = node.children[ch - 'a'];
			}
			node.word = word;
		}
		return root;
	}
}

class TrieNode {
	TrieNode children[] = new TrieNode[26];
	String word;
}