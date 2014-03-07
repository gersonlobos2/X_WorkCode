//  ****************************************************************************
//  Name: Gerson Lobos
//  Name: Professor Branca 
//  Date:
//  COMSC 110 Computer Programming II
//  Assignment #: 1
//  File Name: DiceCollection.h
//  Compiler Used: Xcode
//  ****************************************************************************

// Compiler directives : libraries and namespaces *****************************
#ifndef DiceCollection_H
#define DiceCollection_H
#include "Die.h"
#include <iostream>

using namespace std;
using namespace dieclass;

namespace CollectionClass
{
	class DiceCollection
	{
	public:
		DiceCollection(Die);
		
		void CollectDice(Die Obj, int increase);//it will add more dice to the collection.
		
		int getCollectionSize();
		
		Die  getDie(int);
		
		
		
		void RemoveFromCollection();
		
		
		void displayCollection();
		void merge2Collections(DiceCollection);
		
	private:
		Die *ArrayPtr;
		int ArraySize;

	};
}
#endif