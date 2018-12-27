package com.wajahat.tree.fenwicktree;

public class FenwickTree {
	private int [] binaryIndexedTree;
	
	/**
	 * Get the parent index of the given index
	 * Algo:
	 *  1) Take 2's complement of index
	 *  2) AND with the index
	 *  3) SUB the result with the index
	 * @param index
	 * @return Parent index
	 */
	private int getParent(int index) {
		return index - (index & -index);
	}
	
	/**
	 * Get the next index from the given index
	 * Algo:
	 * 	1) Take the 2'c complement of index
	 *  2) AND with the index
	 *  3) ADD the result with the index
	 * @param index
	 * @return
	 */
	private int getNext(int index) {
		return index + (index & -index);
	}
	
	/**
	 * Create a binary indexed tree for each given value
	 * inital value will be 0 so we start from 1 and fill all
	 * values with index + 1
	 * @param input
	 */
	public void createTree(int[] input) {
		binaryIndexedTree = new int[input.length + 1];
		for (int i = 1; i <= input.length; i++) {
			updateBinaryIndexedTree(input[i-1], i);
		}
	}
	
	public int getIndexValue(int index) {
		if (binaryIndexedTree == null || index < 0 || index > binaryIndexedTree.length) {
			return -1;
		}
		return binaryIndexedTree[index];
	}
	
	/**
	 * Get the sum of till from [0, index] inclusive
	 * @param index
	 * @return sum
	 */
	public int getSum(int index) {
		index++;
		if (index < 0 || index >= binaryIndexedTree.length) { return -1; }
		int sum = 0;
		while (index > 0) {
			sum += binaryIndexedTree[index];
			index = getParent(index);
		}
		return sum;
	}
	
	private void updateBinaryIndexedTree(int value, int index) {
			while (index < binaryIndexedTree.length) {
				binaryIndexedTree[index] += value;
				index = getNext(index);
			}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i : binaryIndexedTree) {
			sb.append(i).append(" ");
		}
		return sb.toString();
	}
}
