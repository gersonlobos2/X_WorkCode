// *****************************************************************************
// Professor Branca
// October 7, 2010
// FILE: node.cpp
// Modified Main & Savage Node class
// Modifications Made: See modification list in node.h
// *****************************************************************************

// *****************************************************************************
// IMPLEMENTS: The functions of the Node class and the
// 	linked list toolkit (see node.h for documentation).
// INVARIANT for the Node class:
//   The data of a node is stored in dataField, and the link in linkField.
// *****************************************************************************

// *****************************************************************************
#include "node.h"
#include <cassert>    // Provides assert
#include <cstdlib>    // Provides NULL and size_t
#include <iostream>
#include <fstream>
#include "card.h"
#include <iomanip>
#include <ctime>


using namespace std;
// *****************************************************************************

// *****************************************************************************
// NODE CLASS MEMBER FUNCTIONS
// *****************************************************************************
// CONSTRUCTOR
Node::Node ( const valueType & initData , Node * initLink )
{
	dataField = initData;
	linkField = initLink;
}

// *****************************************************************************
// MUTATOR FUNCTIONS
void Node::setData( const valueType & newData )
{
	dataField = newData;
}

void Node::setLink(Node * newLink)
{
    linkField = newLink;
}

// *****************************************************************************
// ASSESSOR FUNCTIONS
Node::valueType Node::getData( ) const
{
    return dataField;
}

// const function to return linkField
const Node * Node::getLink( ) const
{
    return linkField;
}

// non const function to return linkField
Node * Node::getLink( )
{
    return linkField;
}
// *****************************************************************************

// *****************************************************************************
// LINKED LIST TOOLKIT NON-MEMBER FUNCTIONS
// *****************************************************************************
size_t listLength(const Node * headPtr)
{
    const Node * cursor;		//already in template
    size_t answer;
	
    answer = 0;
    for (cursor = headPtr; cursor != NULL; cursor = cursor->getLink( ))
	    ++answer;
	
    return answer;
}

// *****************************************************************************
void listHeadInsert(Node *& headPtr, const Node::valueType & entry)
{
    headPtr = new Node(entry, headPtr);			//already in template
}

// *****************************************************************************
void listInsert(Node * previousPtr, const Node::valueType & entry)
{
    Node * insertPtr;			//already in template
	
    insertPtr = new Node(entry, previousPtr->getLink( ));
    previousPtr->setLink(insertPtr);
}

// *****************************************************************************
Node * listSearch(Node * headPtr, const Node::valueType & target)
{
    Node * cursor;    //already in template
	
    for (cursor = headPtr; cursor != NULL; cursor = cursor->getLink( ))
	    if (target == cursor->getData( ))
			return cursor;
    return NULL;
}

// *****************************************************************************
const Node * listSearch(const Node * headPtr, const Node::valueType & target)
{
    const Node * cursor;		//already in template
	
    for (cursor = headPtr; cursor != NULL; cursor = cursor->getLink( ))
	    if (target == cursor->getData( ))
		    return cursor;
    return NULL;
}

// *****************************************************************************
Node * listLocate(Node * headPtr, size_t position)
{
    Node * cursor;		//already in template
    size_t i;
	
    assert (0 < position);
    cursor = headPtr;
    for (i = 1; (i < position) && (cursor != NULL); i++)
	    cursor = cursor->getLink( );
    return cursor;
}

// *****************************************************************************
const Node * listLocate(const Node * headPtr, size_t position)
{
	const Node * cursor;
	size_t i;							//already in template
    
	assert (0 < position);
	cursor = headPtr;
	for (i = 1; (i < position) && (cursor != NULL); i++)
	    cursor = cursor->getLink( );
	return cursor;
}

// *****************************************************************************
void listHeadRemove(Node *& headPtr)
{
	Node * removePtr;
											//already in template
	removePtr = headPtr;
	headPtr = headPtr->getLink( );
	delete removePtr;
}

// *****************************************************************************
void listRemove(Node * previousPtr)
{
	Node * removePtr;
											//already in template
	removePtr = previousPtr->getLink();
	previousPtr->setLink(removePtr->getLink( ));
	delete removePtr;
}


// *****************************************************************************
void listClear(Node *& headPtr)  //already in template
{
    while (headPtr != NULL)
	    listHeadRemove(headPtr);
}

// *****************************************************************************
void listCopy(const Node * sourcePtr, Node *& headPtr, Node *& tailPtr)
{
	headPtr = NULL;						//already in template
	tailPtr = NULL;
	
	// Handle the case of the empty list.
	if (sourcePtr == NULL)
	    return;
    
	// Make the head node for the newly created list, and put data in it.
	listHeadInsert(headPtr, sourcePtr->getData( ));
	tailPtr = headPtr;
    
	// Copy the rest of the nodes one at a time,adding at the tail of new list.
	sourcePtr = sourcePtr->getLink( );
	while (sourcePtr != NULL)
	{
	    listInsert(tailPtr, sourcePtr->getData( ));
	    tailPtr = tailPtr->getLink( );
	    sourcePtr = sourcePtr->getLink( );
	}
}

