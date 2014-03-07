/*
 *  DiceCollection.h
 *  Die2
 *
 *  Created by Gerson Lobos on 9/22/10.
 *  Copyright 2010 westchester comunity college. All rights reserved.
 *
 */

#ifndef DiceCollection_H
#define DiceCollection_H
#include "Die.h"
#include <string>

#include <iostream>


using namespace std;
using namespace dieclass;
namespace DicecollectionClass
{
	class DiceCollection : public Die
	{
	public:
		DiceCollection();
		
		DiceCollection(int,string, int);
		DiceCollection(int);
		
		
		~DiceCollection();
		
		int getControlsize();
		
		void addDice();
		
		
		void addDie(Die);
		
		void displayCollection();
		


	private:
		Die *pointDieArray;
		//Die *pointDieArray2;
		
		int arraySize;
		
		
	};
	
	
}
#endif