import java.util.Scanner;
import java.util.Stack;

public class SpecialStack {
	Stack<Integer> smin = new Stack<>();
	public void push(int a, Stack<Integer> s) {
		s.push(a);
		if (smin.isEmpty() || a < smin.peek()) {
			smin.push(a);
		}
	}
	
	public boolean isFull(Stack<Integer> s, int n) {
		return n == s.size();
	}
	
	public boolean isEmpty(Stack<Integer> s) {
		return s.isEmpty();
	}
	
	public int pop(Stack<Integer> s) {
		int p = s.pop();
		if (p == smin.peek()) {
			smin.pop();
		}
		return p;
	}
	
	public int min(Stack<Integer> s) {
		return smin.peek();
	}
	
	public static void main(String[] args) {
		SpecialStack ss = new SpecialStack();
		Scanner scanner = new Scanner(System.in);
		
		Stack<Integer> s = new Stack<>();
		
		int T = scanner.nextInt();
		int N = 0;
		while (T > 0) {
			N = scanner.nextInt();
			while (N > 0) {
				ss.push(scanner.nextInt(), s);
				N--;
			}
			System.out.println(ss.min(s));
			T--;
		}
		scanner.close();
	}
}
