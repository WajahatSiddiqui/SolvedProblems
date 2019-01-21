package com.wajahat.hackerrank.trie;

/**
 * Trie
 * @author wajahat
 */
public class Trie {
	private TrieNode root;
	private int size = 0;

	Trie() {
		root = new TrieNode();
	}

	/**
	 * Insert the given word in Trie
	 * @param word to be inserted
	 */
	public void insert(String word) {
		TrieNode current = root;
		int wordLen = word.length();
		for (int i = 0; i < wordLen; i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.isCompleteWord = true;
		size++;
	}

	/**
	 * Delete the given word from Trie
	 * @param word to be deleted
	 */
	public void delete(String word) {
		delete(root, word, 0);
		if (!contains(word)) {
			size--;
		}
	}

	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			if (!current.isCompleteWord) {
				return false;
			}
			current.isCompleteWord = false;
			return current.children.size() == 0;
		}

		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}

		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}

	/**
	 * Search for the given prefix in Trie
	 * @param prefix - the prefix to be searched
	 * @return - true if the prefix is found, false otherwise
	 */
	boolean searchPrefix(String prefix) {
		TrieNode current = root;
		int prefixLen = prefix.length();
		boolean found = true;
		for (int i = 0; i < prefixLen; i++) {
			char ch = prefix.charAt(i);
			if (!current.children.containsKey(ch)) {
				found = false;
				break;
			}
			current = current.children.get(ch);
		}
		return found;
	}

	/**
	 * Check if the given word is present in Trie
	 * @param word - the word to be searched
	 * @return true of the word is contained in Trie, false otherwise.
	 */
	public boolean contains(String word) {
		TrieNode current = root;
		int wordLen = word.length();
		for (int i = 0; i < wordLen; i++) {
			char ch = word.charAt(i);
			if (!current.children.containsKey(ch)) {
				return false;
			}
			current = current.children.get(ch);
		}
		return current.isCompleteWord;		
	}

	/**
	 * @return the current size of Trie
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @return true if the Trie is empty, false otherwise.
	 */
	public boolean isEmpty() { return size == 0; }
	
	/**
	 * String representation of Trie
	 */
	@Override
	public String toString() {
		if (isEmpty()) return "";
		return "[root node] "+ root.toString();
	}
}
