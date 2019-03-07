import java.util.Scanner;

/**
 * KeprekarNumbers
 *
 * @author wajahat
 */
public class KeprekarNumbers {

    static boolean isKaprekar(long num) {
        if (num == 1) return true;
        String snum = String.valueOf(num);
        int d1 = snum.length();
        long square = num*num;
        String sq = String.valueOf(square);
        int d2 = sq.length();
        if (d2 == 1) return false;
        int num1, num2;
        if (d2 == 2*d1) {
            num1 = Integer.valueOf(sq.substring(0, d1));
            num2 = Integer.valueOf(sq.substring(d1, d2));
        } else {
            num1 = Integer.valueOf(sq.substring(0, d1-1));
            num2 = Integer.valueOf(sq.substring(d2-d1));
        }

        return num == (num1 + num2);
    }

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        boolean kaprekar = false;
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                System.out.print(i + " ");
                if (!kaprekar) kaprekar = true;
            }
        }
        if (!kaprekar) {
            System.out.print("INVALID RANGE");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
