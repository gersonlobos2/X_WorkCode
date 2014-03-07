//  ****************************************************************************
//  Name:Paul Velasco
//  Date:9/20/2010
//  Data Structures
//  Assignment #:Review Lab 
//  File Name:Review Lab 
//  Compiler Used:Dev C++
//  ****************************************************************************

#ifndef Imp_h
#define Imp_h
#include <iostream>
#include<cstdlib>
#include <string>
using namespace std;

class Die 
{
public:
	//Memember fuctions
	Die();
	Die(int,string);
	~Die();
	int getsides()const;
	string getcolor()const;
	int getfacevalue();
	void setcolor(string);
	void setsides(int);
	void roll(Die);
	int operator+=(Die p);
	
private:
	string color;
	int facevalue;
	int sides;
	int scounter;     
	
};  
ostream& operator <<(ostream& out, Die& H);     

#endif












