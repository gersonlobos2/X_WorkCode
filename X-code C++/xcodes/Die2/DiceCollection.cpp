/*
 *  DiceCollection.cpp
 *  Die2
 *
 *  Created by Gerson Lobos on 9/22/10.
 *  Copyright 2010 westchester comunity college. All rights reserved.
 *
 */

#include "DiceCollection.h"
#include "Die.h"
#include <string>

using namespace dieclass;
using namespace std;

namespace DicecollectionClass
{

	DiceCollection::DiceCollection()
	{
		
		arraySize = 5;
		pointDieArray = new Die[arraySize];
		Die dado;
		for (int c=0; c<arraySize; ++c) {
			pointDieArray[c] = dado;
		}
		
		
		
		
	}
	DiceCollection::DiceCollection(int Csize,string color,int dsides)
	{
		//pre: an integer of of the number of objects in the collection has to be passed. 
		//post: it will store the size and it will create a pointer to an array
		arraySize = Csize;
		
		pointDieArray = new Die[Csize];
		
		
		for (int x=0; x < Csize; ++x) 
		{
			pointDieArray[x]= *(new Die(dsides,color));   //Check this out. Ask what is it posible
			
		}
		
		
		
	}
/*	DiceCollection::DiceCollection(int _size)//***********************************************
	{
		
		
	
	
	}*/  //*******************************************************
	DiceCollection::~DiceCollection()
	{
		delete [] pointDieArray;
	}
	int DiceCollection::getControlsize()
	{
	return arraySize;
	}
	void DiceCollection::addDie(Die x)
	{
		//tempPtr=arraySize;
		
		
	}
	
	
	void DiceCollection::displayCollection()
	{
		//Die *tempPtr[arraySize];
		
		for (int x=0; x< this->getControlsize();++x) 
		{
		  cout <<pointDieArray[x]<<endl;
	     }
	
	}
	



}