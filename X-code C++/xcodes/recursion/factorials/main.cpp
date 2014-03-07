#include <iostream>
using namespace std;
int factorial(int n);
int main () 
{
	int num;
	cout << "what factorial number would you like to find: "<<endl;
	cin>>num;
	cout<<"the factorial of "<<num<<" is: "<<factorial(num);
	
	
	
    cin.ignore().get();
    return EXIT_SUCCESS;
}
int factorial(int n)
{
	if (n==1)
	{
		return 1;
	}
	else {
		return n*factorial(n-1);
	}


}