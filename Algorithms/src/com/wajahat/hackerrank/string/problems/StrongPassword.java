package com.wajahat.hackerrank.string.problems;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StrongPassword {

    private static String[] regex = {"^(?=.*[0-9])$", "^(?=.*[a-z])$", "^(?=.*[A-Z])$", "^(?=.*[!@#$%^&*()-+])$"};
    private static Pattern []pattern = new Pattern[regex.length];

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int i = 0;
        for (String r : regex) {
            pattern[i] = Pattern.compile(r);
            i++;
        }

        int count = 0;
        for (i = 0; i < pattern.length; i++) {
            if (!pattern[i].matcher(password).matches()) {
                count++;
            }
        }

        if (n < 6 && count < 6-n) {
            return 6 - n;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
