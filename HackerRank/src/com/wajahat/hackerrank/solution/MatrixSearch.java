package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class MatrixSearch {

	// O(M + N)
	private static boolean search(int [][]mat,int N,int M,int key) {
		int i = 0, j = M-1;
		while (i >= 0 && i < N && j >= 0 && j < M) {
			if (key == mat[i][j]) {
				return true;
			} else if (key < mat[i][j]) {
				j--;
			} else if (key > mat[i][j]) {
				i++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		/*int [][]mat = {{-10, 0, 10},
					   {20, 30, 70}};
		int N = 2;
		int M = 3;*/

		try (Scanner scanner = new Scanner(System.in)) {
			int T = scanner.nextInt();
			int N, M;
			while (T > 0) {
				N = scanner.nextInt();
				M = scanner.nextInt();
				int [][]mat = new int[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						mat[i][j] = scanner.nextInt();
					}
				}
				int key = scanner.nextInt();
				System.out.println(search(mat, N, M, key) ? "0" : "1");
				T--;
			}
		}
	}
}
