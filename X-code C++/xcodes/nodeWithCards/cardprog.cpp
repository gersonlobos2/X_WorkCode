/**************************************************************************
// Professor Gerson Lobos
// Data Structures
// October 27, 2010
// FILES:   cardprog.cpp
			card.h
			card.cpp
			node.h
			node.cpp
//compler: Xcode
//**************************************************************************
// Problem Statement ********************************************************** 


//**************************************************************************
 Description:
 1- a integer is declared that will store the size of the generated lincked list
 2- a node pointer is declared that will store the header of a whole linked list of cards
 3- an overloaded operator to displey the list will be used.
 4- it asks the used how many cards wants to pick from the deck
 5- the cards will be picked and stored in a linked list.
 6-the picked cards will be displayed fallowed by the entire deck
 
// Data Requirements **********************************************************
 --------------------------------------------------------------------------------
 |  NAME of Variable	|	Type	|	Description
 --------------------------------------------------------------------------------
 |	numCards			|	int		|It will hold the number of cards generated.
 |  HeadPtr				|	Node*	|Pointer to the head of the first licked list.
 |	headPtr2;			|	Node *	|Pointer to the head of the second licked list.
 --------------------------------------------------------------------------------
//**************************************************************************
 Processing
 
 Formulas    rand()%(DECKSIZE); used in implementation
 
		-------------------------------------------------------------
		|	Libreries	|			Place used						|
		-------------------------------------------------------------
		|	ctime		| used in implementations					|
		|	iostream	| used main									|
		|	fstream 	| used in headers and implementations		|
		|	string		| used in implementations					|
		|	cstdlib		| used in node.h node.cpp and in main		|
		|	iomanip		| used in implementations					|
		|   cassert		| used in node.cpp							|
		-------------------------------------------------------------

//**************************************************************************
// PREPROCESSOR
//************************************************************************* */
#include <iostream>               // provides I/O
#include <cstdlib>                // for exit() and rand()
#include "card.h"                 // provides card class
#include "node.h"

using namespace std;              // uses standard namespace items
int main()
{
	int numCards;                 //variable that will be sed
	Node*HeadPtr = setNodeDeck();

	//listDisplay(HeadPtr);
	cout <<HeadPtr;     //overloded operator to display the licked list
	(HeadPtr->getData()).setPicked(true);
	cout << "How many cards do you want to generate?" << endl;
	cin >> numCards;									//to store the amount of the generated cards
	
	Node * headPtr2;								//declaring the head pointer to store the generated cards
	headPtr2 = GenerateNodeCards(HeadPtr,numCards); //calling the function to create the deck in the link list

	cout << "these are the generated cards: "<<endl;

	cout << headPtr2;
	
	cout << "the complete deck is: "<<endl;
	
	cout << "Please press enter once or twice to continue...";
	cin.ignore().get();
	
	cout << HeadPtr;
		cout << "It is over ;-) ";
	cin.ignore().get();    		// hold console window open
	return EXIT_SUCCESS;
}


