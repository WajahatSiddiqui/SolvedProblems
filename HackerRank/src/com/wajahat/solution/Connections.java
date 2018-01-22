package com.wajahat.solution;

import java.util.Scanner;


public class Connections {
    private int[] parent;   // parent[i] = parent of i
    private int[] size;     // size[i] = number of sites in subtree rooted at i

    /**
     * Initializes an empty union–find data structure with {@code n} sites
     * {@code 0} through {@code n-1}. Each site is initially in its own 
     * component.
     *
     * @param  n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public Connections(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Returns the component identifier for the component containing site {@code p}.
     *
     * @param  p the integer representing one object
     * @return the component identifier for the component containing site {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        validate(p);
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));  
        }
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Merges the component containing site {@code p} with the 
     * the component containing site {@code q}.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p, int q) {
    	if (connected(p, q)) return;
    	
        int rootP = find(p);
        int rootQ = find(q);

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
    
	public int count(int q) {
		return size[find(q)];
	}
	
	public void printArray() {
		for (int i = 1; i < parent.length; i++) {
			System.out.print(parent[i] + " ");
		}
		System.out.println();
		for (int i = 1; i < size.length; i++) {
			System.out.print(size[i] + " ");
		}
	}
	
	public static void main(String args[]) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			Connections con = new Connections(N);
			int Q = sc.nextInt();
			sc.nextLine();
			while (Q > 0) {
				String line = sc.nextLine();
				String [] tokens = line.split(" ");
				if (tokens[0].equals("Q")) {
					System.out.println(con.count(Integer.parseInt(tokens[1])));
				} else if (tokens[0].equals("M")) {
					con.union(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
				}
				Q--;
			}
			con.printArray();
		}
	}
}

