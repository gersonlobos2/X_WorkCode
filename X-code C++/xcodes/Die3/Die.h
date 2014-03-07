
//  ****************************************************************************
//  Name: Gerson Lobos
//  Name: Professor Branca 
//  Date:
//  COMSC 110 Computer Programming II
//  Assignment #: 1
//  File Name: Die.h
//  Compiler Used: Xcode
//  ****************************************************************************

// Compiler directives : libraries and namespaces *****************************

#ifndef Die_H
#define Die_H
#include <string>
#include <iostream>
#include <fstream>

using namespace std;
namespace dieclass
{
	class Die
	{
	public:
		Die();
		Die(int,string);
		~Die();
		void setsides(int);
		void setfaceValue(int);
		void setcolor(string);
		
		int getsides();
		int getfaceValue();
		string getcolor();
		void programDescription();
		
		//Die operator =(Die);
		int operator + (Die x);//this is not right
		int operator +=(Die y);
		
	private:
		int sides;
		int faceValue;
		string color;
		int dcounter;
		int dcounter2;
		
	};
	ostream& operator <<(ostream& out, Die& G);
	//int operator +(const Die& x,const Die& y);
	
}
#endif
