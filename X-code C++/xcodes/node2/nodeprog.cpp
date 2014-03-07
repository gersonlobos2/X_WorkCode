//  ****************************************************************************
//  Name: Gerson Lobos
//  Name: Professor Branca 
//  Date:
//  COMSC 110 Computer Programming II
//  Assignment #: 2
//  File Name: nodeprog.cpp
//  Compiler Used: Xcode
//  ****************************************************************************

// Problem Statement ********************************************************** 
/*
 Create a linked list of 100 nodes that contain randomly generated numbers.
 Use the headInsert() and listInsert() functions to insert additional nodes 
 into the list.
 Use the listSearch() function to search for a randomly generated number in 
 the list and remove it from the list.
 Make a copy of the list into another list using the listCopy() function.
 Display the data in your list using the listDisplay() function. This function  
 was added to the Toolkit by Professor Branca.
 Clear all the nodes out of the list using the listClear() function.

 
 // My Data Requirements ********************************************************** 
 
 Node * headPtr2;      pointer to node		pointer to the begining of the list
 Node * tailPtr2;      pointer to node		pointer to the end of the list
 Node * prevPtr2;	   pointer to node		pointer to the previoust pointer
 int insert2;			integer value		user input to insert a node
 int remover			integer value		user input to remove a value.
 int size				integer value		default value to size of the array


*/
// *****************************************************************************
// Professor Branca
// October 7, 2010
// FILE: nodeprog.cpp
// Modified Main & Savage Node class
// Modifications Made: See modification list in node.h
// *****************************************************************************

// *****************************************************************************
#include <iostream>
#include <cassert>    // Provides assert
#include <cstdlib>    // Provides NULL and size_t
#include "node.h"
#include <ctime>

using namespace std;
// *****************************************************************************

// *****************************************************************************
int main()
{
	srand(time(0));
   	typedef double valueType;
	
	Node * headPtr;				//will point to first node in list
	Node * tailPtr; 			//will point to last node in list

 	Node * prevPtr; 			//will be used for inserting nodes
	Node * cursPtr; 			//will be used for searching list
	size_t length;  			//for storing list length
	valueType data;			//for storing data
	
	
	int size=5;            //this has to be changed to a 100 in order to get the list with a 
							// size of 100.
	
	
	headPtr = NULL;			//initialize head and tail pointers
	tailPtr = NULL;
	
	data = 10.0;				//initialize data
	
	listHeadInsert(headPtr, data);	//insert first node
	data = 1+rand()%50;				//set next node data
	tailPtr = headPtr;				//set tail pointer
	prevPtr = headPtr;				//set previous pointer
	
	for (int i = 0; i < size; i++)		// add more nodes to list
	{
		listInsert(prevPtr, data);		//insert new node
		prevPtr = prevPtr->getLink();		//set previous pointer
		tailPtr = prevPtr;				//set tail pointer
		data = 1+rand()%50;				//set next node data
	}
	
	length = listLength(headPtr);						//get list length
	cout << endl << "Length of this list = " << length << endl;
	
	listDisplay(headPtr);	// display data in list
	
	int remover;
	cout << " Enter the value you want to remove: "<<endl;
	cin>>remover;
	
	
	cursPtr = listSearch(headPtr, remover);
	//cursPtr = listSearch(headPtr, remover);	//find node with data=remover
	//cout<<"yoyo the one i want to remove is: "<<cursPtr->getData()<<"the addres is"<<cursPtr<<endl;
	
	
	if (cursPtr != NULL)
		cout << endl << "Data value ="<< remover<<" has been found!" << " at "
		<< cursPtr << endl;
	
	listRemove(cursPtr,headPtr,remover);			//remove data=40 node
	size-=1;
	
	//listHeadRemove(headPtr);					//remove first node
	
	listDisplay(headPtr);					// display data in list
	
	//my work starts from here.
	
	valueType data2, data3;
	data2 = 11.11;
	data3 = 33.33;
	listHeadInsert(headPtr, data2);
	cout<<"after i inserted the head ptr: "<<endl;
	listDisplay(headPtr);
	
	int insert2;
	cout<<"before what value do you want to insert (33.33 default number ): "<<endl;
	cin>>insert2;
	Node * temp;
	temp = listSearch(headPtr, insert2);
	
	listInsert(temp, data3);
	
	listDisplay(headPtr);
	
	
	Node * headPtr2;
	Node * tailPtr2;
	Node * prevPtr2;
	headPtr2=NULL;
	tailPtr2=NULL;
	listHeadInsert(headPtr2, 0);
	
	tailPtr2=headPtr2;
	prevPtr2=headPtr2;
	
	for (int i = 0; i < size; i++)
	{
		listInsert(prevPtr2, 0.0);
		prevPtr2=prevPtr2->getLink();
		tailPtr2=prevPtr2;
	}
	
	cout<<"the second list was created as a copy from the first one"<<endl;
	
	listCopy(headPtr, headPtr2, tailPtr2);
	listDisplay(headPtr2);
	listClear(headPtr);
	listClear(headPtr2);
	
	
	
	
	cout << "Please press enter once or twice to continue...";
	cin.ignore().get();    		// hold console window open
	return EXIT_SUCCESS;
}

