import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class SpecialStack {
	Stack<Integer> smin = new Stack<>();
	public void push(Stack<Integer> s, int a) {
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
	
	public int min() {
		return smin.peek();
	}

	@Test
	public void test() {
		SpecialStack ss = new SpecialStack();
		Stack<Integer> s = new Stack<>();
		ss.push(s,5);
		ss.push(s,4);
		ss.push(s,3);
		ss.push(s,2);
		ss.push(s,1);
		ss.push(s,3);

		assertEquals(1, ss.min());
		assertEquals(3, ss.pop(s));
		assertEquals(1, ss.min());
		assertEquals(1, ss.pop(s));
		assertEquals(2, ss.min());
	}
}
