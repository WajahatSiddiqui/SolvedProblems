
import java.util.Scanner;

public class PalidromeReduce {
	
	private static int countReduce(String str) {
		int n = str.length();
		int sum = 0;
		char [] c = str.toCharArray();
		for (int i = 0; i < n/2; i++) {
			sum += Math.abs(c[i] - c[n-i-1]);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		System.out.println(countReduce(str));
		scanner.close();
	}
}
