package com.wajahat.solution;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinAvgWaitingTime {
	
	private static class Order implements Comparable<Order> {
		long orderTime;
		Long cookTime;
		public Order(long orderTime, long cookTime) {
			this.orderTime = orderTime;
			this.cookTime = Long.valueOf(cookTime);
		}
		@Override
		public int compareTo(Order order) {
			return cookTime.compareTo(order.cookTime);
		}
	}
	
	private static void addOrders(PriorityQueue<Order> pq, long []T, long []L, long N) {
		for (int i = 0; i < N; i++) {
			pq.add(new Order(T[i], L[i]));
		}
	}
	
	private static long processOrder(long currentTime, Order order) {
		return (currentTime + order.cookTime) - order.orderTime;
	}
	
	private static long findMinAvgWaitingTime(long [] T, long [] L, int N) {
		PriorityQueue<Order> pq = new PriorityQueue<Order>(N);
		addOrders(pq, T, L, N);
		long currentTime = 0, waitingTime = 0;
		while (pq.size() != 0) {
			Order order = pq.poll();
			if (currentTime < order.orderTime) {
				currentTime += (order.orderTime-currentTime);
			}
			waitingTime += processOrder(currentTime, order);
			currentTime += order.cookTime;
		}
		return waitingTime/N;
	}
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			long []T = new long[N];
			long []L = new long[N];
			
			for (int i = 0; i < N; i++) {
				T[i] = scanner.nextLong();
				L[i] = scanner.nextLong();
			}
			System.out.println(findMinAvgWaitingTime(T, L, N));
 		}
	}

}
