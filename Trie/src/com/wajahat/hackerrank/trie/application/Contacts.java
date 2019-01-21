package com.wajahat.hackerrank.trie.application;

import java.util.Scanner;

public class Contacts {

	private static class TrieNode {
		private static final int NUMBER_OF_CHARACTERS = 26;
		public TrieNode [] children;
		public int size;

		public TrieNode() {
			children = new TrieNode[NUMBER_OF_CHARACTERS];
			size = 0;
		}

		private int getCharIndex(char c) {
			return (c - 'a');
		}

		private TrieNode getNode(char c) {
			return children[getCharIndex(c)];
		}

		private void setNode(char c, TrieNode node) {
			children[getCharIndex(c)] = node;
		}

		public void add(String s) {
			add(s, 0);
		}
		
		public int findCount(String s) {
			return findCount(s, 0);
		}

		private void add(String s, int index) {
			size++;
			if (index == s.length()) return;
			char c = s.charAt(index);
			TrieNode child = getNode(c);
			if (child == null) {
				child = new TrieNode();
				setNode(c, child);
			}
			child.add(s, index+1);
		}
		
		private int findCount(String s, int index) {
			if (index == s.length()) {
				return size;
			}
			TrieNode child = getNode(s.charAt(index));
			if (child == null) {
				return 0;
			}
			return child.findCount(s, index + 1);
		}
	}


	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		try(Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			for (int i = 0; i < N; i++) {
				String cmd = scanner.next();
				String word = scanner.next();

				if (cmd.equalsIgnoreCase("add")) {
					root.add(word);
				} else if (cmd.equalsIgnoreCase("find")) {
					System.out.println(root.findCount(word));
				}
			}
		}
	}
}
