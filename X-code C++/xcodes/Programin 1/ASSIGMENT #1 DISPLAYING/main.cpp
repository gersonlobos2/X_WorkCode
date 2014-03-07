#include <iostream>
using namespace std;

int main () {

	char suit;
	int faceValue; 
	
	cout << "please enter the first character of a playing card's suit: "<<endl;
	cin >> suit;
	
	cout << "please enter the numeric face value of a playing card: "<<endl;
	cin>>faceValue;
	
	cout << "You entered "<< faceValue<<suit<<" thank you. "<<endl;
	
	
	
	system("PAUSE");
    return 0;
}
