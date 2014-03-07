/*
 Paul Velasco
 October 13, 2010
 FILE: nodeprog.cpp
 Modified Main & Savage Node class
 Modifications Made: See modification list in node.h
 
 
 
 
 
 
 
 */
#include <iostream>
#include <cassert>    // Provides assert
#include <cstdlib>    // Provides NULL and size_t
#include <ctime>
#include "node.h"

using namespace std;
// *****************************************************************************

// *****************************************************************************
int main()
{
    srand (time(0));
   	typedef double valueType;
	
    Node * newheadPtr;
    Node * newPtr;
    Node * newtailPtr;
	
	Node * headPtr;				//will point to first node in list
	Node * tailPtr; 			//will point to last node in list
	Node * prevPtr; 			//will be used for inserting nodes
	Node * cursPtr; 			//will be used for searching list
	size_t length;  			//for storing list length
	valueType data;			//for storing data
	
	newtailPtr = NULL;
    newheadPtr = NULL;
	headPtr = NULL;			//initialize head and tail pointers
	tailPtr = NULL;
	data = 10.0;				//initialize data
	
	listHeadInsert(headPtr, data);	//insert first node
	listHeadInsert(newheadPtr,0);
    data = data*2;				//set next node data
	tailPtr = headPtr;				//set tail pointer
	prevPtr = headPtr;				//set previous pointer
	
    newtailPtr = newheadPtr;
    newPtr = newheadPtr;
	
	
	
	for (int i = 0; i < 5; i++)		// add more nodes to list
	{
		listInsert(prevPtr, data);		//insert new node
		prevPtr = prevPtr->getLink();		//set previous pointer
		tailPtr = prevPtr;				//set tail pointer
		data = data*2;				//set next node data
	}
	
	listInsert(prevPtr,40);
	
	for (int i = 0; i < 100; i++)		// add more nodes to list
	{
		listInsert(newPtr, 0);		//insert new node
		newPtr = newPtr->getLink();		//set previous pointer
		newtailPtr = newPtr;				//set tail pointer
	}
	
	
	
	length = listLength(headPtr);						//get list length
	cout << endl << "Length of this list = " << length << endl;
	
	listDisplay(headPtr);					// display data in list
	
	listCopy(headPtr,newheadPtr,newtailPtr);
	
    listDisplay(newheadPtr);
    
    
	cursPtr = listSearch(headPtr, 40);			//find node with data=40
	
	if (cursPtr != NULL)
		cout << endl << "Data value = 40 has been found!" << " at "
		<< cursPtr << endl;
	
	listRemove(cursPtr);//remove data=40 node
	
	
	
	listHeadRemove(headPtr);					//remove first node
    
	
	listDisplay(headPtr);				// display data in list
	
	listClear(newheadPtr);
	
    
	
    
	cout << "Please press enter once or twice to continue...";
	cin.ignore().get();    		// hold console window open
	return EXIT_SUCCESS;
}

