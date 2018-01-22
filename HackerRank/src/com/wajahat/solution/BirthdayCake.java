package com.wajahat.solution;

import java.util.Scanner;

public class BirthdayCake {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int number, count = 0;
        int max = 0;
        for(int ar_i = 0; ar_i < n; ar_i++){
            number = in.nextInt();
            if (max < number) {
            	count = 1;
            	max = number;
            } else if (max == number) {
            	count++;
            }
        }
        System.out.println(count);
        in.close();
    }

}
