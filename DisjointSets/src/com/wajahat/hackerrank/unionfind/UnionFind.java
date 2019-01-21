package com.wajahat.hackerrank.unionfind;

public class UnionFind {
	int [] id;

	/**
	 * Initialize
	 * T(n) = O(n)
	 */
	public UnionFind(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
	}

	/**
	 * Check if p is connected with q
	 * T(n) = O(1)
	 */
	public boolean find(int p, int q) {
		return id[p] == id[q];
	}

	/**
	 * Get the ids of p and q
	 * Loop through the id and set q for all p
	 * T(n) = O(n)
	 */
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) id[i] = qid;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i : id) {
			sb.append(i).append(" ");
		}
		sb.append("]");
		return sb.toString();
	}
}
