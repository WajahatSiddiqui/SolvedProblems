/**
 * Class Prints a matrix in ZigZag form
 * Created by wajahat
 */
public class printZigZag {

    private static void printZigZag(int [][] arr) {
        int i = 0;
        int N = arr.length;
        int M = arr[0].length;

        while (i < N) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            i++;
            if (i < N) {
                for (int j = M - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
                i++;
            }
        }
        System.out.println();

    }

    public static void main(String args[]) {
        int [][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int [][] arr1 = {{1, 2, 3, 4, 5},
                {5, 6, 7, 8, 9},
                {9, 10, 11, 12, 12}};

        int [][] arr2 = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15},};

        printZigZag(arr);
        printZigZag(arr1);
        printZigZag(arr2);
    }
}
