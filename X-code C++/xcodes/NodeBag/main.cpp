
/**************************************************************************
 // Professor Gerson Lobos
 // Data Structures
 // October 27, 2010
 // FILES:		main.cpp	//my work
				card.h		//from class but changed
				card.cpp	//from class but changed
				node2.h		//from the book
				node2.hh	//from the book
				bag5.h		//from the book
				bag5.hh		//from the book
 //compler: Xcode
 //**************************************************************************
 // Problem Statement ********************************************************** 
 
 
 //**************************************************************************
 Description:
 1-A link list of cards is created
 2-cards are picked randomly from the link list and stored in another link list and then 
	passed to the collection 2.
 3-then more random cards are selected from the first link list and stored in a third link list 
	then in the third collection.
 4-cards are picked from the two random random picked cards and stored in the first collection
	but they are stored by geting one of each, each time. 
 5-a node itereator is used to display each colection.
 
 // Data Requirements **********************************************************
 --------------------------------------------------------------------------------
 |  NAME of Variable	|	Type			|	Description
 --------------------------------------------------------------------------------
 |	numCards			|	int				|It will hold the number of cards generated.
 |  HeadPtr				|	Node<Card>*		|Pointer to the head of the first licked list.
 |	HeadPtr2			|	Node<Card>*		|Pointer to the head of the second licked list.
 |  HeadPtr3			|	Node<Card>*		|Pointer to the head of the third licked list.
 |	HeadPtr4			|	Node<Card>*		|Pointer to the head of the fourth licked list.
 |	collection1			|	bag<node<Card>*>|container of a node card pointer
 |	collection2			|	bag<node<Card>*>|container of a node card pointer
 |	collection3			|	bag<node<Card>*>|container of a node card pointer
 |	start				|node_iterator<Card>|start of the iterator for the node link list
 |	position			|node_iterator<Card>|cursor for the iterator
 |	finish				|node_iterator<Card>|the end of the iterator
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
 |   cassert	| used in node							|
 -------------------------------------------------------------
 
 //**************************************************************************
 // PREPROCESSOR
 //************************************************************************* */
#include <iostream>
#include "node2.h"
#include "bag5.h"
#include "card.h"
#include <cassert>    // Provides assert
#include <cstdlib>
#include <ctime>

using namespace Gela;

using namespace std;
int main () {
	srand(time(0));
   
	typedef Card ValueType;//$
	//collections
	bag<node<Card>*> collection1;
	bag<node<Card>*> collection2;
	bag<node<Card>*> collection3;
	//**************************creating the node with cards
	ValueType data;//$
	node<Card> * HeadPtr;//$
	node<Card> * TailPtr;//$
	node<Card> * PreviousPtr;//$
	HeadPtr=NULL;//$
	TailPtr=NULL;//$

	
	
	// createDeck(HeadPtr);
	list_head_insert(HeadPtr, data);
	TailPtr=HeadPtr;
	PreviousPtr=HeadPtr;
	
	
	for (int i = 1; i <= 4; i++)
	{
		for (int x = 1; x <= 13; x++)
		{
			data.setCard(x,i);
			list_insert(PreviousPtr, data);
			PreviousPtr=PreviousPtr->link();
			TailPtr=PreviousPtr;
		}
	}
	list_head_remove(HeadPtr);
	//creating a link list of randomly selected cards
	
	node<Card>* HeadPtr2 = NULL;
	node<Card>* cursor2 = NULL;
	
	
	int tempNum;
	for (int i=0; i<list_length(HeadPtr)/2; ++i) {
		
		tempNum = (rand() % 52) +1;
		cursor2 = list_locate(HeadPtr, tempNum); //locate a random card in the first deck.
		list_head_insert(HeadPtr2, cursor2->data()); //locate a card in the first deck.
		collection2.insert(cursor2); //Insert the random card into the new collection2.
		
	}
	//creating a lik list of randomly selected cards
	node<Card>* HeadPtr3 = NULL;
	

	for (int i=0; i<list_length(HeadPtr)/2; ++i) {
		
		tempNum = (rand() % 52) +1;
		cursor2 = list_locate(HeadPtr, tempNum); //locate a random card in the first deck.
		list_head_insert(HeadPtr3, cursor2->data()); //locate a card in the first deck.
		collection3.insert(cursor2); //Insert the random card into the new collection2.
		
	}
	//*************************display the hole node of cards
	
	cout << "display the complete deck of cards"<<endl;
	
	node_iterator<Card> start(HeadPtr);
	node_iterator<Card> finish;
	node_iterator<Card> position;
	
	cout << "the iterator"<<endl;
	
	for(position = start; position != finish; ++ position)
	{
		cout << *position;
	}
	//***************************
	cout << "Press enter to continue:";
	cin.ignore().get();
	cout << "display the second collection of randomly selected cards"<<endl;
	node_iterator<Card> start2(HeadPtr2);
	node_iterator<Card> finish2;
	node_iterator<Card> position2;
	
	cout << "the iterator"<<endl;
	
	for(position2 = start2; position2 != finish2; ++ position2)
	{
		cout << *position2;
	}
	//***************************
	cout << "Press enter to continue:";
	cin.ignore().get();
	cout << "display the third collection of randomly selected cards"<<endl;
	node_iterator<Card> start3(HeadPtr3);
	node_iterator<Card> finish3;
	node_iterator<Card> position3;
	
	cout << "the iterator"<<endl;
	
	for(position3 = start3; position3 != finish3; ++ position3)
	{
		cout << *position3;
	}
	//****************************checking the amount of cards in each collection
	int temp1=list_length(HeadPtr2);
	int temp2=list_length(HeadPtr3);
	
	cout << "there are "<< temp1<<" cards in the second collection"<<endl;
	cout << "there are "<< temp2<<" cards in the third collection"<<endl;
	cout << "Press enter to continue:";
	cin.ignore().get();
	
	
	//****************************puting the cards in the collection 2 and 3 into the collection 1
	
	node<Card>* HeadPtr4 = NULL;

	
	
	for (int i=0; i<list_length(HeadPtr)/2; ++i) {
		
		
		cursor2 = list_locate(HeadPtr2, i+1); 
		list_head_insert(HeadPtr4, cursor2->data()); //locate a card in the first deck.
		collection1.insert(cursor2);
		
		cursor2 = list_locate(HeadPtr3, i+1);
		list_head_insert(HeadPtr4, cursor2->data());
		collection1.insert(cursor2); //Insert the random card into the new collection2.
		
	}
	//***********************displaying the shufle cards that are in the collection
	cout << "Press enter to continue:";
	cin.ignore().get();
	
	
	//********************displaying the complete deck with random cards
	cout << "collection of shufle cards:";
	
	node_iterator<Card> start4(HeadPtr4);
	node_iterator<Card> finish4;
	node_iterator<Card> position4;
	
	cout << "the iterator"<<endl;
	
	for(position4 = start4; position4 != finish4; ++ position4)
	{
		cout << *position4;
	}
	cout << "Press enter to continue:";
	cin.ignore().get();
	cout << "the collection 2 has:"<<collection2.size()<<" random cards"<<endl;
	cout << "the collection 3 has:"<<collection3.size()<<" random cards"<<endl;
	cout << "the collection 1 has:"<<collection1.size()<<" random cards"<<endl;
	
	
	
	
	cin.ignore().get();
	
    return EXIT_SUCCESS;
}
