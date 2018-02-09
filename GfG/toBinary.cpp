#include <iostream>
#include <algorithm>
using namespace std;

void toBinary(unsigned long long n) {
	int A[100];
    int binary = 0, size = 0;
    while (n) {
    	A[size++] = n % 2;
    	n = n / 2;
    }
    for (int i = size-1; i >=0 ; i--) cout<<A[i];
    cout<<endl;
    
}
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int t = 1;
    unsigned long long n = 2147483648;
    while (t--) {
        //cin>>n;
		toBinary(n);
    }
    return 0;
}
