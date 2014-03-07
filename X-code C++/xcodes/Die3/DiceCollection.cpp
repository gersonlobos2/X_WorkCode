/*
 *  DiceCollection.cpp
 *  Die3
 *
 *  Created by Gerson Lobos on 9/24/10.
 *  Copyright 2010 westchester comunity college. All rights reserved.
 *
 */

#include "DiceCollection.h"
#include "Die.h"
#include <iostream>
#include <algorithm>

using namespace std;
using namespace dieclass;

namespace CollectionClass
{
	DiceCollection::DiceCollection(Die first)
	{
		//pre: it passes a die
		//post: it will create a bag of dice starting with one die
		ArraySize=1;
		Die *tempPtr;
		tempPtr = new Die[ArraySize];
		
		tempPtr[0]=first;
		ArrayPtr=tempPtr;
	
	}
	void DiceCollection::displayCollection()
	{
		
		//pre: none 
		//post: it will display the each die in the bag
		Die *tempPtr=ArrayPtr;
		
		for (int x=0; x<ArraySize; ++x) 
		{
			cout << " DICE # "<<x+1;
			
			cout <<tempPtr[x]<<endl;
			
		}
		
	}
	int DiceCollection::getCollectionSize()
	{
		//pre: none
		//post: it will return the size of the array.
		return ArraySize;
	}
	void DiceCollection::CollectDice(Die Obj, int increase)
	{
		
		//pre: a die object and a value to be increase has to be passed
		//post:
		Die *temp = new Die[ArraySize+increase];
		
		copy(ArrayPtr,ArrayPtr+ArraySize, temp);
	
		for (int g=ArraySize; g<ArraySize+increase; ++g) 
		{
			temp[g]=Obj;
			
		}
		ArrayPtr=temp;
		ArraySize += increase;
		
	}
	void DiceCollection::RemoveFromCollection()
	{
		
		//pre:none
		//post: it will remove one die from the bag.
		int remove=1;
		Die *tempPtr=new Die[ArraySize];
		
	
		cout << "the array size is "<<ArraySize<<endl;
		
		 //it keeps on doing until its true.//removes the first element
		
		/*
		do
		{
			cout << "which # of dice would you like to remove: "<<endl;
			cout << "the number has to be less or equals to "<<ArraySize<<endl;
			cin>>remove;
			
		}while (remove >= ArraySize);
		*/
		cout << "**********************************************"<<endl;
		cout << endl;
		cout << endl;
		cout << endl;
		cout << endl;
		cout << "it will remove the first die from the bag: "<<endl;
			
		
		if (remove==1) {
			copy(ArrayPtr+1, ArrayPtr+ArraySize, tempPtr);
			ArrayPtr=tempPtr;
			ArraySize-=1;
			
			cout << "the array size is after removing one is: "<<ArraySize<<endl;
		}
	
			
	}
	void DiceCollection::merge2Collections(DiceCollection two)
	{
		
		//pre: a dicecollection object has to be passed. 
		//post: it will return an object;
		int size1= this->getCollectionSize();
		int size2= two.getCollectionSize();
		int combineSize=size1+size2;
		
		cout << "the size of the first collection is: "<<size1<<endl;
		
		cout << "the size of the second collection is: "<<size2<<endl;
		
		Die * temp= new Die[combineSize];
		
		cout << "This is where we start the comvination: "<<endl;
		
		
		for (int y=0; y<size2; ++y) {
			temp[y]=two.getDie(y); //it will 
			
		}
		for (int x=size2; x<combineSize; ++x) {
			
			temp[x]=ArrayPtr[x-size2];
			
			
			
		}
		
		
		for (int u=0; u<combineSize; ++u) {
		cout << "Die# "<<u+1<<" $$$$$$$$$$$$$$$$$$$$$$$$$$"<<endl;	
		cout << temp[u];
		}
		
	}

	Die  DiceCollection::getDie(int x)
	{
		//pre: an integer number for the number of dice in the arrey you want to be returned
		//post: a die will be return
		
		return ArrayPtr[x];
	}

}
