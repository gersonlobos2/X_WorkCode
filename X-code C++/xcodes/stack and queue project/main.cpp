/**************************************************************************
 // Professor Gerson Lobos
 // Data Structures
 // FILES:		main.cpp	//my work
 card.h		//from class but changed
 card.cpp	//from class but changed
 node2.h		//from the book
 node2.hh	//from the book
 bag5.h		//from the book
 bag5.hh		//from the book
 queue.h
 queue.hh
 stack4.h
 stack4.hh
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
 |	tailPtr 			|	Node<Card>*		|Pointer to the head of the second licked list.
 |  previousPtr			|	Node<Card>*		|Pointer to the head of the third licked list.
 |	collection1			|	bag<node<Card>*>|container of a node card pointer
 |	collection2			|	bag<node<Card>*>|container of a node card pointer
 |	collection3			|	bag<node<Card>*>|container of a node card pointer
 |	start				|node_iterator<Card>|start of the iterator for the node link list
 |	position			|node_iterator<Card>|cursor for the iterator
 |	finish				|node_iterator<Card>|the end of the iterator
 |	ST					|	stack<Card>		|stack container
 |	QU					|	queue<Card>		|queue container
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
 |   cassert	| used in node								|
 |	stack		| used in main								|
 |	queue		| used in main								|
 -------------------------------------------------------------
 
 //**************************************************************************
 // PREPROCESSOR
 //************************************************************************* */
#include <iostream>
#include "node2.h"
#include "stack4.h"
#include "queue.h"
#include "bag5.h"
#include "card.h"
#include <cassert>    // Provides assert
#include <cstdlib>
#include <ctime>

using namespace Gela;
using namespace GelaS;
using namespace GelaQ;
using namespace std;

stack<Card> Recurcion_Collection_To_Stack(stack<Card>,bag<Card>);
bag<Card> Recursion_Stack_to_Collection(stack<Card>,bag<Card>);

