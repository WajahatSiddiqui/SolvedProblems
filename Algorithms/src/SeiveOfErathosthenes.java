import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeiveOfErathosthenes {

	private static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

	/**
	 * T(n) = O(n^2)
	 * @param n - generate till the n
	 * @return List of prime numbers
	 */
	private static List<Integer> generatePrime(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				list.add(i);
			}
		}
		return list;
	}

	private static boolean isPrimeImprove(int n) {
		for (int i = 2; i*i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}


	/**
	 * T(n) = O(sqrt(n))
	 * @param n - generate till the n
	 * @return List of prime numbers
	 */
	private static List<Integer> generatePrimeImprove(int n) {
		List<Integer> list = new ArrayList<>();
		if (n >= 2) {
			list.add(2);
		}
		for (int i = 3; i <= n; i+=2) {
			if (isPrime(i)) {
				list.add(i);
			}
		}
		return list;
	}

	/**
	 * T(n) = O(nlogn)
	 * @param n - generate till the n
	 * @return List of prime numbers
	 */
	private static List<Integer> seiveOfErathosthenes(int n) {
		boolean prime[] = new boolean[n + 1];
		Arrays.fill(prime, true);
		
		for (int p = 2; p*p <= n; p++) {
			if (prime[p]) {
				for (int i = p*2; i <= n; i+=p) {
					prime[i] = false;
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (prime[i]) {
				list.add(i);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		/*List<Integer> primes = seiveOfErathosthenes(40);
		primes.forEach(n->{System.out.print(n + " ");});*/

		//generatePrime(10).forEach(System.out::println);
		generatePrimeImprove(100).forEach(System.out::println);
	}
}