// *****************************************************************************
void listDisplay( const Node * headPtr)
{
	
	size_t length = listLength(headPtr);
	const Node * cursor = headPtr;
	
	cout << endl;
	
	 //display data and memory addresses in the list
	for (size_t i = 0; i < length; i++)
	{
	
		
		(cursor->getData()).printCard();
		cout << endl;
		cursor=cursor->getLink();

	}
}
ostream& operator <<(ostream& out, Node * Phead)
{
	int length=listLength(Phead);
	/*
	for (int i= 1; i<=length; ++i) {
		out<<"the card is: "<< (Phead->getData()).getRank()<<setw(5)<<(Phead->getData()).getSuit()
		<<setw(5)<<(Phead->getData()).getPicked()<<endl;
		Phead=Phead->getLink();
	}*/
	for (int i=1; i<=length; ++i) {
		
	
	int rank = (Phead->getData()).getRank();
	switch (rank)
    {
		case 1    :    cout << setw(7) << "Rank:" << setw(9) << "Ace";
			break;
		case 2    :
		case 3    :
		case 4    :
		case 5    :
		case 6    :
		case 7    :
		case 8    :
		case 9    :
		case 10   :    out << setw(7) << "Rank:" << setw(9) << rank;
			break;
		case 11   :    out << setw(7) << "Rank:" << setw(9) << "Jack";
			break;
		case 12   :    out << setw(7) << "Rank:" << setw(9) << "Queen";
			break;
		case 13   :    out << setw(7) << "Rank:" << setw(9) << "King";
			break;
		default   :    out << "Error!";
    }
	
	string str;
	int suit=(Phead->getData()).getSuit();
	
    switch (suit)
    {
		case 1    :    str = "Hearts";
			break;
		case 2    :    str = "Diamonds";
			break;
		case 3    :    str = "Spades";
			break;
		case 4    :    str = "Clubs";
			break;
		default   :    str = "Error!";
    }
	
    out << setw(11) << "Suit:" << setw(10 ) << str;       // print suit
	string str2;
		
		(Phead->getData()).setPicked(true);      //cant make it to set picked equals to true;
	bool picked = (Phead->getData()).getPicked();
		
    switch (picked)
    {
		case false      :    str2 = "False";
			break;
		case true       :    str2 = "True";
			break;
		default         :    str2 = "Error!";
    }
	
    out << setw(13) << "Picked:" << setw(7) << str2;
		
		
	Phead=Phead->getLink();
		out<<endl;
	
	}	
	return out;
}
Node* findLink(Node* find,int at)
{
	//pre: a pointer has to be passed and an integer that was the possition of the card in the deck
	//post: an address will be return pointing to the possition of the card.
	Node *cursor = find;
	for (int find=1; find<=at; ++find) {
		cursor = cursor->getLink();
	}
	//(cursor->getData()).setPicked(true);
	return cursor;
}
Node* setNodeDeck()
{
	typedef Card ValueType;//$
	//Card deck[DECKSIZE];          // for static array of cards
	//Card * cards;                 // for dynamic arrays of cards
	
	//int numCards;                 // for number of cards in array
	
	ValueType data;//$
	Node * HeadPtr;//$
	Node * TailPtr;//$
	Node * PreviousPtr;//$
	HeadPtr=NULL;//$
	TailPtr=NULL;//$
	//Card targeta;
	
	
	// createDeck(HeadPtr);
	listHeadInsert(HeadPtr, data);
	TailPtr=HeadPtr;
	PreviousPtr=HeadPtr;
	
	
	for (int i = 1; i <= 4; i++)
	{
		for (int x = 1; x <= 13; x++)
		{
			data.setCard(x,i);
			listInsert(PreviousPtr, data);
			PreviousPtr=PreviousPtr->getLink();
			TailPtr=PreviousPtr;
		}
	}
	return HeadPtr;

}
//********************************************************
Node* GenerateNodeCards(Node * headPtr,int size)
{
	
	int deckCard; //store the random card picked.
	Node* HeadPtr2;
	//Node* TailPtr2;
	//Node* PreviousPtr2;
	HeadPtr2=NULL;
	//TailPtr2=NULL;
	Node *cursor;
	
	for (int i = 0; i < size; i++)
	{
		cursor=headPtr;
		
		deckCard = rand() % DECKSIZE;
		
		//cursor = findLink(HeadPtr,deckCard);
		cursor=listLocate(headPtr, deckCard);
		
		
		while ( (cursor->getData()).getPicked() )
		{
			deckCard = rand() % DECKSIZE;
		}
		(cursor->getData()).setPicked(true);  //it is suposed to set the value of picked = true
		
		//bool check=(cursor->getData()).getPicked(); //in here i am geting the value of picked from the card
		// i wanted to see if it was set to true 
		//but for soe reason it wont work.
		
		
		listHeadInsert(HeadPtr2, cursor->getData());
		//tempGenerate[i] = cursor->getData();    //storing the picked card into an array.
	}
	return HeadPtr2;
}
