#include <iostream>
using namespace std;

int findDecent(int n) {
  if (n == 1) return -1;
  
  return -1;
}

int main(){
    int t;
    cin >> t;
    for(int a0 = 0; a0 < t; a0++){
        int n;
        cin >> n;
        cout<<findDecent(n)<<endl;
    }
    return 0;
}
