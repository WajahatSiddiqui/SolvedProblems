import java.util.Scanner;

public class BeautifulMovies {
	
	static int reversed(int n) {
		int rem  = 0, rev = 0;
		while (n != 0) {
			rem = n % 10;
			rev = (rev * 10) + rem;
			n /= 10;
		}
		return rev;
	}
	
	static int findBeautifulDays(int i, int j, int k) {
		int count = 0;
		for (int a = i; a <= j; a++) {
			if (Math.abs(a - reversed(a)) % k == 0) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			
			System.out.println(findBeautifulDays(i, j, k));
		}
	}
}
