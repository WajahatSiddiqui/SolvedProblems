/* counting number of 1's in sorted array efficiently */
#include <iostream>
using namespace std;

/**
 * Count ones in A[low..high]
 * The array has to be in non increasing order
 **/
int countOnes(int A[], int low, int high) {
	int mid = (low + high)/2;
    // check if the element at middle index is last 1
    if ( (mid == high || A[mid+1] == 0) && (A[mid] == 1))
      return mid+1;
 
    // If element is not last 1, recur for right side
    if (A[mid] == 1)
      return countOnes(A, (mid + 1), high);
 
    // else recur for left side
    return countOnes(A, low, (mid -1));
}

/**
 * T(n) = O(logn)
 **/
int countEfficient(int A[], int size) {
	return countOnes(A, 0, size);
}

/**
 * T(n) = O(n)
 **/
int count(int A[], int size) {
	int counter = 0;
	for (int i = 0; i < size; i++)
		if (A[i] == 1) counter++;
	return counter;
}
int main() {
	int A[] = {1, 1, 1, 1, 1,1, 1, 1, 1, 1,1, 1, 1, 1, 1,1, 1, 1, 1, 1,1, 1, 1, 1, 1,0, 0, 0, 0};
	int size = sizeof(A)/sizeof(A[0]);
	cout<<"No. of 1's = "<<count(A, size)<<endl;
	cout<<"No. of 1's = "<<countEfficient(A, size)<<endl;
	return 0;
}