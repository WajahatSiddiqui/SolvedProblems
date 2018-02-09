#include <vector>
#include <iostream>
using namespace std;


int getSum(vector< vector<int> > kernel) {
	int sum = 0;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (i == 1 && j == 0 || i == 1 && j == 2) continue;
			sum = sum + kernel[i][j];
		}
	}
	return sum;
}

int getMaxSum(vector<int> maxA) {
	int max = maxA[0]
	for (int i = 1; i < max.size(); i++) {
		if (maxA[i] > max) max = maxA[i];
	}
	return max;
}

void findMaxSum(vector< vector<int> > A) {
	vector<int> maxA; // store max sums
}

int main(){
    vector< vector<int> > arr(6,vector<int>(6));
    for(int arr_i = 0;arr_i < 6;arr_i++){
       for(int arr_j = 0;arr_j < 6;arr_j++){
          cin >> arr[arr_i][arr_j];
       }
    }
       vector< vector<int> > arr1(3,vector<int>(3));
     for(int arr_i = 0;arr_i < 3;arr_i++){
       for(int arr_j = 0;arr_j < 3;arr_j++){
          arr1[arr_i][arr_j] = 1;
       }
    }  
    cout<<getSum(arr1)<<endl;
    return 0;
}
