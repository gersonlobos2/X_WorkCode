//  ****************************************************************************
// Name:Paul Velasco
//  Date:9/20/2010
//  Data Structures
//  Assignment #:Review Lab 
//  File Name:Review Lab 
//  Compiler Used:Dev C++
//  ****************************************************************************

#include "Imp.h"
#include <iostream>
#include<cstdlib>
#include <ctime>
using namespace std;


Die::Die()
{
	srand(time(0));
	color = "blue";
	facevalue = 1 + rand()%(6);
	sides = 6;          
}
//pre:
//post:it is setting the default constructor 

Die::Die(int _sides,string _color )
{ 
	srand(time(0));
	sides = _sides;
	color = _color;       
	facevalue =  1 + rand()%(_sides);              
}  
//pre:
//post:                     
Die::~Die()
{                             
}
//pre:
//post:        
int Die:: getsides()const
{
	return sides;            
	
}
//pre:
//post:   
string Die:: getcolor()const
{
	return color;
}
//pre:
//post:      
int Die:: getfacevalue()
{
	return facevalue;
}
//pre:
//post:   
void Die::setcolor(string a )
{
	color = a;
}
//pre:
//post:    
void Die::setsides(int x)
{
	sides = x;
}
//pre:
//post:    
void Die::roll(Die m)
{
	srand(time(0));
	facevalue = rand()% m.getsides()+1;
}
//pre:
//post: 
int Die:: operator+=(Die p)
{
	scounter+=p.getfacevalue();
	return scounter;
}
//pre:
//post: 
ostream& operator <<(ostream& out, Die& H)
{
	out<<"$$$$$$$$$$$$$$$$$$$$$$$$$"<<endl;
	out<<"the die color is: "<< H.getcolor() <<endl;
	out<<"the sides of the die is: "<< H.getsides()<<endl;
	out<<"the face of the die is:"<< H.getfacevalue()<<endl;
	out<<"$$$$$$$$$$$$$$$$$$$$$$$$$"<<endl;
	
	return out;
}
//pre:
//post: 





