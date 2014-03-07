#include <iostream>


using namespace std;


int fibonacci(int ,int,int);
int fib(int);
int main () 
{
	
	int num1=0;
	int num2=1;
	int counter;
	
	cout << "what fibionacci sequense would you like to find: "<<endl;
	cin>>counter;
	
	cout<<"the fibinocci numver is:"<<fibonacci(num1,num2,counter-2)<<endl;
	
	
	cout << "what fibionacci sequense would you like to find: "<<endl;
	cin>>counter;
	
	for (int i=0; i<counter; ++i) {
		cout << fib(i)<<" ";
	}
	
	
	cin.ignore().get();
    return EXIT_SUCCESS;
}

int fibonacci(int num1,int num2,int counter)
{
	int temp;
	if (counter==0) {
		return num2;
	}
	else {
		temp = num2;
		num2 = num1 + num2;
		num1 = temp;
		--counter;
		num2=fibonacci(num1,num2,counter);
	}
	return num2;
}

int fib(int n)
{
	if(n==0)
		return 0;
	if (n==1) 
		return 1;
	
	return fib(n-1) + fib(n-2);
	
}
