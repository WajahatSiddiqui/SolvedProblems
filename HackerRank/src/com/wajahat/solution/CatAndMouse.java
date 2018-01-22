import java.util.Scanner;

public class CatAndMouse {
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int q = sc.nextInt();
			while (q > 0) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();
				
				int catA = Math.abs(x-z);
				int catB = Math.abs(y-z);
				
				if (catA == catB) {
					System.out.println("Mouse C");
				} else if (catA > catB) {
					System.out.println("Cat B");
				} else {
					System.out.println("Cat A");
				}
				q--;
			}
		}
	}

}
