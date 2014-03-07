#include <iostream>
#include <cmath>
using namespace std;

double DistanceFormula(int, int,int,int);

int main () {
	int x1;
	int x2;
	int y1;
	int y2;
	
	cout << "Please enter the location of your first two-dimentional point:  "<<endl;
	do{
	cout << "Enter a value from -99 to 99 for your x cordinate:";
	cin >>x1;
	}while(x1<-99||x1>99);
	
	do{
	cout << "Enter a value from -99 to 99 for your y cordinate:";
	cin >>y1;
	}while(y1<-99||y1>99);
	
	cout << "Please enter the location of your second two-dimentional point:  "<<endl;
	
	do{
	cout << "Enter a value from -99 to 99 for your x cordinate:";
	cin >>x2;
	}while(x2<-99||x2>99);
	
	do{
	cout << "Enter a value from -99 to 99 for your y cordinate:";
	cin >>y2;
		}while(y2<-99||y2>99);
	
	cout << "The length of the line segment from point one to point two is: "<<DistanceFormula(x1,x2,y1,y2)<<endl;
	
	
	system("pause");
    return 0;
}
double DistanceFormula(int x1, int x2,int y1,int y2)
{

	double result;
	
	result= sqrt(pow(x1-x2, 2.0)+pow(y1-y2, 2.0));

	return result;

}
