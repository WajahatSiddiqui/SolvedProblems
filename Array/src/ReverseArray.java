import java.util.Scanner;

/**
 * Class Reverse an Array
 * Created by wajahat
 */
public class ReverseArray {

    private static void reverse(int []arr) {
        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        int N;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            reverse(arr);
        }
    }
}
