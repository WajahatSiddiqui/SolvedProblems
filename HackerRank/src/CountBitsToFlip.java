import java.util.Scanner;


public class CountBitsToFlip {
	
	private static int countSetBits(int n) {
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.println(countSetBits(A ^ B));
		}
	}

}
