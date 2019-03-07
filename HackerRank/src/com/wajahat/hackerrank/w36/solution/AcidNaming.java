package com.wajahat.hackerrank.w36.solution;

import java.util.Scanner;

public class AcidNaming {

    private static final String HYDRO = "hydro";
    private static final String IC = "ic";

    private static void acidNaming(String str) {
        if (str.startsWith(HYDRO) && str.endsWith(IC)) {
            System.out.println("non-metal acid");
        } else if (str.endsWith(IC)) {
            System.out.println("polyatomic acid");
        } else {
            System.out.println("not an acid");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int q = sc.nextInt();
            String str;
            while (q > 0) {
                str = sc.next();
                acidNaming(str);
                q--;
            }
        }
    }

}
