//  ****************************************************************************
//  Name:Gerson Lobos
//  Date:
//  COMSC 110 Computer Programming II
//  Assignment #: 1
//  File Name:Die.cpp
//  Compiler Used: Xcode
//  ****************************************************************************

#include "Die.h"

#include <iostream>
#include <string>
#include <ctime>
#include <cstdlib>
#include <fstream>
#include <cmath>
using namespace std;

namespace dieclass
{
	
	Die::Die()
	{
		//pre: none
		//post: it will create a die
		srand(time(0));
		
		sides=6;
		faceValue=1+rand()%(6-1+1);
		color="red";
	}
	Die::Die(int a,string b)
	{
		//pre: two int and a string has to be passed
		//post: it will set the values for the die
		sides=a;
		color=b;
		faceValue=1+rand()%(a);;
	}
	Die::~Die()
	{
	}
	
	void Die::setsides(int _sides)
	{
		//pre: an int has to be passed
		//post: it will set the sides of the die equal to the int that was passed
		sides = _sides;
	}
	void Die::setfaceValue(int _faceValue)
	{
		//pre: an int is passed
		//post: it will create a random numberfrom the int passed
		srand(time(0));
		faceValue = 1 + rand()%(_faceValue-1+1);
	}
	void Die::setcolor(string _color)
	{
		//pre: a string is passed
		//post: it will set the color
		color = _color;
	}
	int Die::getsides()
	{
		//pre: none
		//post: it will return an int
		return sides;
	}
	int Die::getfaceValue()
	{
		//pre: none
		//post:it will return an int
		return faceValue;
	}
	string Die::getcolor()
	{
		//pre: none
		//post:it will return a string
		return color;
	}
	
	int Die::operator+(Die x)
	{
		//pre: a die has to be passed
		//post: an int is going to be return 
		int temp= 0;
		temp = dcounter;
		dcounter= temp + x.getfaceValue();
		return dcounter;
	}
	int Die::operator +=(Die y)
	{
		
		//pre: a die object has to be passed
		//post: it will add one more object
		dcounter+= y.getfaceValue();
		return dcounter2;
	}
	
	ostream& operator <<(ostream& out, Die& G)
	{
		//pre: an objet die has to be passed
		//post: an output is going to be returned.
		out<<"************************************"<<endl;
		out<<"die color is: "<<G.getcolor()<<endl;
		out<<"the die face value is: "<< G.getfaceValue()<<endl;
		out<<"the number of sides in the dice is: "<<G.getsides()<<endl;
		out<<"************************************"<<endl;
		return out;
		
	}
	void Die::programDescription()
	{
		//pre:  none
		//post: it will return a display. 
		cout << " This program will create dice with the color and sides as you want."<<endl; 
		cout<<"and it will roll them and add all the results. then it will display them."<<endl;
	}
	/* int Die::operator +(const Die& x,const Die& y)
	 {
	 int temp =0;
	 temp = x.getfaceValue() + y.getfaceValue();
	 return temp;
	 
	 }*/
	
}