int main () {
	srand(time(0));
	
	typedef Card ValueType;//$
	//collections
	bag<Card> collection1;
	bag<Card> collection2;
	bag<Card> collection3;
	Card temp; //needed for temp card 
	//**************************creating the node with cards
	ValueType data;//$
	node<Card> * HeadPtr;//$
	node<Card> * TailPtr;//$
	node<Card> * PreviousPtr;//$
	HeadPtr=NULL;//$
	TailPtr=NULL;//$
	
	//used for temporal values
	node<Card> * cursor;
	int size;
	//**************************** stack and queue declarations
	stack<Card> ST;
	queue<Card> QU;
	//***************************

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
	
	node_iterator<Card> start(HeadPtr);
	node_iterator<Card> finish;
	node_iterator<Card> position;
	
	cout << "the link list deck of cards: "<<endl;
	
	for(position = start; position != finish; ++ position)
	{
		cout << *position;
	}
	cout << endl;
	cout << "press enter to continue."<<endl;
	cin.ignore().get();
	
	//we are going to put the cards in the collection
	
	cursor=HeadPtr;
	size = list_length(HeadPtr);
	for (int i=0; i<size; ++i) {
		collection1.insert(cursor->data());
		cursor=cursor->link();
	}
	cout << "the size of the first collection is: "<<collection1.size()<<endl;
	
	//taking random cards from collection1 and puting them in the collection2
	size = collection1.size()/2;
	
	for (int i = 0; i < size; ++i) 
	{
		temp = collection1.grab();
		collection2.insert(temp);
		collection1.erase_one(temp);
	}
	//taking random cards from collection1 and puting them in the collection3
	size = collection1.size();
	for (int i=0; i<size; ++i) {
		temp = collection1.grab();
		collection3.insert(temp);
		collection1.erase_one(temp);
	}
	cout << "*********************"<<endl;
	cout << "we took random cards from the first collection and put them randomly in the"<<endl;
	cout << "second collection and the other half in the third collection."<<endl;
	cout << "first collection size: "<<collection1.size()<<endl;
	cout << "second collection size: "<<collection2.size()<<endl;
	cout << "third collection size:"<<collection3.size()<<endl;
	
	//puting back the cards in the first collection one by one from the other two collections
	size=collection2.size();
	for (int i=0; i<size; ++i) {
		
		temp = collection2.grab();
		collection1.insert(temp);
		collection2.erase_one(temp);
		
		temp = collection3.grab();
		collection1.insert(temp);
		collection3.erase_one(temp);
	}
	cout << "*********************"<<endl;
	cout << "we took the cards from the collections 2 and 3 and put them "<<endl;
	cout<<"back in the first collection"<<endl;
	cout << "first collection size: "<<collection1.size()<<endl;
	cout << "second colleciont size: "<<collection2.size()<<endl;
	cout << "third colleciont size: "<<collection3.size()<<endl;
	
	cout << endl;
	cout << "press enter to continue."<<endl;
	cin.ignore().get();
	cout<<"the shufle cards in the collection."<<endl;
	
	for(bag<Card> :: iterator i = collection1.begin(); i != collection1.end(); ++i) 
	{ 
		cout << *i;
	}
	cout << "press enter to continue: "<<endl;
	cin.ignore().get();
	
	//taking all the cards from the collection1 and put them into the stack
	
	size = collection1.size();
	
	for (int i=0; i<size; ++i) {
		temp = collection1.grab();
		ST.push(temp);
		collection1.erase_one(temp);
	}
	cout << "*********************"<<endl;
	cout << "we took the cards from the collection one and put them into the stack."<<endl;
	cout << "first collection size: "<<collection1.size()<<endl;
	cout << "stack size: "<<ST.size()<<endl;
	
	// taking 10 cards from the stack and pushing them into the queue
	
	for (int i=0; i<10; ++i) {
		temp = ST.top();
		QU.push(temp);
		ST.pop();
	}
	cout << "*********************"<<endl;
	cout << "we took 10 cards from the stack and put them in the queue"<<endl;
	cout << "stack size: "<<ST.size()<<endl;
	cout << "queue size: "<<QU.size()<<endl;
	//taking the cards from the queue and pushing them back into the collection1
	size = QU.size();
	for (int i=0; i<size; ++i) {
		temp=QU.front();
		collection1.insert(temp);
		QU.pop();
	}
	cout << "*********************"<<endl;
	cout << "we took the cards from que queue and stored them back into the first collection."<<endl;
	cout <<"queue size: "<<QU.size() <<endl;
	cout << "first collection size: "<<collection1.size()<<endl;
	cout << "*********************"<<endl;
	
	cout << "press enter to continue"<<endl;
	cin.ignore().get();
	//	************************  RECURSIVE FUNCTIONS  ************************
	stack<Card> ST2;
	
	ST2 = Recurcion_Collection_To_Stack(ST2,collection1);
	cout << "using the recursive function to take cards from collection to stack"<<endl;
	cout <<"stack size: "<<ST2.size()<<endl;
	
	collection1 = Recursion_Stack_to_Collection( ST2, collection1);
	cout << "using the recursive function to take cards from stack to collection"<<endl;
	cout << "collection size: "<<collection1.size()<<endl;
	
	cout << "End Program ";
	cin.ignore().get();
	
    return EXIT_SUCCESS;
}
//*********		RECURSIVE FUNCTION COLLECTION TO A STACK ****************
stack<Card> Recurcion_Collection_To_Stack(stack<Card> ST,bag<Card> collection)
{
	Card temp;
	if (collection.size()==0) 
	{
		return ST;
	}
	else {
		temp = collection.grab();
		ST.push( temp);
		collection.erase_one(temp);
		ST = Recurcion_Collection_To_Stack(ST,collection);
	}

	return ST;
}
//*************   RECURSIVE FUCTION STACK TO COLLECTION   *****************
bag<Card> Recursion_Stack_to_Collection(stack<Card> ST,bag<Card> collection)
{
	Card temp;
	if (ST.size()==0) {
		return collection;
	}
	else {
		temp = ST.top();
		collection.insert(temp);
		ST.pop();
		collection = Recursion_Stack_to_Collection(ST,collection);
	}

	return collection;
}
