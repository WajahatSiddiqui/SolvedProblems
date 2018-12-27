/**
 * Class Print a matrix in spiral form
 * Created by wajahat
 */
public class PrintSpiral {

    private static void printSpiral(int [][] arr) {
        int M = arr.length; // row
        int N = arr[0].length; // col

        int k = 0; // runner for row
        int l = 0; // runner for col
        int i = 0; // counter

        while (k < M && l < N) {
            // print first row
            for (i = l; i < N; i++) {
                System.out.print(arr[k][i] + " ");
            }
            k++;

            // print last col
            for (i = k; i < M; i++) {
                System.out.print(arr[i][N-1] + " ");
            }
            N--;

            if (k < M) {
                // print last row
                for (i = N-1; i >= l; i--) {
                    System.out.print(arr[M-1][i] + " ");
                }
                M--;
            }

            if (l < N) {
                // print first col
                for (i = M-1; i >= k; i--) {
                    System.out.print(arr[i][l] + " ");
                }
                l++;
            }
        }

    }

    public static void main(String args[]) {
        int [][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        printSpiral(arr);
    }
}
