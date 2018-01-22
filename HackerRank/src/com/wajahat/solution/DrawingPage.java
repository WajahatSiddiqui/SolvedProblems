import java.util.Scanner;

public class DrawingPage {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			
			int pages = -1;
			
			int start = p % 2 == 0 ? 0 : 1;
			int i;
			if (p <= n/2) {
				for (i = start; i <= p; i += 2) pages++;
			} else {				
				for (i = (p%2 == 0) ? n : n+1; i >= p; i -= 2) {
					pages++;
					if (i == p) {
						break;
					}
				}
			}
			System.out.println(pages);
			
		}

	}
}
