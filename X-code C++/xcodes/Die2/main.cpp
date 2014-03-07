#include <iostream>
#include "Die.h"
#include "DiceCollection.h"

using namespace dieclass;
using namespace DicecollectionClass;
using namespace std;
int main() 
{
	
	string dcolor;
	int dsides;
	int selc;
	int Csize;
	
	do
	{
		cout << "what color do you want the Dices to be:"<<endl;
		cout << "1. red" <<endl;
		cout << "2. blue" <<endl;
		cout << "3. yellow"<<endl ;
		cout << "Enter the number of color you want:"<<endl;
		cin >> selc;
		
		switch (selc) {
			case 1: {
				dcolor="red";
				break;
			}
			case 2: {
				dcolor="blue";
				break;
			}
			case 3: {
				dcolor="yellow";
				break;
			}
			default:{
				selc= -1;
				//cout<<"*******Invalid selection, please try again.*******"<<endl;
				break;
			}
		}
	}while(selc == -1);
	
	while (6>dsides||10<dsides) 
	{
		cout <<"how many sides do you want in the dice from 6-10: "<<endl;
		cin >>dsides;
	}
	
	cout << "how many dice you want to have in the collection: "<<endl;
	cin>>Csize;
	
	
	DiceCollection bag( Csize, dcolor, dsides);
	
	
	DiceCollection bag2(5, " Purple ", 6);
	
	cout<<"the number of dice in the first bag is: "<<bag.getControlsize()<<endl;
	
	cout<<"the number of dice in the second bag is: "<<bag2.getControlsize()<<endl;
	
	cout<<"the color of the first bag is: "<<bag.getcolor()<<endl;
	cout<<"the color of the second bag is:"<< bag2.getcolor()<<endl;
	
	cout << "the number of sides of the dice in 1st bag are:"<<bag.getsides()<<endl;
	
	cout << "the number of sides of the dice in 2nd bag are:"<<bag2.getsides()<<endl;
	
	bag.displayCollection();
	cout << endl;
	cout << "the dies in the second collection are: "<<endl;
	cout << endl;
	cout << endl;
	bag.displayCollection();
	
	
    cout << "please press enter one or twitce to continue...";
	cin.ignore().get();
	return EXIT_SUCCESS;
}
