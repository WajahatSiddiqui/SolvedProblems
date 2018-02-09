/*

Find four elements a, b, c and d in an array such that a+b = c+d

Given an array of distinct integers, find if there are two pairs (a, b) and (c, d) such that a+b = c+d, and a, b, c and d are distinct elements. If there are multiple answers, then print any of them.

Example:

Input:   {3, 4, 7, 1, 2, 9, 8}
Output:  (3, 8) and (4, 7)
Explanation: 3+8 = 4+7

Input:   {3, 4, 7, 1, 12, 9};
Output:  (4, 12) and (7, 9)
Explanation: 4+12 = 7+9

Input:  {65, 30, 7, 90, 1, 9, 8};
Output:  No pairs found

Expected Time Complexity: O(n2)
*/

#include <iostream>
#include <map>
using namespace std;

void findPair(int A[], int size) {
	map<int , pair<int, int> > hash;
	int sum = 0;
	for (int i = 0; i < size; i++) {
		for (int j = i+1; j < size; j++) {
			sum = A[i] + A[j];
			// sum is not present in the hash
			// sum as key and value as its pair
			if (hash.find(sum) == hash.end())
				hash[sum] = make_pair(A[i], A[j]);
			else { // sum is found in the hash
				pair<int, int> p = hash[sum]; // prev sum
				cout<<"("<<A[i]<<", "<<A[j]<<"), ("
					<<p.first<<", "<<p.second<<")"<<endl;
	1aefs[]		}
		}
	}
}

int main() {
	int A[] = {3, 4, 7, 1, 2, 9, 8};
	int size = sizeof(A)/sizeof(A[0]);

	findPair(A, size);
	return 0;
}