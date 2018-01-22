package com.wajahat.solution;

import java.util.Scanner;

public class NoPrefixSet {

	private static class TrieNode {
		private static int NUMBER_OF_CHARACTERS = 10;
		private TrieNode []children;
		private boolean isWordEnd;
		private int size;

		public TrieNode() {
			children = new TrieNode[NUMBER_OF_CHARACTERS];
			isWordEnd = false;
			size = 0;
		}

		private int getCharIndex(char c) {
			return (c - 'a');
		}

		private TrieNode getNode(char c) {
			return children[getCharIndex(c)];
		}

		private void setNode(TrieNode node, char c) {
			children[getCharIndex(c)] = node;
		}
	}

	private static class Trie {
		TrieNode root = new TrieNode();
		private void add(String word) {
			TrieNode current = root;
			int wordLen = word.length();
			for (int i = 0; i < wordLen; i++) {
				char ch = word.charAt(i);
				TrieNode node = current.getNode(ch);
				if (node == null) {
					node = new TrieNode();
					current.setNode(node, ch);
				}
				current = node;
				current.size++;
			}
			current.isWordEnd = true;
		}

		// finds if the word already exists
		private boolean findWord(String word) {
			TrieNode current = root;
			int wordLen = word.length();
			for (int i = 0; i < wordLen; i++) {
				char ch = word.charAt(i);
				TrieNode node = current.getNode(ch);
				if (node == null) {
					return current.isWordEnd;
				}
				current = node;
			}
			return current.isWordEnd;
		}
		
		private int findCount(String word) {
			TrieNode current = root;
			int wordLen = word.length();
			for (int i = 0; i < wordLen; i++) {
				char ch = word.charAt(i);
				TrieNode node = current.getNode(ch);
				if (node == null) {
					return 0;
				}
				current = node;
			}
			return current.size;
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			Trie trie = new Trie();
			String []words = new String[N];
			for (int i = 0; i < N; i++) {
				words[i] = scanner.next();
				if (!trie.findWord(words[i])) {
					trie.add(words[i]);
				} else {
					System.out.println("BAD SET\n" + words[i]);
					return;
				}
			}

			// words can come in any order
			/*for (int i = 0; i < N; i++) {
				if (trie.findCount(words[i]) > 1) {
					System.out.println("BAD SET\n" + words[i]);
					return;
				}
			}*/
			System.out.println("GOOD SET");
		}
	}

}
