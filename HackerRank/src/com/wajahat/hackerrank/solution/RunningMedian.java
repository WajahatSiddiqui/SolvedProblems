package com.wajahat.hackerrank.solution;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
        if (lowers.size() == 0 || number < lowers.peek()) {
            lowers.add(number);
        } else {
            uppers.add(number);
        }

    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > uppers.size() ? lowers : uppers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > uppers.size() ? uppers : lowers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
        if (lowers.size() == uppers.size()) {
            return ((double) lowers.peek() + uppers.peek())/2;
        }
        if (lowers.size() > uppers.size())
            return lowers.peek();
        else
            return uppers.peek();
    }

    private static double[] getMedian(int []array) {
        int N = array.length;
        // MAX_HEAP for lower numbers (below median)
        // Collections.reverseOrder gives us bigger first
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(N, Collections.reverseOrder());
        // MIN_HEAP for upper numbers (above median)
        // this gives smallest on the top
        PriorityQueue<Integer> uppers = new PriorityQueue<Integer>(N);
        double [] median = new double[N];
        for (int i = 0; i < N; i++) {
            int number = array[i];
            addNumber(number, lowers, uppers);
            rebalance(lowers, uppers);
            median[i] = getMedian(lowers, uppers);
        }
        return median;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int [] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            double [] median = getMedian(arr);
            for (double d : median) {
                System.out.printf("%.1f\n", d);
            }
        }
    }

}
