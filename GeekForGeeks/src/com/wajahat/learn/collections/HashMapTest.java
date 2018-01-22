package com.wajahat.learn.collections;

import java.util.HashMap;
import java.util.Scanner;

/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/

/*You are required to complete below methods */
class HashMapTest {
	/*Inserts an entry with key x and value y in map */
	void add_Value(HashMap<Integer,Integer> hm, int x, int y) {
		hm.put(x,  y);
	}

	/*Returns the value with key x from the map */
	int find_value(HashMap<Integer, Integer> hm, int x)	{
		return hm.containsKey(x) ? hm.get(x) : -1;
	}

	/*Returns the size of the map */
	int getSize(HashMap<Integer, Integer> hm) {
		return hm.size();
	}

	/*Removes the entry with key x from the map */	
	void removeKey(HashMap<Integer, Integer> hm, int x)	{
		if (hm.containsKey(x)) {
			hm.remove(x);
		}
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		HashMapTest test = new HashMapTest();
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int Q;
		char cmd;
		int key, value;
		while (T > 0) {
			Q = scanner.nextInt();

			while (Q > 0) {
				cmd = scanner.next().toCharArray()[0];

				switch(cmd) {
				case 'a':
					key = scanner.nextInt();
					value = scanner.nextInt();
					test.add_Value(hashMap, key, value);
					break;
				case 'b':
					key = scanner.nextInt();
					System.out.println(test.find_value(hashMap, key));
					break;
				case 'c':
					System.out.println(test.getSize(hashMap));
					break;
				case 'd':
					key = scanner.nextInt();
					test.removeKey(hashMap, key);
					break;
				default:
					break;
				}
				Q--;
			}
			hashMap.clear();
			T--;
		}
		scanner.close();
	}
}