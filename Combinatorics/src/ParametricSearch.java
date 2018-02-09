import java.util.Scanner;


// Parametric search transforms decision algorithms into an optimization problem.
// It first sets an unknown random optimal solution value as its input and then
// simulates the decision algorithms recursively until it reaches the optimal solution

// Problem: You have given K ribbons of various length. To use them as crafting material, 
// you need N ribbons with each of same length. There is a need to trim down K ribbons into
// equal size N ribbons of same length. Your program must determine the length of each N ribbons
// K <= N

// 4 K
// 11 N
// 802
// 743
// 457
// 539

public class ParametricSearch {
	
	private static int findOptimalLength(int []ribbons, int N, int K, int maxRibbon) {
		
		int lo = 1;
		int hi = maxRibbon;
		int max = -1; // optimal max length
		int nR = 0; // no. of ribbons possible;
		int mid = 0;
		while (lo <= hi) {
			mid = lo + (hi - lo)/2;
			nR = 0;
			
			for(int i = 0; i < K; i++) {
				nR += (ribbons[i]/mid);
			}
			
			if (nR >= N) {
				lo = mid + 1;
				if (mid > max) {
					max = mid;
				}
			} else {
				hi = mid - 1;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int K = sc.nextInt();
			int N = sc.nextInt();
			
			int [] ribbons = new int[K];
			int maxRibbon = 0;
			for (int i = 0; i < K; i++) {
				ribbons[i] = sc.nextInt();
				if (ribbons[i] > maxRibbon) {
					maxRibbon = ribbons[i];
				}
			}
			
			System.out.println(findOptimalLength(ribbons, N, K, maxRibbon));
		}
	}

}
