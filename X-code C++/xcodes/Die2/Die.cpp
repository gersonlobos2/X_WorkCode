/*
 *  Die.cpp
 *  Die2
 *
 *  Created by Gerson Lobos on 9/21/10.
 *  Copyright 2010 westchester comunity college. All rights reserved.
 *
 */
#include <iostream>
#include "Die.h"
#include <ctime>
#include <string>
#include <fstream>


using namespace std;

namespace dieclass 
{
	Die::Die()
	{
		srand(time(0));
		sides=6;
		faceValue=1+rand()%(6);
		color="red";
	}
	Die::Die(int _sides,string _color)
	{
		srand(time(0));

		sides = _sides;
		color = _color;
		faceValue = 1+rand()%(_sides);
	}
	Die::~Die()
	{
	}
	void Die::setsides(int _sides)
	{
		sides= _sides;
	}
	void Die::setcolor(string _color)
	{
		color=_color;
	}
	void Die::setfaceValueROLL(int roll)
	{
		srand(time(0));
		//faceValue= 1+rand()%(this->getsides());
		faceValue= 1+rand()%(roll);
		
	}
	int Die::getsides()
	{
		return sides;
	}
	string Die::getcolor()
	{
		return color;
	}
	int Die::getfaceValueROLL()
	{
		return faceValue;
	}
	ostream& operator <<(ostream& out, Die& G)
	{
		//pre: an objet die has to be passed
		//post: an output is going to be returned.
		out<<"************************************"<<endl;
		out<<"die color is: "<<G.getcolor()<<endl;
		out<<"the die face value is: "<< G.getfaceValueROLL()<<endl;
		out<<"the die sides are: "<<G.getsides()<<endl;
		
		return out;
		
	}
}
