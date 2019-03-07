package com.wajahat.unionfind;

/**
 * Weighted Union Find
 * @author wajahat
 */
class WeightedUnionFind {
    private int [] id; // ids
    private int [] sz; // weights
    /**
     * Initialize
     * T(n) = O(n)
     */
    public WeightedUnionFind(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * Check if p and q has the same root
     * T(n) = O(n)
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * Chase the pointers inside the array
     * untill we reach to the root
     * Use Path Compression and assign to the same root
     * T(n) = O(n)
     */
    public int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    /**
     * Get the roots of p and q
     * Add q to p 
     * T(n) = O(n) (Includes the cost of finding roots)
     */
    public void union(int p, int q) {
        if (connected(p, q)) return;

        int i = root(p);
        int j = root(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
    
    /**
     * Count nodes in the component
     * @param p - pid
     * @return the count of all nodes in the same component 
     */
    public int count(int p) {
        return sz[root(p)];
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ids[");
        for (int i : id) {
            sb.append(i).append(" ");
        }
        sb.append("]");
        sb.append("\nsz[");
        for (int i : sz) {
            sb.append(i).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}