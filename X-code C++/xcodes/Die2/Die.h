/*
 *  Die.h
 *  Die2
 *
 *  Created by Gerson Lobos on 9/21/10.
 *  Copyright 2010 westchester comunity college. All rights reserved.
 *
 */

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
		Die(int _sides,string _color);
		~Die();
		void setsides(int);
		void setcolor(string);
		void setfaceValueROLL(int);
		int getsides();
		string getcolor();
		int getfaceValueROLL();
		
		
	private:
		int sides;
		int faceValue;
		string color;
		
		
	};
	ostream& operator <<(ostream& out, Die& G);

}
#endif 