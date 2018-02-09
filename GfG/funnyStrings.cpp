#include <string>
#include <iostream>
using namespace std;

string reverse(const string& str) {
    int len = str.length() - 1;
    string revstr = "";
    for (int i = len; i >= 0; i--) revstr += str[i];
    return revstr;
}

int main() {
	string str = "hello";
	string revstr = reverse(str);
	cout<<"Reverse of "<<str<<" is "<<revstr<<endl;
	return 0;
}