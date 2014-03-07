#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>
#include <fstream>
using namespace std;


using namespace std;
string functselect(string [],int );
int randomAcid();
double Price(int,int);

string checkIf();
int temprag();
int main ()
{
	srand(time(0));
	int num;
	 int length1=10;
	 int countries=5;
	
	//********************hops********************************
	string hops[]={"Amarillo","Cascade","Centennial","Crystal",
		"Goldings","Perle","Liberty","Spalt","Warrior","Tradition"};   
	
	string aroma[]={"Spicy","Floral","Tropical Fruit","Grapefruit",
		"Soft Herval","English","Mild","Earthy","Sweet","Spicy Floral"};
	
	string country[] = {"USA", "England", "Germany", "Belgium", "Canada"};
	//*********************yeast***********************************
	string yeast[]={"California Ale","English Ale","Irish Stout","British Ale",
		"Dry English Ale","European Ale","London Ale","German Ale","Pasific Ale",
		"Belgian Ale"};
	string flocculation[]={"Low","Medium","High"};
	int floc=3;
	
	//************************************************************
	cout << "how many items do you want to create:"<<endl;
	cin>>num;
	
	ofstream outFile;
	outFile.open("HopsData.txt");
	//it saves it in this order.
	//name,acid,aroma,for bittering,country from,1oz price,8oz price
	for (int i=0; i<num; ++i) {
		outFile<<i+1<<",";
		outFile<<functselect(hops,length1)<<",";
		outFile<<randomAcid()<<",";
		outFile<<functselect(aroma, length1)<<",";
		outFile<<checkIf()<<",";
		outFile<<functselect(country,countries)<<",";
		outFile<<Price(0,1)<<",";
		outFile<<Price(6,11)<<"\n";
		
	}
	outFile.close();
	cout << "file \"HopsData.txt\" was created ad xcodes/database"<<endl;
	
	
	ofstream outFile2;
	outFile2.open("YeastData.txt");
	
	cout << "how many items of yeast would you like to create:"<<endl;
	cin>>num;
	//#,name,tamp-rag,alternation,flocculation,price
	for (int i=0; i<num; ++i) {
		outFile2<<i+1<<",";
		outFile2<<functselect(yeast,length1)<<",";
		outFile2<<temprag()<<",";
		outFile2<<temprag()<<",";
		outFile2<<functselect(flocculation,floc)<<",";
		outFile2<<Price(6,10)<<"\n";
	}
	outFile2.close();
	cout << "file \"YeastData.txt\" was created ad xcodes/database"<<endl;
	
	
	cin.ignore().get();
	return EXIT_SUCCESS;
}
string functselect(string array[],int tempo)
{
	int temp= rand()% (tempo);
	

	return array[temp];
}
int randomAcid()
{
	return 3+rand()%(15-3+1);

}
double Price(int min,int max)
{
	return min+rand()%(max-min+1)+0.99;
	
}

string checkIf()
{
	string yes="yes";
	string no="no";
	int check=1+rand()%(2-1+1);
	if (check==1) {
		return yes;
	}
	else if(check==2)
	{
		return no;
	}
	else {
		return yes;
	}

	
}
//functions for yeast
int temprag()
{
	return 65+rand()%(78-65+1);
}
